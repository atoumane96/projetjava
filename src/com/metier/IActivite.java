/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metier;

import com.entities.Activite;
import com.entities.Developpeur;
import com.entities.Equipe;
import java.util.List;

/**
 *
 * @author User PC
 */
public interface IActivite {
    
    public int addActivite(Activite activite);
    public Activite getActiviteById(int id);
    public int updateActivite(int id,Activite activite);
    public int deleteActivite(int id);
    public List<Equipe> getEquipeThisActivite(int id);
     public List<Activite> getAllActivite();
    public int giveSprintToDev(int id,Developpeur developpeur, String texte);
    
}
