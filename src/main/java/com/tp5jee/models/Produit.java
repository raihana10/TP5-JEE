package com.tp5jee.models;

import jakarta.persistence.*;

import java.util.List;

//Entity : definir la classe Produit comme une entite JPA(represente une table)
@Entity @Table(name = "produit")
public class Produit {

    @Id//marque champ id comme primary key
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-incrementation de la cle primaire par BD
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prix")
    private double prix;

    @Enumerated(EnumType.STRING)//stocker l'enum sous forme de chaine
    private Category category;

    @OneToOne(mappedBy = "produit", cascade = CascadeType.ALL)
    private Fournisseur fournisseur;

    @ManyToMany(mappedBy = "produits")
    private List<Commande> commandes;

    //constructeurs
    public Produit(){}
    public Produit(String nom , Double prix , Category category){
        this.nom=nom;
        this.prix=prix;
        this.category=category;
    }


    //getters
    public int getId(){ return id; }
    public String getNom(){ return nom; }
    public Double getPrix(){ return prix; }
    public Category getCategory() { return category; }
    public Fournisseur getFournisseur() { return fournisseur; }
    public List<Commande> getCommandes() {
        return commandes;
    }

    //setters
    public void setId(int id){this.id=id;}
    public void setNom(String nom){this.nom=nom;}
    public void setPrix(Double prix){this.prix=prix;}
    public void setCategory(Category category){this.category=category;}
    public void setFournisseur(Fournisseur fournisseur) { this.fournisseur = fournisseur; }
    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

}

