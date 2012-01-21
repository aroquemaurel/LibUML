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
 * de la classe DiagrammeClasseTest
 * 
 * @see DiagrammeClasse
 * 
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeClasseTest {

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
    
    /**
    * Le champ lien sur lequel on effectuera les tests
    */
    private Lien monLien;
    
    private Position position;

    /**
    * Initialisation des champ avant chaque test
    */
    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeClasse();
        this.monGraph = new mxGraph();
        this.maString = "un test";
        this.position = new Position(42,42);
        
        this.monActeurActif = new ActeurActif(monGraph, monDiagramme, maString, position);
        this.monActeurPassif = new ActeurPassif(monGraph, monDiagramme, maString, position);
        this.monCasUtilisation = new CasUtilisation(monGraph, monDiagramme, maString, position);
        this.monTraitement = new Traitement(monGraph, monDiagramme, maString, null, position, false);
        this.maClasse = new Classe(monGraph, monDiagramme, maString, position);
        this.monInterface = new Interface (monGraph, maString, monDiagramme, position);
        this.monLien = new Lien (null, null, monGraph, monDiagramme, null);
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
        this.monLien = null;
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre une classe et une classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseCompositionClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre une classe et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseCompositionClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre un lien et une classe n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseCompositionLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre un lien et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseCompositionLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre une classe et une classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de classe association entre une classe et un lien est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseClasseAssociationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.CLASSE_ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de classe association entre un lien et une classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseClasseAssociationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.CLASSE_ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de classe association entre un lien et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseClaseeAssociationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.CLASSE_ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre une classe et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un lien et une classe n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un lien et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre une classe et une classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.SPECIALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre une classe et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un lien et une classe n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un lien et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre une classe et une classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.DEPENDANCE));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre une classe et un lien est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un lien et une classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.DEPENDANCE));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un lien et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre une classe et une classe n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAgregationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre une classe et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAgregationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre un lien et une classe n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAgregationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre un lien et un lien n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAgregationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de spécialisation entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de classe
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
    * Test unitaire qui vérifie que le lien de flèche entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de classe
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
    * Test unitaire qui vérifie que l'élément classe est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseClasse () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.maClasse));    
    }
    
    /**
    * Test unitaire qui vérifie que l'élément lien est autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise( this.monLien));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément cas d'utilisation n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertFalse(this.monDiagramme.eltAutorise(this.monCasUtilisation));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément acteur actif n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseActeurActif () {
        assertFalse(this.monDiagramme.eltAutorise(this.monActeurActif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément acteur passif n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseActeurPassif () {
        assertFalse(this.monDiagramme.eltAutorise(this.monActeurPassif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément traitement n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseTraitement () {
        assertFalse(this.monDiagramme.eltAutorise( this.monTraitement));
    }  
    
    /**
    * Test unitaire qui vérifie que l'élément interface n'est pas autorisé dans un diagramme de classe
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise( this.monInterface));
    } 
    
}
