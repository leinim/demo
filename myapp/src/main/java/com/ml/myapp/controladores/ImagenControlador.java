package com.ml.myapp.controladores;

import com.ml.myapp.servicios.ImagenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    
    @Autowired
    private ImagenServicio imagenServicio;
    
}
