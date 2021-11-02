package com.example.hibernateboot.dao;

import com.example.hibernateboot.domain.Owner;
import com.example.hibernateboot.domain.cars.Car;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OwnerDAO {

    private final SessionFactory sessionFactory;
    private final CarDAO carDao;

    public long save(Owner owner) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        long id = (long) session.save(owner);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public Owner load(long id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Owner.class);
        criteria.add((Restrictions.eq("id", id)));
        Owner owner = (Owner) criteria.uniqueResult();
        List<Car> car = owner.getCar();
        session.close();
        return owner;
    }
}
