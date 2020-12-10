package com.mitocode.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="producto")

public class Producto {

    @Schema(description = "Id Identity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;


    @Schema(description = "Nombre del producto")
    @NotNull
    @Size(min = 3, message = "{nombres.size}")
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;


    @Schema(description = "Marca del producto")
    @NotNull
    @Size(min = 3, message = "{marca.size}")
    @Column(name = "marca", nullable = false, length = 20)
    private String marca;

}
