
package com.metier;

import com.entities.Developpeur;
import java.util.List;


public interface IDeveloppeur {
    
    public int addDev(Developpeur dev);
    public Developpeur getDevById(int id);
    public int updateDev(Developpeur developpeur);
    public int deleteDev(int id);
    public List<Developpeur> getAllDev();
}
