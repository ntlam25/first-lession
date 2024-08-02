package com.example.first_lession.service.impl;

import com.example.first_lession.dto.request.PersonRequest;
import com.example.first_lession.dto.response.PersonResponse;
import com.example.first_lession.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class AlternativeDemoService implements DemoService {

  @Override
  public PersonResponse upperCaseString(PersonRequest person){
    PersonResponse personResponse = new PersonResponse();
    String name = person.getName();
    personResponse.setName(new StringBuilder(name).reverse().toString());
    personResponse.setAge(person.getAge());
    String hobbies = person.getHobbies();
    personResponse.setHobbies(new StringBuilder(hobbies).reverse().toString());
    return personResponse;
  }
}
