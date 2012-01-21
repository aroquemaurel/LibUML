package eltGraphique;

import eltGraphique.eltModelisation.ActeurActif;
import eltGraphique.eltModelisation.ElementModelisation;
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
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe ActeurActif
 * 
 * @see ActeurActif
 */
public class ActeurActifTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
    private ElementModelisation acteur;

	/**
	 * Initialisation du champ avant chaque test
	 */
    @Before
    public void setUp() {
        this.acteur = new ActeurActif(new mxGraph(),
                                         new Diagramme(), 
                                         "test", new Position(42,42));
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
	 * Test unitaire qui teste la création du style de l'acteur actif
	 * en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un acteur actif
	 *  - l'inclusion d'un autre élément soit impossible
	 *  - l'opacite est correcte
	 *  - la couleur du texte est correcte
	 *  - la couleur de la bordure est correcte
	 */
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

	/**
	 * Test unitaire qui vérifie l'application du style sur l'acteur actif
	 * en recupérant le style de la cellule liée à l'acteur actif
	 * 
	 * Vérifie que :
	 *  - le style de la cellule est ACTEUR_ACTIF
	 */
    @Test
    public void testApplicationStyle(){
		assertEquals("ACTEUR_ACTIF", this.acteur.getCellule().getStyle());
    }

	/**
	 * Test unitaire qui teste la création de la cellule en vérifiant
	 * que l'attribut n'est pas null
	 * 
	 * Vérifie que :
	 *  - L'attribut cellle du champ n'est pas null
	 */
    @Test
    public void testCreerCelluleNotNull(){
		assertNotNull(this.acteur.getCellule());
    }

	/**
	 * Test unitaire que teste l'instanciation du champ
	 * 
	 * Vérifie que :
	 *  - le champ est une instance de la classe ActeurActif
	 */
    @Test
    public void testInstance(){
		assertTrue(this.acteur instanceof ActeurActif);
    }

	/**
	 * Test unitaire qui teste l'acteur actif n'a pas d'élément parent
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
	 * Test unitaire qui teste l'acteur actif n'a pas d'élément cible
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
	 * Test unitaire qui teste la modification du texte lié à l'acteur actif
	 * 
	 * Vérifie que :
	 *  - le texte est modifié correctement
	 */
    @Test
    public void testSetTexte(){
        this.acteur.setTexte("testouille");
        assertEquals("testouille", this.acteur.getTexte());
    }

	/**
	 * Test unitaire qui teste la modification de la cellule
	 * lié à l'acteur actif
	 * 
	 * Vérifie que :
	 *  - la cellule actuelle a bien été remplacée
	 *  - la cellule cible est la même que la cellule courante
	 *  - la cellule parent est la mee que la cellule courante
	 */
	@Test
	public void testSetCellule(){
		mxCell maCellule = new mxCell();
		this.acteur.setCellule(maCellule);
		assertEquals(maCellule, this.acteur.getCellule());
		assertEquals(maCellule, this.acteur.getParent());
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