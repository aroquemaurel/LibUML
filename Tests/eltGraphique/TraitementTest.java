package eltGraphique;

import eltGraphique.eltModelisation.Traitement;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe Traitement
 * 
 * @see Traitement
 */
public class TraitementTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private Traitement traitement;
	
	/**
	 * Initialisation du champ avant chaque test
	 */
    @Before
    public void setUp() {
		this.traitement = new Traitement(new mxGraph(), new Diagramme(), null, null, new Position(42,42), false);
		this.traitement.creer();
    }

	/**
	 * Suppression de ce champ après chaque test
	 */
    @After
    public void tearDown() {
		this.traitement = null;
    }
	
	/**
	 * Test unitaire qui teste la création du style du traitement
	 * en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un traitement
	 *  - l'inclusion d'un autre élément soit impossible
	 *  - l'opacite est correcte
	 *  - la couleur du texte est correcte
	 *  - la couleur de la bordure est correcte
	 */
    @Test
    public void testCreerStyle() {
            mxStylesheet feuilleStyles = this.traitement.getGraph().getStylesheet();
            assertTrue(feuilleStyles.getStyles().containsKey("TRAITEMENT"));
            assertEquals(mxConstants.SHAPE_RECTANGLE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_SHAPE));
            assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_OPACITY));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_FOLDABLE));
            assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_STROKECOLOR));
            assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_FONTCOLOR));
    }

	/**
	 * Test unitaire qui teste la création du style de la flèche
	 * de début de séquence en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'un traitement
	 *  - le déplacement de la flèche soit impossible
	 *  - le redimensionnement de la flèche soit impossible
	 *  - la suppression de la flèche soit impossible
	 *  - l'opacite est correcte
	 *  - la direction est correcte
	 *  - la'aligement du texte est à gauche
	 *  - la couleur du texte est correcte
	 *  - la couleur de fond est correcte
	 *  - la couleur de la bordure est correcte
	 */
    @Test
    public void testCreerStyleFleche() {
        mxStylesheet feuilleStyles = this.traitement.getGraph().getStylesheet();
        assertTrue(feuilleStyles.getStyles().containsKey("FLECHE_EVENEMENT_DECLENCHEUR"));
        assertEquals(mxConstants.ARROW_BLOCK, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_ENDARROW));
        assertEquals(Constantes.OPACITE, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_OPACITY));
        assertEquals(Constantes.COULEUR_FOND, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_FILLCOLOR));
        assertEquals(Constantes.COULEUR_TEXTE, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_FONTCOLOR));
        assertEquals(mxConstants.NONE, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_MOVABLE));
        assertEquals(mxConstants.NONE, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_RESIZABLE));
        assertEquals(mxConstants.DIRECTION_WEST, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_DIRECTION));
        assertEquals(Constantes.COULEUR_FLECHE, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_STROKECOLOR));
        assertEquals(mxConstants.NONE, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_DELETABLE));
        assertEquals(mxConstants.ALIGN_LEFT, 
                feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_ALIGN));
    }

	/**
	 * Test unitaire qui test la modification de l'élément déclencheur du traitement
	 * 
	 * Vérifie que :
	 *  - le nouveau traitement est assigné correctement
	 */
    @Test
    public void testEvenementDeclencheur() {
            Lien nouvelEltDeclencheur = new Lien(null, null, new mxGraph(), new Diagramme(),
                                                                                        TypeLien.AGREGATION);
            this.traitement.setEvenementDeclencheur(nouvelEltDeclencheur);
            assertEquals(nouvelEltDeclencheur, this.traitement.getEvenementDeclencheur());
    }

	/**
	 * Test unitaire qui teste la modification du champ de début de séquence
	 * du traitement
	 * 
	 * Vérifie que :
	 *  - l'état initial du traitement est faux (pas début de séquence)
	 *  - la modification de l'état à vrai est effective
	 */
    @Test
    public void testDebutSequence() {
            assertFalse(this.traitement.estDebutSequence());
            this.traitement.setDebutSequence(true);
            assertTrue(this.traitement.estDebutSequence());
    }
	
}