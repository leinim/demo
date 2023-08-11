package com.ml.myapp.controladores;

import com.ml.myapp.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
}
