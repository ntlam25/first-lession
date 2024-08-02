package com.example.first_lession.service.impl;

import com.example.first_lession.dto.request.PersonRequest;
import com.example.first_lession.dto.response.PersonResponse;
import com.example.first_lession.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DefaultDemoService implements DemoService {
  public PersonResponse upperCaseString(PersonRequest person){
    PersonResponse personResponse = new PersonResponse();
    personResponse.setName(person.getName().toUpperCase());
    personResponse.setAge(person.getAge());
    personResponse.setHobbies(person.getHobbies().toUpperCase());
    return personResponse;
  }
}
