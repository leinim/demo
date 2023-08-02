package com.ml.myapp.repositorios;

import com.ml.myapp.entidades.Articulo;
import com.ml.myapp.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepositorio extends JpaRepository<Articulo, String>{
    
    @Query("SELECT a FROM Articulo a WHERE a.titulo = :titulo")
    public Usuario buscarPorTitulo(@Param("titulo") String titulo);
    
}
