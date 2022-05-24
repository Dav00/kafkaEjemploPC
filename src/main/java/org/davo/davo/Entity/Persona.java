package org.davo.davo.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Persona {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String dni;
    String nombre;
    String apellidos;
    int edad;

}
