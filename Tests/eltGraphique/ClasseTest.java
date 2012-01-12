package eltGraphique;

import util.Liste;
import diagramme.Diagramme;
import eltGraphique.classe.*;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class ClasseTest {
	private Classe classe;

    @Before
    public void setUp() {
		this.classe = new Classe (new mxGraph(), 
                                          new Diagramme(), 
                                          "un super test");
        this.classe.creer();
    }

    @After
    public void tearDown() {
		this.classe = null;
    }

    @Test
    public void testGetCellule(){
        mxICell maCellule1 = this.classe.getParent();
        assertEquals(maCellule1, this.classe.getCellule());

        mxICell maCellule2 = this.classe.getTarget();
        assertEquals(maCellule2, this.classe.getCellule());
	}

	@Test
	public void testCreerCellule (){
        mxICell maCellule = this.classe.getCellule();
        assertEquals(maCellule, this.classe.getCellule());
	}

	@Test
	public void testCreerInstance(){
		assertTrue(this.classe instanceof Classe );
	}

	@Test
	public void testCreerStyle(){
		assertEquals("CLASSE", this.classe.getCellule().getStyle());
	}


    @Test
    public void testSetTexte(){
        this.classe.setTexte("testouille");
        assertEquals("testouille", this.classe.getTexte());
    }

	@Test
	public void testSetCelluleParent(){
		mxCell maCellulle = new mxCell();
		this.classe.setCellule(maCellulle);
		assertEquals(maCellulle, this.classe.getParent());
	}
	
	@Test
	public void testSetCelluleTarget(){
		mxCell maCellulle = new mxCell();
		this.classe.setCellule(maCellulle);
		assertEquals(maCellulle, this.classe.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.classe.supprimer();
        assertNull(this.classe.getCellule());
    }

	@Test
	public void testAjouterMethodeTailleListe(){
		this.classe.ajouterMethode(
			new Methode(Visibilite.PUBLIC, "Object", "methodeDeTest", null, true, true, true));
		assertEquals(4, this.classe.getMethodes().size());
	}
	
	@Test
	public void testAjouterMethode(){
		Methode maMethode = new Methode(Visibilite.PUBLIC, "Object", "methodeDeTest", null, true, true, true);
		this.classe.ajouterMethode(maMethode);
		assertTrue(this.classe.getMethodes().contains(maMethode));
	}
	
	@Test
	public void testAjouterAttribut(){
		Attribut nouvelAttribut = new Attribut(Visibilite.PRIVATE, true, true, null, null);
		this.classe.ajouterAttribut(nouvelAttribut);
		assertTrue(this.classe.getAttributs().contains(nouvelAttribut));
	}
	@Test
	public void testAjouterAttributTailleListe(){
		int taille = this.classe.getAttributs().taille();
		this.classe.ajouterAttribut(
			new Attribut(Visibilite.PRIVATE, true, true, null, null));
		assertEquals(taille+1, this.classe.getAttributs().size());
	}
	@Test
	public void testEstConstante(){
		this.classe.setConstante(true);
		assertTrue(this.classe.estConstante());
	}
	
	@Test
	public void testEstAbstraite(){
		this.classe.setAbstraite(true);
		assertTrue(this.classe.estAbstraite());
	}
	
	@Test
	public void testGetAttributsInstance(){
		assertTrue(this.classe.getAttributs() instanceof Liste);
	}
	
	@Test
	public void testGetMethodesInstance(){
		assertTrue(this.classe.getMethodes() instanceof Liste);

	}
	
	@Test
	public void testSetAbstraite(){
		this.classe.setAbstraite(true);
		assertTrue(this.classe.estAbstraite());
	}
	
	@Test
	public void testSetConstante(){
		this.classe.setConstante(true);
		assertTrue(this.classe.estConstante());

	}
	
	@Test
	public void testSetAttributs(){
		Liste<Attribut> nouvelleListe = new Liste<Attribut>();
		for (int i = 0 ; i < 5 ; i++) {
			nouvelleListe.add(
				new Attribut(Visibilite.PRIVATE, true, true, null, null));
		}
		this.classe.setAttributs(nouvelleListe);
		
		assertEquals(nouvelleListe, this.classe.getAttributs());
	}
	
	@Test
	public void testSetMethodes(){
		Liste<Methode> nouvelleListe = new Liste<Methode>();
		for (int i = 0 ; i < 5 ; i++) {
			nouvelleListe.add(
				new Methode(Visibilite.PACKAGE, null, null, null, true, true, true));			
		}
		this.classe.setMethodes(nouvelleListe);
		
		assertEquals(nouvelleListe, this.classe.getMethodes());
	}
	
	@Test
	public void testCreerStyleClasse(){
		assertTrue(this.classe.getGraph().getStylesheet().getStyles().containsKey("CLASSE"));
		assertEquals(mxConstants.SHAPE_SWIMLANE, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CLASSE")
									.get(mxConstants.STYLE_SHAPE));
		assertEquals(50, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CLASSE")
									.get(mxConstants.STYLE_OPACITY));
		assertEquals(0, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CLASSE")
									.get(mxConstants.STYLE_FOLDABLE));
		assertEquals("#774400", 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CLASSE")
									.get(mxConstants.STYLE_FONTCOLOR));
	}
	
	@Test
	public void testCreerStyleContenuclasse(){
		assertTrue(this.classe.getGraph().getStylesheet().getStyles().containsKey("CONTENUCLASSE"));
		
		assertEquals(50, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_OPACITY));
		assertEquals("#e4e5ef", 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_FILLCOLOR));
		assertEquals(0, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_MOVABLE));
		assertEquals(0, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_RESIZABLE));
		assertEquals(0, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_DELETABLE));
		assertEquals(mxConstants.ALIGN_LEFT, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_ALIGN));
		assertEquals(mxConstants.SHAPE_RECTANGLE, 
					 this.classe.getGraph().getStylesheet().getStyles()
									.get("CONTENUCLASSE")
									.get(mxConstants.STYLE_SHAPE));
	}
}