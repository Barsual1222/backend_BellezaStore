package com.bellezastore.Servicio.Impl;

import com.bellezastore.Modelo.Categoria;
import com.bellezastore.Modelo.Producto;
import com.bellezastore.Repositorio.CategoriaRepositorio;
import com.bellezastore.Servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;


    @Override
    public ResponseEntity<List<Categoria>> listarCategoria() {
        try{
            List<Categoria> categorias = categoriaRepositorio.findAll();
            if (categorias.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(categorias);

        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }

        return null;
    }

    @Override
    public ResponseEntity<Categoria> guardarCategoria(Categoria categoria) {
            try{
                Categoria nuevaCategoria = categoriaRepositorio.save(categoria);
                if (nuevaCategoria == null ){
                    return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(categoria);

            }catch (Exception ex){
                System.out.println("ERROR"+ex);
            }
        return null;
    }

    @Override
    public ResponseEntity<Collection<Producto>> listarProductosporsuCategoria(Long id) {
        Categoria categoria = categoriaRepositorio.findById(id).orElseThrow();
        if (categoria !=null) {
            return new ResponseEntity<>(categoria.getProductos(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
