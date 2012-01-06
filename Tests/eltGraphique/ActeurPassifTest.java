/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eltGraphique;

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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
		this.monActeur = new ActeurPassif(new mxGraph(), "un super test");
    }

    @After
    public void tearDown() {
		this.monActeur = null;
    }

	@Test
	public void testCreer (){
        this.monActeur.creer();
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


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}