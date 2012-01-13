package eltGraphique;

import diagramme.Diagramme;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;
import static org.junit.Assert.*;

/**
 *
 */
public class CasUtilisationTest {
	private ElementModelisation casUtilisation;

    @Before
    public void setUp() {
		this.casUtilisation= new CasUtilisation(new mxGraph(), 
												new Diagramme(),
												"casUtilisationPourLesTests");
        this.casUtilisation.creer();
    }

    @After
    public void tearDown() {
		this.casUtilisation = null;
    }

    @Test
    public void testCelluleParent() {
        mxICell cellule = this.casUtilisation.getParent();
        assertEquals(cellule, this.casUtilisation.getCellule());
	}
	
	@Test
	public void testCelluleTarget() {
		
        mxICell cellule = this.casUtilisation.getTarget();
        assertEquals(cellule, this.casUtilisation.getCellule());
	}

	@Test
	public void testInstance(){
		assertTrue(this.casUtilisation instanceof CasUtilisation);
	}

	@Test
	public void testStyle(){
		assertEquals("USECASE", this.casUtilisation.getCellule().getStyle());
	}
	
	@Test
	public void testCreerStyle() {
		assertTrue(this.casUtilisation.getGraph().getStylesheet().getStyles().containsKey("USECASE"));
	}
	
	@Test
	public void testChampsStyle() {
		mxStylesheet feuilleStyles = this.casUtilisation.getGraph().getStylesheet();
		assertEquals(mxConstants.SHAPE_ELLIPSE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_SHAPE));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_OPACITY));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_FONTCOLOR));
		assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_STROKECOLOR));
	}

    @Test
    public void testSetTexte(){
		this.casUtilisation.setTexte("testouille");
        assertEquals("testouille", this.casUtilisation.getTexte());
    }

	@Test
	public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.casUtilisation.setCellule(maCellulle);
		assertEquals(maCellulle, this.casUtilisation.getParent());
		assertEquals(maCellulle, this.casUtilisation.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.casUtilisation.supprimer();
        assertNull(this.casUtilisation.getCellule());
    }
}