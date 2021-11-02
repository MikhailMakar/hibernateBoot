package com.example.hibernateboot.controller;

import com.example.hibernateboot.dao.EstateDAO;
import com.example.hibernateboot.domain.Estate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class HelloController {

    private final EstateDAO estateDAO;

    @GetMapping()
    public String sayHello() {
        Estate estate = new Estate();
        estate.setType("flat");
        estate.setCity("London");
        Long save = estateDAO.save(estate);
        return "Hello, estate_id: " + save;
    }
}
