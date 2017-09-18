
package com.worknest.controller;

import com.worknest.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.worknest.repository.PersonRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/test")
public class PersonController {
    
    private final PersonRepository personRepository;
    public int contadorRegistros = 0;
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping
    public List<Person> listPerson(){
        return personRepository.findAll();
    }
    
    /*Método que agrega un elemento a la base de datos*/
    @RequestMapping(method = RequestMethod.POST, path = "/lista")
    public String agregarElemento(@RequestParam(value = "fname") String fname,
            @RequestParam(value = "lname") String lname){
        personRepository.save(new Person(fname, lname));
        return "inserted";
    }
    
    /*Método que agrega un elemento a la base de datos*/
    @RequestMapping(method = RequestMethod.POST, path = "/jasonBody", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String agregarElementoJSON(@RequestBody Person persona){
        personRepository.save(persona);
        return "agregado";
    }
    
    /*Método que modifica un elemento a la base de datos*/
    @RequestMapping(method = RequestMethod.PUT, path = "/jasonBody", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String modificarElementoJSON(@RequestBody Person persona){
        personRepository.save(persona);
        return "modificado";
    }
    /*Método que elimina un elemento de la base de datos*/
    @RequestMapping(method = RequestMethod.DELETE, path = "/deleteJason", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String eliminarElemento(@RequestBody Person persona){
        personRepository.delete(persona);
        return "borrado";        
    }
    
    /*Leer un elemento en especifíco*/
    @GetMapping("/leer")
    public Person listPerso(@RequestParam (value="idPersona", required = true, defaultValue = "0") Long idPersona){
       
        /*Se crea un objeto de tipo persona con el médoto findOne que busca el id de la persona*/
        Person persona = personRepository.findOne(idPersona);
        if (persona!=null) {
           return persona;
        }else{
            return null;
        }
      
 
    }
    
    /*Actualizar un elemento de la base de datos*/
    @RequestMapping(method = RequestMethod.POST, path = "/actualiza", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person actualizaElemento(@RequestBody Person persona){
        return persona;
    }
    
    /*Removiendo un registro de la base de datos con id*/
    @RequestMapping("/borrado")
    public String deletePerson(@RequestParam (value="idPersona", required = true, defaultValue = "0") Long idPersona){
      
      
        personRepository.delete(idPersona);        
        return "Borrado";
    }
    
    /*Removiendo un registro de la base de datos con nombre y apellido*/
    @RequestMapping(method = RequestMethod.POST, path = "/leer")
    public String showPerson(@RequestParam (value="lname", required = true, defaultValue = "null") String lname){
      
        
        return "null";
    }

    
    
    
}
