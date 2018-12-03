package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne{
    
    public int niveau;
    public List<Licence> listeLicence=new LinkedList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int niv) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau=niv;
    }
    
    public void ajouteLicence(Licence l){
        listeLicence.add(l);
    }
}
