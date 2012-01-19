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

/**
 *
 */
public class TraitementTest {
	private Traitement traitement;
	
    @Before
    public void setUp() {
		this.traitement = new Traitement(new mxGraph(), new Diagramme(), null, null, false);
		this.traitement.creer();
    }

    @After
    public void tearDown() {
		this.traitement = null;
    }
	
    @Test
    public void testCreerStyle() {
            mxStylesheet feuilleStyles = this.traitement.getGraph().getStylesheet();
            assertTrue(feuilleStyles.getStyles().containsKey("TRAITEMENT"));
    }

    @Test
    public void testChampsStyle() {
            mxStylesheet feuilleStyles = this.traitement.getGraph().getStylesheet();
            assertEquals(mxConstants.SHAPE_RECTANGLE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_SHAPE));
            assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_OPACITY));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_FOLDABLE));
            assertEquals(Constantes.COULEUR_BORDURE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_STROKECOLOR));
            assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("TRAITEMENT").get(mxConstants.STYLE_FONTCOLOR));
    }

    @Test
    public void testCreerStyleFleche() {
            mxStylesheet feuilleStyles = this.traitement.getGraph().getStylesheet();
            assertTrue(feuilleStyles.getStyles().containsKey("FLECHE_EVENEMENT_DECLENCHEUR"));
    }

    public void testChampStyleFleche() {
            mxStylesheet feuilleStyles = this.traitement.getGraph().getStylesheet();
            assertEquals(mxConstants.ARROW_BLOCK, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_SHAPE));
            assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_OPACITY));
            assertEquals(Constantes.COULEUR_FOND, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_FILLCOLOR));
            assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_FONTCOLOR));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_MOVABLE));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_RESIZABLE));
            assertEquals(mxConstants.DIRECTION_WEST, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_DIRECTION));
            assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_STROKECOLOR));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_DELETABLE));
            assertEquals(mxConstants.ALIGN_LEFT, feuilleStyles.getStyles().get("FLECHE_EVENEMENT_DECLENCHEUR").get(mxConstants.STYLE_ALIGN));
    }

    @Test
    public void testEvenementDeclencheur() {
            Lien nouvelEltDeclencheur = new Lien(null, null, new mxGraph(), new Diagramme(),
                                                                                        TypeLien.AGREGATION);
            this.traitement.setEvenementDeclencheur(nouvelEltDeclencheur);
            assertEquals(nouvelEltDeclencheur, this.traitement.getEvenementDeclencheur());
    }

    @Test
    public void testDebutSequence() {
            assertFalse(this.traitement.estDebutSequence());
            this.traitement.setDebutSequence(true);
            assertTrue(this.traitement.estDebutSequence());
    }
	
}