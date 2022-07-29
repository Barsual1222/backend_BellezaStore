package com.bellezastore.Controlador;

import com.bellezastore.Dto.ProductoDto;
import com.bellezastore.Modelo.Categoria;
import com.bellezastore.Modelo.Producto;
import com.bellezastore.Servicio.CategoriaServicio;
import com.bellezastore.Servicio.Impl.ProductoServiceImpl;
import com.bellezastore.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoServiceImpl service;

    @GetMapping
    public ResponseEntity<Object> Listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<ProductoDto> Agregar(@RequestBody ProductoDto productoDto){
        return service.agregar(productoDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Long id){
        return service.productoPorId(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@RequestBody Producto p, @PathVariable("id") Long id){
        p.setId((long) id);
        return service.editar(p,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto>Eliminar(@PathVariable("id") Long id){
        return service.Eliminar(id);
    }
}



