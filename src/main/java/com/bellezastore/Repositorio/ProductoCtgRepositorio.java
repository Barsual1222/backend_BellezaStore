package com.bellezastore.Repositorio;

import com.bellezastore.Modelo.ProductoCtg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoCtgRepositorio extends JpaRepository<ProductoCtg,Long> {
}
