package com.tp5jee.util;

import com.tp5jee.models.Client;
import com.tp5jee.models.Commande;
import com.tp5jee.models.Fournisseur;
import com.tp5jee.models.Produit;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//pour gérer la session Hibernate
public class HibernateUtil {
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Produit.class)
                        .addAnnotatedClass(Fournisseur.class)
                        .addAnnotatedClass(Commande.class)
                        .addAnnotatedClass(Client.class)
                        .buildSessionFactory();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
    public static Session getSession() {
        return getSessionFactory().getCurrentSession();
    }
    public static void shutdown() {
        getSessionFactory().close();
    }
}
