package eltGraphique;

import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.eltModelisation.Interface;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe Interface
 * 
 * @see Interface
 */
public class InterfaceTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private Interface monInterface;

	/**
	 * Initialisation du champ avant chaque test
	 */
    @Before
    public void setUp() {
        this.monInterface = new Interface(new mxGraph(), null, new Diagramme(), new Position(42,42));
        this.monInterface.creer();
    }

	/**
	 * Suppression de ce champ après chaque test
	 */
    @After
    public void tearDown() {
        this.monInterface = null;
    }

	/**
	 * Les tests unitaires ne sont pas encore implémentés pour cette classe
	 */
	@Test
	public void testFail() {
		fail("Not implemented yet!");
	}
	
	/*
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
*/
}