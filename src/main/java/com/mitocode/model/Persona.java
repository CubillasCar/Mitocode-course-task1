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
@Table(name="persona")
public class Persona {

    @Schema(description = "Id Identity")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    @Schema(description = "Nomnbres del paciente")
    @NotNull
    @Size(min = 3, message = "{nombres.size}")
    @Column(name = "nombres", nullable = false, length = 70)
    private String nombres;

    @Schema(description = "Apellidos del paciente")
    @NotNull
    @Size(min=3, message = "{apellidos.size}")
    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

}
