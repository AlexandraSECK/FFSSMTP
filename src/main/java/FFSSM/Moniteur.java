/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public List<Embauche> myEmbauches=new LinkedList<>(); 

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau);
        this.numeroDiplome = numeroDiplome;
    }

    public Club employeur() {
         // TODO: Implémenter cette méthode
         if(myEmbauches.isEmpty())
             return null;
         Embauche e= myEmbauches.get(myEmbauches.size()-1);
         if(!e.estTerminee()){
             return e.getEmployeur();   
         }
         //Si pas d'employeur
         else 
            return null;               
        }
    
    public void nouvelleEmbauche(Club employeur, Calendar debutNouvelle) {   
         // TODO: Implémenter cette méthode
         Calendar cal = Calendar.getInstance();
                  if(!myEmbauches.isEmpty()){
         if(!this.myEmbauches.get(this.myEmbauches.size()-1).estTerminee())
            this.myEmbauches.get(this.myEmbauches.size()-1).terminer(cal);
                  }
         Embauche e = new Embauche(debutNouvelle, this , employeur);
         myEmbauches.add(e);
    }

    public List<Embauche> emplois() {
         // TODO: Implémenter cette méthode
         return myEmbauches;
    }

}
