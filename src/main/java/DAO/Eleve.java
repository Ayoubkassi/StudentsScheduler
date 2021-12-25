/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ryota
 */
public class Eleve {
    static int id = 1;
    public String nom;
    public String prenom;
    public String anneeScolaire;
    public String Filiere;
    
    //constructeur par default 

    public Eleve() {
    }
    
    //constructeur avec argument

    public Eleve(String nom, String prenom, String anneeScolaire, String Filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeScolaire = anneeScolaire;
        this.Filiere = Filiere;
        id++;
    }
    
    //getters and setters

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Eleve.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    public String getFiliere() {
        return Filiere;
    }

    public void setFiliere(String Filiere) {
        this.Filiere = Filiere;
    }
    
    
    //to String method

    @Override
    public String toString() {
        return "Eleve{" + "nom=" + nom + ", prenom=" + prenom + ", anneeScolaire=" + anneeScolaire + ", Filiere=" + Filiere + '}';
    }
    
    //la methode Affiche
    
    public void affiche(){
        System.out.println(this.toString());
    }
    
    
    
}


//CREATE DATABASE TD3;
//use TD3;
//
//CREATE TABLE Eleve(
//    id INT(10) PRIMARY KEY AUTO_INCREMENT,
//    nom VARCHAR(20),
//    prenom VARCHAR(20),
//    anneeScolaire VARCHAR(20),
//    filiere VARCHAR(20)
//);


