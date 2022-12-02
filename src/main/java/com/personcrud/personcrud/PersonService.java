package com.personcrud.personcrud;

import java.util.List;

public interface PersonService {

    public List<Person> getAll();

    public Person getPersonById(Long id);

    public Person savePerson(Person person);

    public Person updatePerson(Person person, Long id);

    public void deletePerson(Long id);

}
