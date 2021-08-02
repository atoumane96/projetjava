/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

/**
 *
 * @author User PC
 */
public class ChefDeProjet extends Personne{
    
    private String identifiant;
    private String motDePasse;

    public ChefDeProjet() {
        
    }

    public ChefDeProjet(String identifiant, String motDePasse, int id, String nom, String prenom, String adresse, String telephpone, Long photo) {
        super(id, nom, prenom, adresse, telephpone, photo);
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    
}
