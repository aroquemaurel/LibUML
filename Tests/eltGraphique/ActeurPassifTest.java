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
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe ActeurPassif
 * 
 * @see ActeurPassif
 */
public class ActeurPassifTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private ElementModelisation acteur;

	/**
	 * Initialisation du champ avant chaque test
	 */
    @Before
    public void setUp() {
		this.acteur = new ActeurPassif(new mxGraph(),  new Diagramme(), "un super test", new Position(42,42));
        this.acteur.creer();
    }

	/**
	 * Suppression de ce champ après chaque test
	 */
    @After
    public void tearDown() {
		this.acteur = null;
    }

	/**
	 * Test unitaire qui teste l'acteur passif n'a pas d'élément parent
	 * 
	 * Vérifie que :
	 *  - la cellule parente est la même que la cellule actuelle
	 */
    @Test
    public void testCelluleParent(){
        mxICell cellule = this.acteur.getParent();
        assertEquals(cellule, this.acteur.getCellule());
	}
	
	/**
	 * Test unitaire qui teste que l'acteur passif n'a pas d'élément cible
	 * 
	 * Vérifie que :
	 *  - la cellule cible est la même que la cellule actuelle
	 */
    @Test
	public void testCelluleTarget() {
		mxICell cellule = this.acteur.getTarget();
		assertEquals(cellule, this.acteur.getCellule());
    }

	/**
	 * Test unitaire qui teste que la methode getCellule retourne
	 * bien la bonne cellule
	 * 
	 * Vérifie que :
	 *  - la cellule renvoyée par getCellule est correcte
	 */
    @Test
    public void testCellule(){
		mxICell cellule = this.acteur.getCellule();
		assertEquals(cellule, this.acteur.getCellule());
    }

	/**
	 * Test unitaire que teste l'instanciation du champ
	 * 
	 * Vérifie que :
	 *  - le champ est une instance de la classe ActeurPassif
	 */
    @Test
    public void testInstance(){
		assertTrue(this.acteur instanceof ActeurPassif);
    }

	/**
	 * Test unitaire qui teste la création du style de l'acteur passif
	 * en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un acteur passif
	 *  - l'inclusion d'un autre élément soit impossible
	 *  - l'opacite est correcte
	 *  - la couleur du texte est correcte
	 *  - la couleur de la bordure est correcte
	 */
    @Test
    public void testCreationStyle() {
		mxStylesheet feuilleStyles = this.acteur.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("ACTEUR_PASSIF"));
		assertEquals(mxConstants.SHAPE_RECTANGLE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_SHAPE));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_FOLDABLE));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_OPACITY));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_FONTCOLOR));
		assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("ACTEUR_PASSIF").get(mxConstants.STYLE_STROKECOLOR));
    }
	
	/**
	 * Test unitaire qui vérifie l'application du style sur l'acteur passif
	 * en recupérant le style de la cellule liée à l'acteur passif
	 * 
	 * Vérifie que :
	 *  - le style de la cellule est ACTEUR_PASSIF
	 */
    @Test
    public void testStyle(){
            assertEquals("ACTEUR_PASSIF", this.acteur.getCellule().getStyle());
    }

	/**
	 * Test unitaire qui teste la modification du texte lié à l'acteur passif
	 * 
	 * Vérifie que :
	 *  - le texte est modifié correctement
	 */
    @Test
    public void testSetTexte(){
        this.acteur.setTexte("Nouveau Texte");
        assertEquals("Nouveau Texte", this.acteur.getTexte());
    }
	
	/**
	 * Test unitaire qui teste la modification de la cellule
	 * lié à l'acteur passif
	 * 
	 * Vérifie que :
	 *  - la cellule actuelle a bien été remplacée
	 *  - la cellule parent est la même que la cellule courante
	 */
    @Test
    public void testSetCelluleParent(){
		mxCell maCellule = new mxCell();
		this.acteur.setCellule(maCellule);
		assertEquals(maCellule, this.acteur.getCellule());
		assertEquals(maCellule, this.acteur.getParent());
    }
	
	/**
	 * Test unitaire qui teste la modification de la cellule
	 * lié à l'acteur passif
	 * 
	 * Vérifie que :
	 *  - la cellule cible est la même que la cellule courante
	 */
    @Test
    public void testSetCelluleTarget(){
		mxCell maCellule = new mxCell();
		this.acteur.setCellule(maCellule);
		assertEquals(maCellule, this.acteur.getTarget());
    }
	
	/**
	 * Test unitaire qui teste al suppression de la cellule liée à l'acteur
	 * 
	 * Vérifie que :
	 *  - la cellule courante est null
	 *  - la cellule cible est null
	 *  - la cellule parent est null
	 */
    @Test
    public void testSupprimer(){
		this.acteur.supprimer();
		assertNull(this.acteur.getCellule());
		assertNull(this.acteur.getParent());
		assertNull(this.acteur.getTarget());
    }

}