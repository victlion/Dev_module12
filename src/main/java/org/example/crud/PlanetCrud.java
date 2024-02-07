package org.example.crud;

import jakarta.persistence.Query;
import org.example.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrud {
    public void update(String id, String name) {
        Planet PlanetService = new Planet();
        PlanetService.setId(id);
        PlanetService.setName(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Planet p = session.merge(PlanetService);

        session.persist(p);

        transaction.commit();
        session.close();
    }

    public void create(String id,String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Planet PlanetService = new Planet();
        PlanetService.setId(id);
        PlanetService.setName(name);

        Planet p = session.merge(PlanetService);
        session.persist(p);

        transaction.commit();
        session.close();
    }

    public String read(String id) {
        String result = "";
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query selectQuery = session.createQuery("FROM Planet WHERE id = :planetId");
        selectQuery.setParameter("planetId", id);
        List<Planet> clients = selectQuery.getResultList();

        if (clients != null && !clients.isEmpty()) {
            for (Planet planet : clients) {
                result = "Planet found: " + planet;
            }
        } else {
            result = "Planet with id " + id + " not found.";
        }
        transaction.commit();
        session.close();
        return result;
    }

    public void delete(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Planet planet = session.get(Planet.class, id);
        if (planet != null) {
            session.delete(planet);
            transaction.commit();
        }
        session.close();
    }
}