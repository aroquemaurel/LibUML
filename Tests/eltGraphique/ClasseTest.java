package eltGraphique;

import diagramme.Diagramme;
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
		this.classe = new Classe (new mxGraph(), 
                                          new Diagramme(), 
                                          "un super test");
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
	public void testCreerCellule (){
        mxICell maCellule = this.classe.getCellule();
        assertEquals(maCellule, this.classe.getCellule());
	}

	@Test
	public void testCreerInstance(){
		assertTrue(this.classe instanceof Classe );
	}

	@Test
	public void testCreerStyle(){
		assertEquals("CLASSE", this.classe.getCellule().getStyle());
	}


    @Test
    public void testSetTexte(){
        this.classe.setTexte("testouille");
        assertEquals("testouille", this.classe.getTexte());
    }

	@Test
	public void testSetCelluleParent(){
		mxCell maCellulle = new mxCell();
		this.classe.setCellule(maCellulle);
		assertEquals(maCellulle, this.classe.getParent());
	}
	
	@Test
	public void testSetCelluleTarget(){
		mxCell maCellulle = new mxCell();
		this.classe.setCellule(maCellulle);
		assertEquals(maCellulle, this.classe.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.classe.supprimer();
        assertNull(this.classe.getCellule());
    }

	@Test
	public void testGenererChaineMethodes(){

	}

	@Test
	public void testGenererChaineAttributs(){

	}

	@Test
	public void testAjouterMethode(){

	}

	@Test
	public void testAjouterAttribut(){

	}
	
	@Test
	public void testEstConstante(){

	}
	
	@Test
	public void testEstAbstraite(){

	}
	
	@Test
	public void testGetAttributs(){

	}
	
	@Test
	public void testGetMethodes(){

	}
	
	@Test
	public void testGetVisibilite(){

	}
	
	@Test
	public void testSetVisibilite(){

	}
	
	@Test
	public void testSetAbstraite(){

	}
	
	@Test
	public void testSetConstante(){

	}
	
	@Test
	public void testSetAttributs(){

	}
	
	@Test
	public void testSetMethodes(){

	}
	
	@Test
	public void testCreerStyleClasse(){

	}
	
	@Test
	public void testCreerStyleContenuclasse(){

	}
	
	
    // TODO ajouter des tests pour Classe

}