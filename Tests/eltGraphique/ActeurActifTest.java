package eltGraphique;


import com.mxgraph.model.mxICell;
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
        this.monActeur = new ActeurActif(new mxGraph(), "test");
        this.monActeur.creer();
    }

    @After
    public void tearDown() {
        this.monActeur = null;
		//this.monActeur.supprimer();
    }
	@Test
	public void testCreer(){
//		this.monActeur.creer();
		assertNotNull(this.monActeur.getCellule());
	}

    @Test
    public void testGetCellule(){
        mxICell maCellule = this.monActeur.getCellule();
        assertEquals(maCellule, this.monActeur.getCellule());
    }

    @Test
    public void testSetTexte(){
        this.monActeur.setTexte("testouille");
        assertEquals("testouille", this.monActeur.getTexte());
    }

	@Test
    public void testSupprimer(){
        this.monActeur.supprimer();
        assertNull(this.monActeur.getCellule());
    }
}