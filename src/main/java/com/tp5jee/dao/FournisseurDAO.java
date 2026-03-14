package com.tp5jee.dao;

import com.tp5jee.models.Fournisseur;
import com.tp5jee.models.Produit;
import com.tp5jee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FournisseurDAO {
    // Récupérer tous les fournisseurs
    public List<Fournisseur> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Fournisseur> list = session.createQuery("from Fournisseur",
                Fournisseur.class).list();
        session.close();
        return list;
    }
    // Récupérer un fournisseur par id
    public Fournisseur getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Fournisseur f = session.get(Fournisseur.class, id);
        session.close();
        return f;
    }
    // Ajouter ou modifier un fournisseur
    public void saveOrUpdate(Fournisseur fournisseur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(fournisseur);
        tx.commit();
        session.close();
    }
    // Supprimer un fournisseur
    public void delete(Fournisseur fournisseur) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(fournisseur);
        tx.commit();
        session.close();
    }
    // Récupérer un fournisseur par produit
    public Fournisseur getByProduit(Produit produit) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Fournisseur f = session.createQuery(
                        "from Fournisseur f where f.produit.id = :pid",
                        Fournisseur.class)
                .setParameter("pid", produit.getId())
                .uniqueResult();
        session.close();
        return f;
    }
}
