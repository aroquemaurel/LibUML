package eltGraphique;


import com.mxgraph.view.mxGraph;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author satenske
 */
public class ActeurActifTest {
    private Acteur monActeur;

    @Before
    public void setUp() {
        this.monActeur = new ActeurActif(new mxGraph(), new String("test"));
    }

    @After
    public void tearDown() {
        this.monActeur = null;
    }
    
    @Test
    public void testSetNom(){
        this.monActeur.setNom("testouille");
        assertEquals("testouille", this.monActeur.getNom());
    }
    
    @Test
    public void testAfficher() {
        this.monActeur.afficher();
        assertTrue(this.monActeur.getCellule().isVisible());
    }

}