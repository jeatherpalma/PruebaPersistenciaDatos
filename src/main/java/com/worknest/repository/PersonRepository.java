/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.worknest.repository;

import com.worknest.entity.Person;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;




/**
 *
 * @author WorkNest7
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    @Procedure
    void insertPerson(String fname, String lname);
    
    @Query(value = "SELECT * FROM personOliver", nativeQuery = true)
    List<Person> seleccionaTodasLasPersonas();
    
    @Query(value = "DELETE FROM person WHERE id =?1", nativeQuery = true)
    void borrarUnaPersonaEnEspecifico(Long idpersona);
    
    @Query(value = "SELECT * FROM person WHERE id =?1", nativeQuery = true)
    Person seleccionaUnaPersonaEnEspecifico(Long id);
    
    @Modifying
    @Query(value = "insert into personOliver (fname,lname) VALUES (:fname,:lname)", nativeQuery = true)
    @Transactional
    void agregarPersona(@Param("fname") String fname, @Param("lname") String lname);
    
    @Modifying
    @Query(value = "update person set fname=:nombre, lname=:apellido where id=:idPersona", nativeQuery = true)
    @Transactional
    void actualizarPersona(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("idPersona")Long id);
    
    
    
    
    
    
}
