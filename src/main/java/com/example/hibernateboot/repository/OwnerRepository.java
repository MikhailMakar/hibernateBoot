package com.example.hibernateboot.repository;

import com.example.hibernateboot.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByName(String name);
}
