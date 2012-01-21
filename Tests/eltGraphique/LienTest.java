package eltGraphique;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import eltGraphique.eltModelisation.Classe;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe Lien
 * 
 * @see Lien
 */
public class LienTest {
	/**
	 * Le champ sur lequel on ferra les tests des liens de composition
	 */
	private Lien lienComposition;
	/**
	 * Le champ sur lequel on ferra les tests des liens d'agrégation
	 */
	private Lien lienAgregation;
	/**
	 * Le champ sur lequel on ferra les tests des liens d'association
	 */
	private Lien lienAssociation;
	/**
	 * Le champ sur lequel on ferra les tests des liens de spécialisation
	 */
	private Lien lienSpecialisation;
	/**
	 * Le champ sur lequel on ferra les tests des flèches
	 */
	private Lien lienFleche;
	
	/**
	 * Initialisation du champ avant chaque test
	 */
	@Before
	public void setUp() {
		this.lienComposition = new 
                        Lien(new Classe(null, null, null, null), 
                        new Classe(null, null, null, null), new mxGraph(), new Diagramme(), TypeLien.COMPOSITION);
		this.lienAgregation = 
                        new Lien(new Classe(null, null, null, null), new Classe(null, null, null, null), 
                        new mxGraph(), new Diagramme(), TypeLien.AGREGATION);
		this.lienAssociation =
                        new Lien(new Classe(null, null, null, null), new Classe(null, null, null, null), 
                        new mxGraph(), new Diagramme(), TypeLien.ASSOCIATION);
		this.lienSpecialisation =
                        new Lien(new Classe(null, null, null, null), new Classe(null, null, null, null), 
                        new mxGraph(), new Diagramme(), TypeLien.SPECIALISATION);
		this.lienFleche = 
                        new Lien(new Classe(null, null, null, null), new Classe(null, null, null, null), 
                        new mxGraph(), new Diagramme(), TypeLien.FLECHE);
		
		this.lienComposition.creer();
		this.lienAgregation.creer();
		this.lienAssociation.creer();
		this.lienSpecialisation.creer();
		this.lienFleche.creer();
	}
	
	/**
	 * Suppression de ce champ après chaque test
	 */
	@After
	public void tearDown() {
		this.lienComposition = null;
		this.lienAgregation = null;
		this.lienAssociation = null;
		this.lienSpecialisation = null;
		this.lienFleche = null;
	}
	
	/**
	 * Test unitaire qui vérifie la création du style des liens de composition
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un lien de composition
	 *  - l'opacite est correcte
	 *  - le déplacement du lien est impossible
	 *  - la couleur du lien est correcte
	 */
	@Test
	public void testCreerStyleComposition() {
		mxStylesheet feuilleStyles = this.lienComposition.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("COMPOSITION"));
		assertEquals(mxConstants.EDGESTYLE_TOPTOBOTTOM, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_DIAMOND, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	/**
	 * Test unitaire qui vérifie la création du style des liens d'agrégation
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un lien d'agrégation
	 *  - l'opacite est correcte
	 *  - le déplacement du lien est impossible
	 *  - la couleur du lien est correcte
	 */
	@Test
	public void testCreerStyleAgregation() {
		mxStylesheet feuilleStyles = this.lienAgregation.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("AGREGATION"));
		assertEquals(mxConstants.EDGESTYLE_TOPTOBOTTOM, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_DIAMOND, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_STROKECOLOR));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_FONTCOLOR));
	}
	
	/**
	 * Test unitaire qui vérifie la création du style des liens d'association
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un lien d'association
	 *  - l'opacite est correcte
	 *  - le déplacement du lien est impossible
	 *  - la couleur du lien est correcte
	 */
	@Test
	public void testCreerStyleAssociation() {
		mxStylesheet feuilleStyles = this.lienAssociation.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("ASSOCIATION"));
		assertEquals(mxConstants.EDGESTYLE_ORTHOGONAL, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_SPACING, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	/**
	 * Test unitaire qui vérifie la création du style des liens de spécialisation
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un lien de spécialisation
	 *  - l'opacite est correcte
	 *  - le déplacement du lien est impossible
	 *  - la couleur du lien est correcte
	 */
	@Test
	public void testCreerStyleSpecialisation() {
		mxStylesheet feuilleStyles = this.lienSpecialisation.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("SPECIALISATION"));
		assertEquals(mxConstants.ARROW_BLOCK, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	/**
	 * Test unitaire qui vérifie la création du style des flèches
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'une flèche
	 *  - l'opacite est correcte
	 *  - le déplacement du lien est impossible
	 *  - la couleur du lien est correcte
	 */
	@Test
	public void testCreerStyleFleche() {
		mxStylesheet feuilleStyles = this.lienFleche.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("FLECHE"));
		assertEquals(mxConstants.EDGESTYLE_TOPTOBOTTOM, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_CLASSIC, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_STROKECOLOR));
	}
	
}
