package com.bellezastore.Controlador;

import com.bellezastore.Modelo.Categoria;
import com.bellezastore.Modelo.Producto;
import com.bellezastore.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategoria(){
        return categoriaServicio.listarCategoria();
    }
    @PostMapping
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria){
        return categoriaServicio.guardarCategoria(categoria);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Collection<Producto>>listarProductosporsuCategoria(@PathVariable Long id){
        return categoriaServicio.listarProductosporsuCategoria(id);
    }


}
