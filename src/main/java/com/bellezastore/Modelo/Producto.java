package com.bellezastore.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "producto_id")
    private Long id;
    @Column
    private String nombre;
    @Column
    private String color;
    @Column
    private String marca;
    @Column
    private int precio;
    @Column
    private int cantidad;




}
