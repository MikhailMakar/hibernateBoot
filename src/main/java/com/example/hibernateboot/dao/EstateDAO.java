package com.example.hibernateboot.dao;

import com.example.hibernateboot.domain.Estate;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstateDAO {

    private final SessionFactory sessionFactory;

    public Long save(Estate estate) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(estate);
        session.getTransaction().commit();
        session.close();
        return id;
    }
}
