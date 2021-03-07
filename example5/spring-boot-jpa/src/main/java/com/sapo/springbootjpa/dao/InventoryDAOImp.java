package com.sapo.springbootjpa.dao;

import com.sapo.springbootjpa.entities.Inventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class InventoryDAOImp implements InventoryDAO {
    private final SessionFactory sessionFactory;

    public InventoryDAOImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Inventory> getAll() {
        Session session = null;
        Transaction trans = null;
        List<Inventory> inventoryList = null;
        try {
            // Khoi tao session lam viec voi ObjectJava
            session = sessionFactory.openSession();
            // Tu session, khoi tao transaction de lam viec
            trans = session.beginTransaction();
            inventoryList = session.createQuery("from inventory ").list();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inventoryList;
    }
}
