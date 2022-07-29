package com.bellezastore.Servicio.Impl;

import com.bellezastore.Dto.ProductoDto;
import com.bellezastore.Modelo.Producto;
import com.bellezastore.Modelo.ProductoCtg;
import com.bellezastore.Repositorio.ProductoCtgRepositorio;
import com.bellezastore.Repositorio.ProductoRepositorio;
import com.bellezastore.Servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServiceImpl implements ProductoServicio {

    @Autowired
    private ProductoRepositorio repositorio;

    @Autowired
    private ProductoCtgRepositorio productoCtgRepositorio ;

    @Override
    public ResponseEntity<Object> listar() {
        try{
            List<Producto> productos = repositorio.findAll();
            if (productos.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productos);

        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }

        return null;
    }

    @Override
    public ResponseEntity<ProductoDto> agregar(ProductoDto productoDto) {
        try{
            if (productoDto != null ){
                Producto producto = new Producto();
                producto.setNombre(productoDto.getNombre());
                producto.setColor(productoDto.getColor());
                producto.setMarca(productoDto.getMarca());
                producto.setPrecio(productoDto.getPrecio());
                producto.setCantidad(productoDto.getCantidad());
                Producto nuevoProducto = repositorio.save(producto);

                ProductoCtg productoCtg= new ProductoCtg();
                productoCtg.setCategoria_id(productoDto.getCategoriaId());
                productoCtg.setProducto_id(producto.getId());
                ProductoCtg nuevoRelacion = productoCtgRepositorio.save(productoCtg);


                return ResponseEntity.ok(productoDto);
            }
            return ResponseEntity.notFound().build();

        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }

        return null;
    }

    @Override
    public ResponseEntity<Producto> productoPorId(Long id) {
        try {
            Producto producto = repositorio.findById(id).orElse(null);
            if (producto == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(producto);
        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    @Override
    public ResponseEntity<Producto> editar(Producto p, Long id) {
        try{
            var ProductoExistente = repositorio.findById(id).get();
            ProductoExistente.setNombre(p.getNombre());
            ProductoExistente.setColor(p.getColor());
            ProductoExistente.setMarca(p.getMarca());
            repositorio.save(ProductoExistente);
            return new ResponseEntity<Producto>(HttpStatus.OK);

        }catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public ResponseEntity<Producto> Eliminar(Long id) {
        try{
            repositorio.deleteById(id);
            productoCtgRepositorio.deleteById(id);
        }catch (Exception ex){
            System.out.println("ERROR"+ex);
        }
        return null;
    }


}
