/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author satenske
 */
public class ActeurPassifTest {
	private Acteur monActeur;

    @Before
    public void setUp() {
		this.monActeur = new ActeurPassif(new mxGraph(), "un super test");
        this.monActeur.creer();
    }

    @After
    public void tearDown() {
		this.monActeur = null;
    }

    @Test
    public void testGetCellule(){
        mxICell maCellule1 = this.monActeur.getParent();
        assertEquals(maCellule1, this.monActeur.getCellule());

        mxICell maCellule2 = this.monActeur.getTarget();
        assertEquals(maCellule2, this.monActeur.getCellule());
	}

	@Test
	public void testCreer1 (){
        mxICell maCellule = this.monActeur.getCellule();
        assertEquals(maCellule, this.monActeur.getCellule());
	}

	@Test
	public void testCreer2(){
		assertTrue(this.monActeur instanceof ActeurPassif);
	}

	@Test
	public void testCreer3(){
		assertEquals(null, this.monActeur.getCellule().getStyle());
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


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}