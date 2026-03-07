package com.tp5jee.dao;

import com.tp5jee.models.Produit;
import com.tp5jee.util.HibernateUtil;
import jakarta.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Stateless

public class ProduitDAO {
    public void addProduit(Produit produit) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(produit);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Produit> getProduits() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("select p from Produit p", Produit.class)
                    .getResultList();
        }
    }

    public boolean deleteProduit(int produitId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
        // Get the product object by ID
            Produit produit = session.get(Produit.class, produitId);
            if (produit != null) {
                session.delete(produit); // Delete the passenger object from the database
                tx.commit(); // Commit the transaction
                return true; // Return true if deletion is successful
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback(); // Rollback in case of any error
            e.printStackTrace();
        } finally { session.close(); } // Always close the session
        return false; // Return false if deletion failed
    }

    public static Produit getProduitById(int produitId) {
        Transaction tx = null;
        Produit produit;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            produit = session
                    .createQuery("select p from Produit p where p.id = :id", Produit.class)
                    .setParameter("id", produitId)
                    .uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        return produit;
    }

    public void updateProduit(Produit produit) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        // Start transaction
            tx = session.beginTransaction();
        // Update the product
            session.update(produit);
        // Commit transaction
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            throw e; // propagate exception
        }
    }
}
