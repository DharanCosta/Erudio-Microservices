package br.com.erudio.service;

import br.com.erudio.model.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.atomic.*;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(String id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Costa");
        person.setAddress("São Paulo - São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
       List<Person> personList = new ArrayList<>();
       for(int i = 0; i < 8; i++){
           Person person = mockPerson(i);
           personList.add(person);
       }
        return personList;
    }

    public Person create(Person person){
        return person;
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Name "+ i);
        person.setLastName("LastName "+ i);
        person.setAddress("City - State - Country" +i);
        person.setGender("Gender "+i);
        return person;
    }
}
