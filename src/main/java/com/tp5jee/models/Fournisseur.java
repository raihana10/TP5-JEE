package com.tp5jee.models;

import jakarta.persistence.*;

@Entity
public class Fournisseur {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String email;
    private String telephone;
    @OneToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    // Constructeurs
    public Fournisseur() {}

    public Fournisseur(String nom, String email, String telephone, Produit produit) {
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.produit = produit;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }

}
