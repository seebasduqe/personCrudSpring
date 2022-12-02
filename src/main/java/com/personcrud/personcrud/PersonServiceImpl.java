package com.personcrud.personcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person, Long id) {
        return null;
    }

    /*        updatePerson.setFirstName(person.getFirstName());
        updatePerson.setLastName(person.getLastName());
        updatePerson.setCellularNo(person.getCellularNo());

        personService.savePerson(updatePerson);
*/
    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
