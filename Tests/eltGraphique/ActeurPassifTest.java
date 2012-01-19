package eltGraphique;

import eltGraphique.eltModelisation.ElementModelisation;
import eltGraphique.eltModelisation.ActeurPassif;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;
import util.Constantes;
import diagramme.Diagramme;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActeurPassifTest {
	private ElementModelisation acteur;

    @Before
    public void setUp() {
		this.acteur = new ActeurPassif(new mxGraph(), 
									   new Diagramme(), 
									   "un super test");
        this.acteur.creer();
    }

    @After
    public void tearDown() {
		this.acteur = null;
    }

    @Test
    public void testCelluleParent(){
        mxICell cellule = this.acteur.getParent();
        assertEquals(cellule, this.acteur.getCellule());
	}
	
    @Test
	public void testCelluleTarget() {
		mxICell cellule = this.acteur.getTarget();
		assertEquals(cellule, this.acteur.getCellule());
    }

    @Test
    public void testCellule(){
		mxICell cellule = this.acteur.getCellule();
		assertEquals(cellule, this.acteur.getCellule());
    }

    @Test
    public void testInstance(){
		assertTrue(this.acteur instanceof ActeurPassif);
    }

    @Test
    public void testCreationStyle() {
		mxStylesheet feuilleStyles = this.acteur.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("ACTEUR_PASSIF"));
		assertEquals(mxConstants.SHAPE_RECTANGLE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_SHAPE));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_OPACITY));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_FONTCOLOR));
		assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_STROKECOLOR));
    }
	
    @Test
    public void testStyle(){
            assertEquals("ACTEUR_PASSIF", this.acteur.getCellule().getStyle());
    }

    @Test
    public void testSetTexte(){
        this.acteur.setTexte("Nouveau Texte");
        assertEquals("Nouveau Texte", this.acteur.getTexte());
    }

    @Test
    public void testSetCelluleParent(){
		mxCell maCellulle = new mxCell();
		this.acteur.setCellule(maCellulle);
		assertEquals(maCellulle, this.acteur.getParent());
    }

    @Test
    public void testSetCelluleTarget(){
		mxCell maCellulle = new mxCell();
		this.acteur.setCellule(maCellulle);
		assertEquals(maCellulle, this.acteur.getTarget());
    }

    @Test
    public void testSupprimer(){
		this.acteur.supprimer();
		assertNull(this.acteur.getCellule());
    }

}