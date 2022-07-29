package com.bellezastore.Servicio;

import com.bellezastore.Dto.ProductoDto;
import com.bellezastore.Modelo.Producto;
import org.springframework.http.ResponseEntity;

public interface ProductoServicio {

    ResponseEntity<Object> listar();
    ResponseEntity<ProductoDto> agregar(ProductoDto productoDto);
    ResponseEntity<Producto> productoPorId(Long id);
    ResponseEntity<Producto> editar(Producto producto, Long id);
    ResponseEntity<Producto> Eliminar(Long id);

}
