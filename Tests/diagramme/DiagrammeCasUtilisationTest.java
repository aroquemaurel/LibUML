package diagramme;

import com.mxgraph.view.mxGraph;
import eltGraphique.eltModelisation.*;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe DiagrammeCasUtilisationTest
 * 
 * @see DiagrammeCasUtilisation
 * 
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeCasUtilisationTest {

    /**
    * Le champ diagramme sur lequel on effectuera les tests
    */
    private Diagramme monDiagramme;
    
    /**
    * Le champ graphe sur lequel on effectuera les tests
    */
    private mxGraph monGraph;
    
    /**
    * Le champ message sur lequel on effectuera les tests
    */
    private String maString;
    
    /**
    * Le champ acteur actif sur lequel on effectuera les tests
    */
    private ActeurActif monActeurActif;
    
    /**
    * Le champ cas d'utilisation sur lequel on effectuera les tests
    */
    private CasUtilisation monCasUtilisation;
    
    /**
    * Le champ acteur passif sur lequel on effectuera les tests
    */
    private ActeurPassif monActeurPassif;
    
    /**
    * Le champ traitement sur lequel on effectuera les tests
    */
    private Traitement monTraitement;
    
    /**
    * Le champ classe sur lequel on effectuera les tests
    */
    private Classe maClasse;
    
    /**
    * Le champ interface sur lequel on effectuera les tests
    */
    private Interface monInterface;
    
    private Position position;
    
    /**
    * Initialisation des champ avant chaque test
    */
    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeCasUtilisation();
        this.monGraph = new mxGraph();
        this.maString = "un test";
        
        this.monActeurActif = new ActeurActif(monGraph, monDiagramme, maString, position);
        this.monActeurPassif = new ActeurPassif(monGraph, monDiagramme, maString, position);
        this.monCasUtilisation = new CasUtilisation(monGraph, monDiagramme, maString, position);
        this.monTraitement = new Traitement(monGraph, monDiagramme, maString, null, position, false);
        this.maClasse = new Classe(monGraph, monDiagramme, maString, position);
        this.monInterface = new Interface (monGraph, maString, monDiagramme, position);
        
        
    }

    /**
    * Suppression de ces champs après chaque test
    */
    @After
    public void tearDown() {
        this.monDiagramme = null;
        this.monGraph = null;
        this.maString = null;
        
        this.monActeurActif = null;
        this.monActeurPassif = null;
        this.monCasUtilisation = null;
        this.monTraitement = null;
        this.maClasse = null;
        this.monInterface = null;
        
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un cas d'utilisation est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationActeurActifCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif, 
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un cas d'utilisation et un acteur actif est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un cas d'utilisation et un cas d'utilisation est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un acteur actif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }

    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un acteur passif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif, 
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un cas d'utilisation n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif, 
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un cas d'utilisation et un acteur passif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un acteur passif n'est pas  autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un acteur actif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un cas d'utilisation et un cas d'utilisation est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur actif et un cas d'utilisation n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationActeurActifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un cas d'utilisation et un acteur actif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur passif et un cas d'utilisation n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un cas d'utilisation et un acteur passif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurPassif,
                TypeLien.GENERALISATION));
    }
      
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur actif et un acteur actif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur passif et un acteur passif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur actif et un acteur passif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur passif et un acteur actif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }

    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un cas d'utilisation et un cas d'utilisation est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur actif et un acteur actif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
     @Test
    public void testLienAutoriseDependanceActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
     
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur actif et un cas d'utilisation n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurActifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monCasUtilisation,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un cas d'utilisation et un acteur actif n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceCasUtilisationActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur passif et un cas d'utilisation n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monCasUtilisation,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un cas d'utilisation et un acteur passif n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurPassif,
                TypeLien.DEPENDANCE));
    }
      
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur passif et un acteur passif n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur actif et un acteur passif n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur passif et un acteur actif n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre n'importe quel élément graphique n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAgregation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.AGREGATION));
    }
    
    
    /**
    * Test unitaire qui vérifie que le lien de classe-association entre n'importe quel élément graphique n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseClasseAssociation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.CLASSE_ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre n'importe quel élément graphique n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseComposition () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.COMPOSITION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de spécialisation entre n'importe quel élément graphique n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseSpecialisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.SPECIALISATION));
    }
     
    /**
    * Test unitaire qui vérifie que le lien de fleche entre n'importe quel élément graphique n'est pas autorisé  dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFleche () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément cas d'utilisation est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monCasUtilisation));
    }

    /**
    * Test unitaire qui vérifie que l'élément lien est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(
                new Lien(
                this.monActeurActif,
                this.monCasUtilisation,
                new mxGraph(), 
                new Diagramme(),
                TypeLien.ASSOCIATION)));
    }

    /**
    * Test unitaire qui vérifie que l'élément acteur actif est autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monActeurActif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément acteur passif n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseActeurPassif () {
        assertFalse(this.monDiagramme.eltAutorise(
                this.monActeurPassif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément traitement n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseTraitement () {
        assertFalse(this.monDiagramme.eltAutorise(
                this.monTraitement));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément classe n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseClasse () {
        assertFalse(this.monDiagramme.eltAutorise(
                this.maClasse));    
    }
    
    /**
    * Test unitaire qui vérifie que l'élément Interface n'est pas autorisé dans un diagramme de cas d'utilisation
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise( 
                this.monInterface));
    }
}