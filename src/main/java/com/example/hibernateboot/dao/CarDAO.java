package com.example.hibernateboot.dao;

import com.example.hibernateboot.domain.cars.Car;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarDAO {

    private final SessionFactory sessionFactory;

    public long save(Car car) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        long id = (long) session.save(car);
        session.getTransaction().commit();
        session.close();
        return id;
    }
}
