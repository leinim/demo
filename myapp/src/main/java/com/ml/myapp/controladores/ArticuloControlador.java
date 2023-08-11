package com.ml.myapp.controladores;

import com.ml.myapp.servicios.ArticuloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articulo")
public class ArticuloControlador {
    
    @Autowired
    private ArticuloServicio articuloServicio;
    
}
