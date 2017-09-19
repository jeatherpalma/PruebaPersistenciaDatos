
package com.worknest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "personOliver")
@NamedStoredProcedureQuery(
		name = "agregar", 
		procedureName = "insertPerson", 
		parameters = {
                      @StoredProcedureParameter(mode = ParameterMode.IN, name="fname", type=String.class),
                      @StoredProcedureParameter(mode = ParameterMode.IN, name="lname", type=String.class)
		}
)
public class Person implements Serializable{

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;

    public Person() {
    }

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    
    
     /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return fname;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.fname = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return lname;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.lname = apellido;
    }
    
    
    
}
