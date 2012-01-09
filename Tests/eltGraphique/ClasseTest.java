package eltGraphique;

import eltGraphique.classe.Classe;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ClasseTest {
	private ElementModelisation classe;

    @Before
    public void setUp() {
		this.classe = new Classe (new mxGraph(), "un super test");
        this.classe.creer();
    }

    @After
    public void tearDown() {
		this.classe = null;
    }

    @Test
    public void testGetCellule(){
        mxICell maCellule1 = this.classe.getParent();
        assertEquals(maCellule1, this.classe.getCellule());

        mxICell maCellule2 = this.classe.getTarget();
        assertEquals(maCellule2, this.classe.getCellule());
	}

	@Test
	public void testCreer1 (){
        mxICell maCellule = this.classe.getCellule();
        assertEquals(maCellule, this.classe.getCellule());
	}

	@Test
	public void testCreer2(){
		assertTrue(this.classe instanceof Classe );
	}

	@Test
	public void testCreer3(){
		assertEquals("CLASSE", this.classe.getCellule().getStyle());
	}


    @Test
    public void testSetTexte(){
        this.classe.setTexte("testouille");
        assertEquals("testouille", this.classe.getTexte());
    }

	@Test
	public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.classe.setCellule(maCellulle);
		assertEquals(maCellulle, this.classe.getParent());
		assertEquals(maCellulle, this.classe.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.classe.supprimer();
        assertNull(this.classe.getCellule());
    }

	@Test
	public void testMethodes(){

	}

	@Test
	public void testAttributs(){

	}


    // TODO ajouter des tests pour Classe

}