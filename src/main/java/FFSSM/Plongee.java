/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    public Set<Plongeur> listePlongeur = new HashSet<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        listePlongeur.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
        for (Plongeur p : listePlongeur) {
            if (!p.listeLicence.isEmpty()) {
                if (!p.listeLicence.get(p.listeLicence.size() - 1).estValide(this.getDate())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
