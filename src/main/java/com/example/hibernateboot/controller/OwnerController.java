package com.example.hibernateboot.controller;

import com.example.hibernateboot.dao.OwnerDAO;
import com.example.hibernateboot.domain.Owner;
import com.example.hibernateboot.domain.cars.Sedan;
import com.example.hibernateboot.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerDAO ownerDAO;
    private final OwnerRepository ownerRepository;

    @GetMapping("/owner")
    public String getOwner() {
        Owner owner = new Owner();
        owner.setName("Julia");
        owner.setAge(22);

        Sedan car = new Sedan();
        car.setColor("Red");
        car.setComfortClass("Elite");

        owner.setCar(Collections.singletonList(car));
        car.setOwner(owner);

        long id = ownerDAO.save(owner);
        Owner ownerAfterCreating = ownerDAO.load(id);

        return owner.toString();
    }

    @GetMapping("/jpaOwner")
    public String getFromJpa() {
        Optional<Owner> byId = ownerRepository.findById(1L);
        if (byId.isPresent()) {
            return byId.get().toString();
        }
        return "null";
    }

    @GetMapping("/byName")
    public String getByName() {
        Owner john = ownerRepository.findByName("Julia");
        return john.toString();
    }
}
