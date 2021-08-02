
import com.entities.Activite;
import com.entities.TypeActivite;
import com.imp.ActivityImp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User PC
 */
public class TesteMain {
    
    
    public static void main(String[] args){
        /*ActivityImp ac = new ActivityImp();
        Activite a =new Activite();
        
        TypeActivite activite = new TypeActivite();
        activite.setId(0);
        activite.setLibelle("codage");
        activite.setDateCreation(LocalDate.parse("2021-10-25", DateTimeFormatter.ISO_DATE));
        
        a.setDateDebut(LocalDate.parse("2021-07-25", DateTimeFormatter.ISO_DATE));
        a.setDateFin(LocalDate.parse("2021-08-25", DateTimeFormatter.ISO_DATE));
        a.setTypeActivite(activite);
        
       // ac.addActivite(a);
       ac.getEquipeThisActivite(0);*/
        LocalDate.now();
        
       Date d = new Date();
        System.out.println(LocalDate.now());
       
               
    }
}
