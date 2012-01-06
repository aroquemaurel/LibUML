package eltGraphique;


import com.mxgraph.model.mxCell;
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
		this.monActeur.setCellule(null);
        this.monActeur = null;
    }
	@Test
	public void testCreer1(){
		assertNotNull(this.monActeur.getCellule());
	}

	@Test
	public void testCreer2(){
		assertTrue(this.monActeur instanceof ActeurActif);
	}

	@Test
	public void testCreer3(){
		assertEquals("ACTEUR", this.monActeur.getCellule().getStyle());
	}

    @Test
    public void testGetCellule(){
        mxICell maCellule1 = this.monActeur.getParent();
        assertEquals(maCellule1, this.monActeur.getCellule());

        mxICell maCellule2 = this.monActeur.getTarget();
        assertEquals(maCellule2, this.monActeur.getCellule());
    }

    @Test
    public void testSetTexte(){
        this.monActeur.setTexte("testouille");
        assertEquals("testouille", this.monActeur.getTexte());
    }

	@Test
	public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.monActeur.setCellule(maCellulle);
		assertEquals(maCellulle, this.monActeur.getParent());
		assertEquals(maCellulle, this.monActeur.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.monActeur.supprimer();
        assertNull(this.monActeur.getCellule());
    }
}