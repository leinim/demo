package com.ml.myapp.servicios;

import com.ml.myapp.repositorios.ArticuloRepositorio;
import com.ml.myapp.repositorios.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServicio {
    
    @Autowired
    private ArticuloRepositorio articuloRepositorio;
    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
}
