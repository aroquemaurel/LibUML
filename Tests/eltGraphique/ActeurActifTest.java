package eltGraphique;


import diagramme.Diagramme;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import util.Constantes;
import static org.junit.Assert.*;

/**
 *
 */
public class ActeurActifTest {
    private ElementModelisation acteur;

    @Before
    public void setUp() {
        this.acteur = new ActeurActif(new mxGraph(),
                                         new Diagramme(), 
                                         "test");
        this.acteur.creer();
    }

    @After
    public void tearDown() {
        this.acteur = null;
    }
	
	@Test
	public void testCreerStyle() {
		mxStylesheet feuilleStyles = this.acteur.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("ACTEUR_ACTIF"));
		assertEquals(mxConstants.SHAPE_ACTOR, feuilleStyles.getStyles().get("ACTEUR_ACTIF").get(mxConstants.STYLE_SHAPE));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("ACTEUR_ACTIF").get(mxConstants.STYLE_FOLDABLE));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("ACTEUR_ACTIF").get(mxConstants.STYLE_OPACITY));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("ACTEUR_ACTIF").get(mxConstants.STYLE_FONTCOLOR));
		assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("ACTEUR_ACTIF").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	@Test
	public void testApplicationStyle(){
		assertEquals("ACTEUR_ACTIF", this.acteur.getCellule().getStyle());
	}
	
	@Test
	public void testCreerCelluleNotNull(){
		assertNotNull(this.acteur.getCellule());
	}

	@Test
	public void testInstance(){
		assertTrue(this.acteur instanceof ActeurActif);
	}

    @Test
    public void testCelluleParrent(){
        mxICell cellule = this.acteur.getParent();
        assertEquals(cellule, this.acteur.getCellule());
	}
	
	@Test
	public void testCelluleTarget() {
        mxICell cellule = this.acteur.getTarget();
        assertEquals(cellule, this.acteur.getCellule());
    }

    @Test
    public void testSetTexte(){
        this.acteur.setTexte("testouille");
        assertEquals("testouille", this.acteur.getTexte());
    }

	@Test
	public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.acteur.setCellule(maCellulle);
		assertEquals(maCellulle, this.acteur.getParent());
		assertEquals(maCellulle, this.acteur.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.acteur.supprimer();
        assertNull(this.acteur.getCellule());
    }
	

    // TODO ajouter des tests pour ActeurActif
}