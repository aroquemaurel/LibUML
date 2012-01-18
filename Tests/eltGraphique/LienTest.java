package eltGraphique;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import eltModelisation.Classe;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;

public class LienTest {
	private Lien lienComposition;
	private Lien lienAgregation;
	private Lien lienAssociation;
	private Lien lienSpecialisation;
	private Lien lienFleche;
	
	@Before
	public void setUp() {
		this.lienComposition = new Lien(new Classe(null, null, null), new Classe(null, null, null), new mxGraph(), new Diagramme(), TypeLien.COMPOSITION);
		this.lienAgregation = new Lien(new Classe(null, null, null), new Classe(null, null, null), new mxGraph(), new Diagramme(), TypeLien.AGREGATION);
		this.lienAssociation = new Lien(new Classe(null, null, null), new Classe(null, null, null), new mxGraph(), new Diagramme(), TypeLien.ASSOCIATION);
		this.lienSpecialisation = new Lien(new Classe(null, null, null), new Classe(null, null, null), new mxGraph(), new Diagramme(), TypeLien.SPECIALISATION);
		this.lienFleche = new Lien(new Classe(null, null, null), new Classe(null, null, null), new mxGraph(), new Diagramme(), TypeLien.FLECHE);
		
		this.lienComposition.creer();
		this.lienAgregation.creer();
		this.lienAssociation.creer();
		this.lienSpecialisation.creer();
		this.lienFleche.creer();
	}
	
	@After
	public void tearDown() {
		this.lienComposition = null;
		this.lienAgregation = null;
		this.lienAssociation = null;
		this.lienSpecialisation = null;
		this.lienFleche = null;
	}
	
	@Test
	public void testCreerStyleComposition() {
		mxStylesheet feuilleStyles = this.lienComposition.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("COMPOSITION"));
	}
	
	@Test
	public void testChampsStyleComposition() {
		mxStylesheet feuilleStyles = this.lienComposition.getGraph().getStylesheet();
		assertEquals(mxConstants.EDGESTYLE_TOPTOBOTTOM, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_DIAMOND, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("COMPOSITION").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	@Test
	public void testCreerStyleAgregation() {
		mxStylesheet feuilleStyles = this.lienAgregation.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("AGREGATION"));
	}
	
	@Test
	public void testChampsStyleAgregation() {
		mxStylesheet feuilleStyles = this.lienAgregation.getGraph().getStylesheet();
		assertEquals(mxConstants.EDGESTYLE_TOPTOBOTTOM, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_DIAMOND, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_STROKECOLOR));
		assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("AGREGATION").get(mxConstants.STYLE_FONTCOLOR));
	}
	
	@Test
	public void testCreerStyleAssociation() {
		mxStylesheet feuilleStyles = this.lienAssociation.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("ASSOCIATION"));
	}
	
	@Test
	public void testChampsStyleAssociation() {
		mxStylesheet feuilleStyles = this.lienAssociation.getGraph().getStylesheet();
		assertEquals(mxConstants.EDGESTYLE_ORTHOGONAL, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_SPACING, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("ASSOCIATION").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	@Test
	public void testCreerStyleSpecialisation() {
		mxStylesheet feuilleStyles = this.lienSpecialisation.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("SPECIALISATION"));
	}
	
	@Test
	public void testChampsStyleSpecialisation() {
		mxStylesheet feuilleStyles = this.lienSpecialisation.getGraph().getStylesheet();
		assertEquals(mxConstants.EDGESTYLE_ORTHOGONAL, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_BLOCK, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("SPECIALISATION").get(mxConstants.STYLE_STROKECOLOR));
	}
	
	@Test
	public void testCreerStyleFleche() {
		mxStylesheet feuilleStyles = this.lienFleche.getGraph().getStylesheet();
		assertTrue(feuilleStyles.getStyles().containsKey("FLECHE"));
	}
	
	@Test
	public void testChampsStyleFleche() {
		mxStylesheet feuilleStyles = this.lienFleche.getGraph().getStylesheet();
		assertEquals(mxConstants.EDGESTYLE_TOPTOBOTTOM, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_EDGE));
		assertEquals(mxConstants.ARROW_CLASSIC, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_ENDARROW));
		assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_OPACITY));
		assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_MOVABLE));
		assertEquals(Constantes.COULEUR_FLECHE, feuilleStyles.getStyles().get("FLECHE").get(mxConstants.STYLE_STROKECOLOR));
	}
	
}
