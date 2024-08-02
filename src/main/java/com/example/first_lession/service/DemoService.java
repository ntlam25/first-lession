package com.example.first_lession.service;

import com.example.first_lession.dto.request.PersonRequest;
import com.example.first_lession.dto.response.PersonResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface DemoService {
  PersonResponse upperCaseString( PersonRequest person);

}
