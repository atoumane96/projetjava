
package com.entities;


public class Developpeur extends Personne{
    
    private String specialite;
    private int role;
    private int idEquipe;
    
    public Developpeur() {
    }

    public Developpeur(int id, String nom, String prenom, String adresse, String telephone, Long photo) {
        super(id, nom, prenom, adresse, telephone, photo);
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }
    
    
    
    
}
