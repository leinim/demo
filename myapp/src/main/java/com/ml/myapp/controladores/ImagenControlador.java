package com.ml.myapp.controladores;

import com.ml.myapp.servicios.ImagenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ImagenControlador {
    
    @Autowired
    private ImagenServicio imagenServicio;
    
}
