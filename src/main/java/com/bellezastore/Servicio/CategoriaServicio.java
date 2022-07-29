package com.bellezastore.Servicio;

import com.bellezastore.Modelo.Categoria;
import com.bellezastore.Modelo.Producto;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface CategoriaServicio {

 ResponseEntity<List<Categoria>>listarCategoria();

 ResponseEntity<Categoria> guardarCategoria(Categoria categoria);

 ResponseEntity<Collection<Producto>>listarProductosporsuCategoria(Long id);
}
