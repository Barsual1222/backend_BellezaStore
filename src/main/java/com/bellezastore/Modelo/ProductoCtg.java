package com.bellezastore.Modelo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ProductoCtg")
public class ProductoCtg {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long categoria_id;

    private Long producto_id;


}