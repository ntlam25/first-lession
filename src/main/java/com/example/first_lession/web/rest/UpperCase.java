package com.example.first_lession.web.rest;

import com.example.first_lession.dto.request.PersonRequest;
import com.example.first_lession.dto.response.PersonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UpperCase {
    @GetMapping("/upper")
    public PersonResponse upperCase(@RequestBody PersonRequest person)
    {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setName(person.getName().toUpperCase());
        personResponse.setAge(person.getAge());
        personResponse.setHobbies(person.getHobbies().toUpperCase());
        return personResponse;
    }
}
