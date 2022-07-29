package com.bellezastore.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private String nombre;

    private String color;

    private String marca;

    private int precio;

    private int cantidad ;

    private Long categoriaId;





}
