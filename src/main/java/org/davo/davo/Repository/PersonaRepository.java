package org.davo.davo.Repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.davo.davo.Entity.Persona;

import java.util.List;

@Mapper
public interface PersonaRepository{
    @Select("Select * from personas")
    public List<Persona> findAll();

    @Insert("Insert into personas (id, dni, nombre, apellidos, edad) " +
            "values (#{id}, #{dni}, #{nombre}, #{apellidos}, #{edad})")
    public void insert(Persona persona);
}
