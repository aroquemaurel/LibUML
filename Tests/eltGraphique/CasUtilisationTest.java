package eltGraphique;

import eltGraphique.eltModelisation.CasUtilisation;
import eltGraphique.eltModelisation.ElementModelisation;
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
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe CasUtilisation
 * 
 * @see CasUtilisation
 */
public class CasUtilisationTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private ElementModelisation casUtilisation;

	/**
	 * Initialisation du champ avant chaque test
	 */
    @Before
    public void setUp() {
		this.casUtilisation= new CasUtilisation(new mxGraph(), 
                        new Diagramme(), "casUtilisationPourLesTests", new Position(42,42));
        this.casUtilisation.creer();
    }

	/**
	 * Suppression de ce champ après chaque test
	 */
    @After
    public void tearDown() {
		this.casUtilisation = null;
    }

	/**
	 * Test unitaire qui teste que le cas d'utilisation n'a pas d'élément parent
	 * 
	 * Vérifie que :
	 *  - la cellule parente est la même que la cellule actuelle
	 */
    @Test
    public void testCelluleParent() {
        mxICell cellule = this.casUtilisation.getParent();
        assertEquals(cellule, this.casUtilisation.getCellule());
	}
	
	/**
	 * Test unitaire qui teste le cas d'utilisation n'a pas d'élément cible
	 * 
	 * Vérifie que :
	 *  - la cellule cible est la même que la cellule actuelle
	 */
    @Test
    public void testCelluleTarget() {
		mxICell cellule = this.casUtilisation.getTarget();
		assertEquals(cellule, this.casUtilisation.getCellule());
    }

	/**
	 * Test unitaire que teste l'instanciation du champ
	 * 
	 * Vérifie que :
	 *  - le champ est une instance de la classe CasUtilisation
	 */
    @Test
    public void testInstance(){
		assertTrue(this.casUtilisation instanceof CasUtilisation);
    }

	/**
	 * Test unitaire qui vérifie l'application du style sur le cas d'utilisation
	 * en recupérant le style de la cellule liée à le cas d'utilisation
	 * 
	 * Vérifie que :
	 *  - le style de la cellule est USECASE
	 */
    @Test
    public void testStyle(){
		assertEquals("USECASE", this.casUtilisation.getCellule().getStyle());
    }

	/**
	 * Test unitaire qui teste la création du style du cas d'utilisation
	 * en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle du cas d'utilisation
	 *  - l'inclusion d'un autre élément soit impossible
	 *  - l'opacite est correcte
	 *  - la couleur du texte est correcte
	 *  - la couleur de la bordure est correcte
	 */
    @Test
    public void testChampsStyle() {
		mxStylesheet feuilleStyles = this.casUtilisation.getGraph().getStylesheet();
		assertTrue(this.casUtilisation.getGraph().getStylesheet().getStyles().containsKey("USECASE"));
		assertEquals(mxConstants.SHAPE_ELLIPSE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_SHAPE));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_FOLDABLE));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_OPACITY));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_FONTCOLOR));
		assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("USECASE").get(mxConstants.STYLE_STROKECOLOR));
    }

	/**
	 * Test unitaire qui teste que la modification du texte est effective
	 * 
	 * Vérifie que :
	 *  - le nouveau texte est attribué correctement
	 */
    @Test
    public void testSetTexte(){
		this.casUtilisation.setTexte("testouille");
        assertEquals("testouille", this.casUtilisation.getTexte());
    }

	/**
	 * Test unitaire qui teste que la modification d'une cellule est effective
	 * 
	 * Vérifie que :
	 *  - la cellule actuelle est modifiée correctement
	 *  - la cellule parente est modifiée correctement
	 *  - la cellule cible est modifiée correctement
	 */
    @Test
    public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.casUtilisation.setCellule(maCellulle);
		assertEquals(maCellulle, this.casUtilisation.getCellule());
		assertEquals(maCellulle, this.casUtilisation.getParent());
		assertEquals(maCellulle, this.casUtilisation.getTarget());
    }

	/**
	 * Test unitaire qui vérifie que la méthode supprimer fonctionne
	 * correctement
	 * 
	 * Vérifie que :
	 *  - la cellule actuelle est à null
	 *  - la cellule parente est à null
	 *  - la cellule cible est à null
	 */
    @Test
    public void testSupprimer(){
		this.casUtilisation.supprimer();
		assertNull(this.casUtilisation.getCellule());
		assertNull(this.casUtilisation.getParent());
		assertNull(this.casUtilisation.getTarget());
    }
}