/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author lnetto
 */
public class FFSSMTest {

    private Club club;
    private Moniteur julien, patrick;

    Club c;
    Moniteur president, mon1;
    Site s1;
    Plongeur p1;

    @Before
    public void setUp() {
        Calendar dateNaissance1 = new GregorianCalendar(1980, 06, 31);
        Calendar dateNaissance2 = new GregorianCalendar(1990, 07, 15);
        Calendar dateNaissance3 = new GregorianCalendar(1987, 07, 15);

        president = new Moniteur("380546", "Duchamp", "Martin", "26 rue Lumière", "0386787878", dateNaissance1, 187, 2);
        mon1 = new Moniteur("258974", "Bernard", "Jean", "12 rue Saint-Marc", "0578986532", dateNaissance2, 184, 3);

        c = new Club(president, "club1", "0298474355");
        s1 = new Site("site1", "blabla");
        p1 = new Plongeur("380547", "Dubois", "Martine", "28 rue Lumière", "0385787878", dateNaissance3, 2);

    }

    @Test
    public void testMoniteur() {
        //Au début il n'a pas d'employeur
        assertEquals(null, mon1.employeur());
        //On lui ajoute une embauche
        Calendar dateEmbauche = new GregorianCalendar(2017, 11, 23);
        Calendar dateEmbauche1 = new GregorianCalendar(2018, 11, 23);

        Calendar dateEmbauche2 = new GregorianCalendar(2017, 11, 23);

        mon1.nouvelleEmbauche(c, dateEmbauche);
        assertEquals(c, mon1.employeur());
        Calendar cal = Calendar.getInstance();
        mon1.myEmbauches.get(mon1.myEmbauches.size() - 1).terminer(cal);
        assertEquals(null, mon1.employeur());
        mon1.nouvelleEmbauche(c, dateEmbauche1);
        mon1.nouvelleEmbauche(c, dateEmbauche2);

    }

    @Test
    public void testPlongee() {
        Plongee p = new Plongee(s1, mon1, Calendar.getInstance(), 30, 25);
        p.ajouteParticipant(p1);
        assertEquals(1, p.listePlongeur.size());
        assertFalse(p.estConforme());
        Calendar ca = new GregorianCalendar(2008, 11, 23);

        Licence l1 = new Licence(p1, "12347", ca, 1, c);
        p1.ajouteLicence(l1);
        assertFalse(l1.estValide(Calendar.getInstance()));
        assertFalse(p.estConforme());

        Licence l2 = new Licence(p1, "12345", Calendar.getInstance(), 1, c);
        p1.ajouteLicence(l2);
        assertTrue(p.estConforme());
    }

    @Test
    public void TestClub(){
                Plongee p = new Plongee(s1, mon1, Calendar.getInstance(), 30, 25);
                c.organisePlongee(p);
                        p.ajouteParticipant(p1);

                assertEquals(1,c.listePlongee.size());
                assertEquals(1,c.plongeesNonConformes().size());
    }
}
