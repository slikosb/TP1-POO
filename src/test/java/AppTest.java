import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AppTest {

    @Test
    public void testNombreMaxOK() {
        Zoo zoo = new Zoo();
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        Exception exc = null;
        try {
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();

        } catch (LimiteVisiteurException e) {
            exc = e;
        }
        assertNull(exc);
    }

    @Test
    public void testNombreMaxKO() {
        Zoo zoo = new Zoo();
        zoo.ajouterSecteur(TypeAnimal.CHAT);
        Exception exc = null;
        try {
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();
            zoo.nouveauVisiteur();

        } catch (LimiteVisiteurException e) {
            exc = e;
        }
        assertNotNull(exc);
        assertEquals(LimiteVisiteurException.class, exc.getClass());
    }

    @Test
    public void CompareSecteur(){
        Zoo zoo = new Zoo();
        Secteur chat = new Secteur(TypeAnimal.CHAT);
        zoo.ajouterSecteur(chat.obtenirType());
        Secteur chien = new Secteur(TypeAnimal.CHIEN);
        zoo.ajouterSecteur(chien.obtenirType());

        zoo.nouvelAnimal(new Chat("Lego", TypeAnimal.CHAT));
        zoo.nouvelAnimal(new Chien("Dudi", TypeAnimal.CHIEN));

        AnimauxComparator test = new AnimauxComparator();

        assertEquals(0, test.compare(zoo.getSecteurFromType(TypeAnimal.CHAT), zoo.getSecteurFromType(TypeAnimal.CHIEN)));

        System.out.println("Nombre d'animaux = " +zoo.nombreAnimaux());
    }
}