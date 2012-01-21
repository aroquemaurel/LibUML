package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import eltGraphique.eltModelisation.Attribut;
import eltGraphique.eltModelisation.CasUtilisation;
import eltGraphique.eltModelisation.Classe;
import eltGraphique.eltModelisation.Methode;
import eltGraphique.eltModelisation.Visibilite;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.Constantes;
import util.Liste;
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe CasUtilisation
 * 
 * @see CasUtilisation
 */
public class ClasseTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private Classe classe;

	/**
	 * Initialisation du champ avant chaque test
	 */
    @Before
    public void setUp() {
		this.classe = new Classe (new mxGraph(), 
                                          new Diagramme(), 
                                          "un super test", new Position(42,42));
        this.classe.creer();
    }

	/**
	 * Suppression de ce champ après chaque test
	 */
    @After
    public void tearDown() {
		this.classe = null;
    }

	/**
	 * Test unitaire qui teste que la classe n'a pas d'élément parent et cible
	 * 
	 * Vérifie que :
	 *  - la cellule parente est la même que la cellule actuelle
	 *  - la cellule cible est la même que la cellule actuelle
	 */
    @Test
    public void testCelluleParentTarget(){
        mxICell maCellule1 = this.classe.getParent();
        assertEquals(maCellule1, this.classe.getCellule());

        mxICell maCellule2 = this.classe.getTarget();
        assertEquals(maCellule2, this.classe.getCellule());
	}
	
	/**
	 * Test unitaire qui teste si l'instanciation du champ est correcte
	 * 
	 * Vérifie que :
	 *  - le champ est une instance de Classe
	 */
    @Test
    public void testCreerInstance(){
            assertTrue(this.classe instanceof Classe);
    }

	/**
	 * Test unitaire qui teste l'application du style à la cellule
	 * 
	 * Vérifie que :
	 *  - Le style appliqué est bien "CLASSE"
	 */
    @Test
    public void testCreerStyle(){
            assertEquals("CLASSE", this.classe.getCellule().getStyle());
    }

	/**
	 * Test unitaire qui teste la modification du texte lié à la classe
	 * 
	 * Vérifie que :
	 *  - le texte est modifié correctement
	 */
    @Test
    public void testSetTexte(){
        this.classe.setTexte("testouille");
        assertEquals("testouille", this.classe.getTexte());
    }

	/**
	 * Test unitaire qui teste la modification de la cellule
	 * lié à la classe
	 * 
	 * Vérifie que :
	 *  - la cellule actuelle a bien été remplacée
	 *  - la cellule parent est la même que la cellule courante
	 */
    @Test
    public void testSetCelluleParent(){
            mxCell maCellulle = new mxCell();
            this.classe.setCellule(maCellulle);
            assertEquals(maCellulle, this.classe.getCellule());
            assertEquals(maCellulle, this.classe.getParent());
    }

	/**
	 * Test unitaire qui teste la modification de la cellule
	 * lié à la classe
	 * 
	 * Vérifie que :
	 *  - la cellule cible est la même que la cellule courante
	 */
    @Test
    public void testSetCelluleTarget(){
            mxCell maCellulle = new mxCell();
            this.classe.setCellule(maCellulle);
            assertEquals(maCellulle, this.classe.getTarget());
    }

	/**
	 * Test unitaire qui vérifie la suppression de l'élément
	 * 
	 * Vérifie que :
	 *  - la cellule actuelle est à null
	 *  - la cellule parente est à null
	 *  - la cellule cible est à null
	 */
    @Test
    public void testSupprimer(){
		this.classe.supprimer();
		assertNull(this.classe.getCellule());
		assertNull(this.classe.getParent());
		assertNull(this.classe.getTarget());
    }

	/**
	 * Test unitaire qui teste la modification de la taille de la liste 
	 * de méthode lors de l'ajout d'une méthode à la classe
	 * 
	 * Vérifie que :
	 *  - la nouvelle taille est égale à l'ancienne + 1
	 */
    @Test
    public void testAjouterMethodeTailleListe(){
		int taille = this.classe.getMethodes().taille();
		this.classe.ajouterMethode(
				new Methode(Visibilite.PUBLIC, "Object", "methodeDeTest", null, true, true, true));
		assertEquals(taille+1, this.classe.getMethodes().size());
    }

	/**
	 * Test unitaire qui vérifie lors de l'ajout d'une méthode à la classe
	 * que ladite est bien référencée dans la liste des méthodes de la classe
	 * 
	 * Vérifie que :
	 *  - la nouvelle méthode est présente dans la liste des méthodes de la classe
	 */
    @Test
    public void testAjouterMethode(){
            Methode maMethode = new Methode(Visibilite.PUBLIC, "Object", "methodeDeTest", null, true, true, true);
            this.classe.ajouterMethode(maMethode);
            assertTrue(this.classe.getMethodes().contains(maMethode));
    }
	
	/**
	 * Test unitaire qui vérifie lors de l'ajout d'un attribut à la classe
	 * que ledit est bien référencée dans la liste des attributs de la classe
	 * 
	 * Vérifie que :
	 *  - le nouvel attribut est présent dans la liste des attributs de la classe
	 */
    @Test
    public void testAjouterAttribut(){
            Attribut nouvelAttribut = new Attribut(Visibilite.PRIVATE, true, true, null, null);
            this.classe.ajouterAttribut(nouvelAttribut);
            assertTrue(this.classe.getAttributs().contains(nouvelAttribut));
    }
	
	/**
	 * Test unitaire qui teste la modification de la taille de la liste 
	 * d'attributs lors de l'ajout d'un attribut à la classe
	 * 
	 * Vérifie que :
	 *  - la nouvelle taille est égale à l'ancienne + 1
	 */
    @Test
    public void testAjouterAttributTailleListe(){
            int taille = this.classe.getAttributs().taille();
            this.classe.ajouterAttribut(
                    new Attribut(Visibilite.PRIVATE, true, true, null, null));
            assertEquals(taille+1, this.classe.getAttributs().size());
    }
	
	/**
	 * Test unitaire qui vérifie que l'on peut mettre une classe constante
	 * 
	 * Vérifie que :
	 *  - la modification de l'attribut constante de la classe est effective
	 */
    @Test
    public void testEstConstante(){
            this.classe.setConstante(true);
            assertTrue(this.classe.estConstante());
    }

	/**
	 * Test unitaire qui vérifie que l'on peut mettre une classe abstraite
	 * 
	 * Vérifie que :
	 *  - la modification de l'attribut abstraite de la classe est effective
	 */
    @Test
    public void testEstAbstraite(){
            this.classe.setAbstraite(true);
            assertTrue(this.classe.estAbstraite());
    }

	/**
	 * Test unitaire qui teste l'instanciation de la liste de
	 * méthodes de la classe
	 * 
	 * Vérifie que :
	 *  - la liste des méthode est une instance de Liste
	 * 
	 * @see Liste
	 */
    @Test
    public void testGetAttributsInstance(){
            assertTrue(this.classe.getAttributs() instanceof Liste);
    }

	/**
	 * Test unitaire qui teste l'instanciation de la liste de
	 * attributs de la classe
	 * 
	 * Vérifie que :
	 *  - la liste des attributs est une instance de Liste
	 * 
	 * @see Liste
	 */
    @Test
    public void testGetMethodesInstance(){
            assertTrue(this.classe.getMethodes() instanceof Liste);

    }
	
	/**
	 * Test unitaire qui vérifie la modification de la liste d'attributs
	 * de la classe via la méthode setAttributs
	 * 
	 * Vérifie que :
	 *  - la nouvelle liste d'attributs est assignée correctement
	 */
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

	/**
	 * Test unitaire qui vérifie la modification de la liste de méthodes
	 * de la classe via la méthode setMéthodes
	 * 
	 * Vérifie que :
	 *  - la nouvelle liste de méthodes est assignée correctement
	 */
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
	
	/**
	 * Test unitaire qui teste la création du style de la classe
	 * en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle d'une classe
	 *  - l'inclusion d'un autre élément soit impossible
	 *  - l'opacite est correcte
	 *  - la couleur du texte est correcte
	 *  - la couleur de la bordure est correcte
	 */
    @Test
    public void testCreerStyleClasse(){
			mxStylesheet feuilleStyles = this.classe.getGraph().getStylesheet();
            assertTrue(feuilleStyles.getStyles().containsKey("CLASSE"));
            assertEquals(mxConstants.SHAPE_SWIMLANE, feuilleStyles.getStyles().get("CLASSE").get(mxConstants.STYLE_SHAPE));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("CLASSE").get(mxConstants.STYLE_RESIZABLE));
            assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("CLASSE").get(mxConstants.STYLE_OPACITY));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("CLASSE").get(mxConstants.STYLE_FOLDABLE));
            assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("CLASSE").get(mxConstants.STYLE_FONTCOLOR));
    }

	/**
	 * Test unitaire qui teste la création du style de l'acteur passif
	 * en vérifiant chaque champ du nouveau style
	 * 
	 * Vérifie que :
	 *  - le style est créé
	 *  - la forme est celle du contenu d'une classe
	 *  - l'inclusion d'un autre élément soit impossible
	 *  - l'opacite est correcte
	 *  - la couleur du texte est correcte
	 *  - la couleur de la bordure est correcte
	 *  - le redimensionnement du contenu soit impossible
	 *  - le déplacement du contenu soit impossible
	 *  - la suppression du contenu soit impossible
	 *  - l'alignement du texte est à gauche
	 */
    @Test
    public void testCreerStyleContenuclasse(){
			mxStylesheet feuilleStyles = this.classe.getGraph().getStylesheet();
            assertTrue(feuilleStyles.getStyles().containsKey("CONTENUCLASSE"));
            assertEquals(Constantes.OPACITE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_OPACITY));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_FOLDABLE));
            assertEquals(Constantes.COULEUR_FOND, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_FILLCOLOR));
            assertEquals(Constantes.COULEUR_TEXTE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_FONTCOLOR));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_MOVABLE));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_RESIZABLE));
            assertEquals(mxConstants.NONE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_DELETABLE));
            assertEquals(mxConstants.ALIGN_LEFT, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_ALIGN));
            assertEquals(mxConstants.SHAPE_RECTANGLE, feuilleStyles.getStyles().get("CONTENUCLASSE").get(mxConstants.STYLE_SHAPE));
    }
}