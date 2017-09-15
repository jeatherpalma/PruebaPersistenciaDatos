
package com.worknest.controller;

import com.worknest.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.worknest.repository.PersonRepository;
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
    
    /*Método que agrega un elemento a la lista de objetos*/
    @RequestMapping(method = RequestMethod.POST, path = "/lista")
    public String agregarElemento(@RequestParam(value = "fname") String fname,
            @RequestParam(value = "lname") String lname){
        personRepository.save(new Person(fname, lname));
        return "inserted";
    }
    
    /*Leer un elemento en especifíco*/
   @GetMapping("/leer")
    public Person listPerso(@RequestParam (value="ide", required = true, defaultValue = "0") int ide){
        List<Person> miLista = personRepository.findAll();
        
    
        for (int i = 0; i < miLista.size(); i++) {
            if(miLista.get(i).getId() == ide){
                return miLista.get(i);
            }   
       }
        
        return null;
        
       
        
        
        
    }
    
    
    @GetMapping("/insert")
    public String insert(@RequestParam(value = "fname",required = true ,defaultValue = "null")String name,
            @RequestParam(value = "lname",required = true ,defaultValue = "null")String apellido){
        
        personRepository.save(new Person(name, apellido));
        return "inserted";
    
    }
    
    @GetMapping("/delete")
    public String delete(){
        personRepository.delete((long)1);
        return "removido";
    }
    
    
}
