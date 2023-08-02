package com.ml.myapp.controladores;

import com.ml.myapp.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
}
