/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metier;

import com.entities.Developpeur;
import com.entities.Equipe;
import java.util.List;

/**
 *
 * @author User PC
 */
public interface IEquipe {
    
    public int addEquipe(Equipe equipe);
    public Equipe getEquipeById(int id);
    public int updateEquipe(int id);
    public int deleteEquipe(int id);
    public List<Developpeur> getDevThisEquipe(int id);
    public int chooseLeedGroup(int id);
    
}
