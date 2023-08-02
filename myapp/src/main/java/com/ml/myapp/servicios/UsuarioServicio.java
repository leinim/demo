package com.ml.myapp.servicios;

import com.ml.myapp.entidades.Imagen;
import com.ml.myapp.entidades.Usuario;
import com.ml.myapp.enums.Rol;
import com.ml.myapp.errores.MyException;
import com.ml.myapp.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ImagenServicio imagenServicio;
    
    @Transactional
    public void crear(String nombre, String apellido, String email, String password, String password2, MultipartFile archivo) throws MyException {
        validar(nombre, apellido, email, password, password2);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        
        usuario.setAlta(new Date());
        usuario.setRol(Rol.USER);
        
        Imagen imagen = imagenServicio.guardar(archivo);
        usuario.setImagen(imagen);
        
        usuarioRepositorio.save(usuario);
    }

    private void validar(String nombre, String apellido, String email, String password, String password2) throws MyException {
        
        if(nombre.isEmpty() || nombre == null){
            throw new MyException("Debe ingresar su nombre.");
        }
        if(apellido.isEmpty() || apellido == null){
            throw new MyException("Debe ingresar su apellido.");
        }
        if(email.isEmpty() || email == null){
            throw new MyException("Debe ingresar su email.");
        }
        if(!password.equals(password2)){
            throw new MyException("Las claves no coinciden.");
        }
        if(password.isEmpty() || password == null){
            throw new MyException("Debe ingresar una clave.");
        }
        if(password.length() < 6){
            throw new MyException("La clave debe contener un mínimo de seis caracteres.");
        }
        
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        if (usuario != null){
            
            List<GrantedAuthority> permisos = new ArrayList();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            
            permisos.add(p);
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
            
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else{
            return null;
        }    
    }
    
}
