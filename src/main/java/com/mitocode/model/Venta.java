package com.mitocode.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Informacion de la venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="venta")
public class Venta {

    @Schema(description = "Id Identity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;

    @Schema(description = "Fecha de la venta")
    @Column(name="fecha", nullable=false)
    private LocalDateTime fecha;

    @Schema(description = "Importe de la venta")
    @Column(name = "importe", nullable = false)
    @DecimalMin(value = "0", message = "{importe.size}",inclusive = false)
    private double importe;


    @ManyToOne
    @JoinColumn(name="id_persona", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_persona"))
    private Persona persona;


    @OneToMany(mappedBy = "venta", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;
}

