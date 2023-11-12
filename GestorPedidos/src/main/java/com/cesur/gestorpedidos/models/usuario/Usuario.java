package com.cesur.gestorpedidos.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Clase que representa un Usuario de la base de datos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private Integer id;
    private String nombre;
    private String pass;
    private String email;
}
