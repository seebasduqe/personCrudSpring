package com.personcrud.personcrud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        List<Person> persons = personService.getAll();
        if(persons.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(persons);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Person> getPerson(@PathVariable("id") Long id){
        Person person = personService.getPersonById(id);

        if(person == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity <Person> savePerson(@RequestBody Person person){
        Person newPerson = personService.savePerson(person);
        return ResponseEntity.ok(newPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Person> updatePerson(@RequestBody Person person, @PathVariable("id") Long id){

        Person updatePerson = personService.getPersonById(id);

        if (person == null){
            return ResponseEntity.notFound().build();
        }

        updatePerson.setFirstName(person.getFirstName());
        updatePerson.setLastName(person.getLastName());
        updatePerson.setCellularNo(person.getCellularNo());

        personService.savePerson(updatePerson);

        return ResponseEntity.ok(updatePerson);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <Person> deletePerson(@PathVariable("id") Long id){

        Person person = personService.getPersonById(id);

        if(person == null){
            return ResponseEntity.notFound().build();
        }

        personService.deletePerson(id);

        return ResponseEntity.ok(person);
    }

}
