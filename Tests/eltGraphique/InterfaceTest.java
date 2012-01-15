package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;

public class InterfaceTest {
        private Interface monInterface;    

    @Before
    public void setUp() {
        this.monInterface = new Interface(new mxGraph(), null, new Diagramme());
        this.monInterface.creer();
    }

    @After
    public void tearDown() {
        this.monInterface = null;
    }

    @Test
    public void testCelluleParent() {
    mxICell cellule = this.monInterface.getParent();
    assertEquals(cellule, this.monInterface.getCellule());
    }
    
    @Test
    public void testCelluleTarget() {

    mxICell cellule = this.monInterface.getTarget();
    assertEquals(cellule, this.monInterface.getCellule());
    }
    
    @Test
    public void testInstance(){
            assertTrue(this.monInterface instanceof Interface);
    }
    
    @Test
    public void testStyle(){
            assertEquals("INTERFACE", this.monInterface.getCellule().getStyle());
    }
    
    @Test
    public void testCreerStyle() {
            assertTrue(this.monInterface.getGraph().getStylesheet().getStyles().containsKey("INTERFACE"));
    }
    
    @Test
    public void testChampsStyle() {
            mxStylesheet feuilleStyles = this.monInterface.getGraph().getStylesheet();
            assertEquals(mxConstants.SHAPE_ELLIPSE, feuilleStyles.getStyles().get("INTERFACE").get(mxConstants.STYLE_SHAPE));
            assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("INTERFACE").get(mxConstants.STYLE_OPACITY));
            assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("INTERFACE").get(mxConstants.STYLE_FONTCOLOR));
            assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("INTERFACE").get(mxConstants.STYLE_STROKECOLOR));
    }
        
    @Test
    public void testSetTexte(){
		this.monInterface.setTexte("testouille");
        assertEquals("testouille", this.monInterface.getTexte());
    }
        
    @Test
	public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.monInterface.setCellule(maCellulle);
		assertEquals(maCellulle, this.monInterface.getParent());
		assertEquals(maCellulle, this.monInterface.getTarget());
	}
    
    @Test
    public void testSupprimer(){
        this.monInterface.supprimer();
        assertNull(this.monInterface.getCellule());
    }

}