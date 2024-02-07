package org.example.crud;

import jakarta.persistence.*;
import org.example.HibernateUtil;
import org.example.entity.Client;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrud {
    public void update(Long id, String name) {
        Client clientService = new Client();
        clientService.setId(id);
        clientService.setName(name);

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Client p = session.merge(clientService);

        session.persist(p);

        transaction.commit();
        session.close();
    }

    public void create(String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Long count = (Long) session.createQuery("select max(id) from Client").uniqueResult();
        Client clientService = new Client();
        clientService.setId(count + 1);
        clientService.setName(name);

        Client p = session.merge(clientService);
        session.persist(p);

        transaction.commit();
        session.close();
    }

    public String read(Long id) {
        String result = "";
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query selectQuery = session.createQuery("FROM Client WHERE id = :clientId");
        selectQuery.setParameter("clientId", id);
        List<Client> clients = selectQuery.getResultList();

        if (clients != null && !clients.isEmpty()) {
            for (Client client : clients) {
                result = "Client found: " + client;
            }
        } else {
            result = "Client with id " + id + " not found.";
        }
        transaction.commit();
        session.close();
        return result;
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, id);
        if (client != null) {
            session.delete(client);
            transaction.commit();
        }
        session.close();
    }
}