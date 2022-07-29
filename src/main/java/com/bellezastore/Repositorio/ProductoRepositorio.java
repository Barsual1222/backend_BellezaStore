package com.bellezastore.Repositorio;

import com.bellezastore.Modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
