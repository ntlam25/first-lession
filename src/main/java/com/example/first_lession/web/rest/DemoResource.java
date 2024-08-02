package com.example.first_lession.web.rest;

import com.example.first_lession.dto.request.PersonRequest;
import com.example.first_lession.dto.response.PersonResponse;
import com.example.first_lession.service.DemoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoResource {

    private final DemoService demoService;

  public DemoResource(@Qualifier("alternativeDemoService") DemoService demoService) {
    this.demoService = demoService;
  }


  @GetMapping("/upper")
    public PersonResponse upperCaseString(@RequestBody PersonRequest person)
    {
        return demoService.upperCaseString(person);
    }
}
