package com.bellezastore.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long id;
    @Column
    private String nombre;


    @OneToMany
    @JsonBackReference
    @JoinTable(name = "ProductoCtg", joinColumns = @JoinColumn(name = "categoria_id",
            referencedColumnName = "categoria_id"),inverseJoinColumns = @JoinColumn(name = "producto_id",
            referencedColumnName = "producto_id"))
    private Set<Producto> productos = new HashSet<>();
}
