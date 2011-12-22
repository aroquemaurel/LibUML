package eltGraphique;


import com.mxgraph.model.mxCell;
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
        this.monActeur.creer();                
    }

    @After
    public void tearDown() {
        this.monActeur = null;
    }
    @Test
    public void testCreer(){
        mxCell maCellule = this.monActeur.getCellule();
        assertEquals(maCellule, this.monActeur.getCellule());
    }
    @Test
    public void testGetNom(){
        assertEquals("test", this.monActeur.getNom());
    }
    @Test
    public void testSetNom(){
        this.monActeur.setNom("testouille");
        assertEquals("testouille", this.monActeur.getNom());
    }
    
    public void testSupprimer(){
        this.monActeur.supprimer();
        assertNull(this.monActeur.getCellule());
    }
}