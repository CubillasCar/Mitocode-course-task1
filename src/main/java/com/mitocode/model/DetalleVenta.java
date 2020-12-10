package com.mitocode.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int idDetalleVenta;

    @Min(value = 0, message = "{cantidad.size}" )
    @Column(name="cantidad", nullable=false)
    private int cantidad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_venta", nullable=false, foreignKey=@ForeignKey(name="FK_venta_detalle"))
    private Venta venta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_producto", nullable=false, foreignKey= @ForeignKey(name="FK_venta_detalle_producto	"))
    private Producto producto;

}

