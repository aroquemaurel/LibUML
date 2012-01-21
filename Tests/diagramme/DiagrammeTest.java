package diagramme;

import eltGraphique.eltModelisation.Traitement;
import eltGraphique.eltModelisation.CasUtilisation;
import eltGraphique.eltModelisation.Interface;
import eltGraphique.eltModelisation.ActeurPassif;
import eltGraphique.eltModelisation.ActeurActif;
import eltGraphique.eltModelisation.Classe;
import com.mxgraph.view.mxGraph;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Liste;
import util.Position;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe DiagrammeTest
 * 
 * @see Diagramme
 * 
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeTest {
    
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
    * Suppression de ces champs après chaque test
    */
    @Before
    public void setUp() {
        this.monDiagramme = new Diagramme();
        this.monGraph = new mxGraph();
        this.maString = "un test";
        this.position = new Position(42,42);
        
        this.monActeurActif = new ActeurActif(monGraph, monDiagramme, maString, position);
        this.monActeurPassif = new ActeurPassif(monGraph, monDiagramme, maString, position);
        this.monCasUtilisation = new CasUtilisation(monGraph, monDiagramme, maString, position);
        this.monTraitement = new Traitement(monGraph, monDiagramme, maString, null, position, false);
        this.maClasse = new Classe(monGraph, monDiagramme, maString, position);
        this.monInterface = new Interface (monGraph, maString, monDiagramme, position);
        this.monLien = new Lien (this.monActeurActif, this.monCasUtilisation, monGraph, monDiagramme, TypeLien.ASSOCIATION);
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
    * Test unitaire qui vérifie que l'instanciation de la liste d'éléments graphiques.
    * 
    * Vérifie que :
    *  - la liste d'éléments graphiques est une instance de liste
    */
    @Test
    public void testConstructeurDiagramme(){
        assertTrue(this.monDiagramme.getElementsGraphiques() instanceof Liste);
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un cas d'utilisation est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien d'association entre un cas d'utilisation et un acteur actif est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien d'association entre un cas d'utilisation et un cas d'utilisation est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un acteur actif est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }

    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un acteur passif est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurPassif, 
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un cas d'utilisation et un cas d'utilisation est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien de généralisation entre un acteur actif et un acteur actif est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }

    /**
    * Test unitaire qui vérifie que le lien de dépendance foncionnelle entre un cas d'utilisation et un cas d'utilisation est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur actif et un acteur actif est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
     @Test
    public void testLienAutoriseDepencanceActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }  
     
     /**
    * Test unitaire qui vérifie que le lien de composition entre une classe et une classe est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien de composition entre une classe et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseCompositionClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre un lien et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseCompositionLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre un lien et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseCompositionLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre une classe et une classe est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien d'association entre une classe et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un lien et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un lien et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre une classe et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre une classe et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un lien et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de généralisation entre un lien et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseGeneralisationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre une classe et une classe est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre une classe et un lien est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un lien et une classe est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un lien et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre une classe et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAgregationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre une classe et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAgregationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre un lien et une classe est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAgregationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'agrégation entre un lien et un lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAgregationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un traitement et un traitement est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseAssociationTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un traitement et un traitement est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dépendance fonctionnelle entre un acteur actif et un acteur actif est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseDependanceActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
     
    /**
    * Test unitaire qui vérifie que le lien de classe association entre n'importe quels éléments graphiques est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseClasseAssociation () {
        assertTrue(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.CLASSE_ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre n'importe quels éléments graphiques est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseFleche () {
        assertTrue(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément traitement est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseTraitement () {
        assertTrue(this.monDiagramme.eltAutorise(this.monTraitement));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément classe est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que l'élément lien est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monLien));
    }

    /**
    * Test unitaire qui vérifie que l'élément acteur actif est autorisé dans un diagramme.
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
    * Test unitaire qui vérifie que l'élément acteur passif est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(this.monActeurPassif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément interface est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseInterface () {
        assertTrue(this.monDiagramme.eltAutorise(this.monInterface));
    } 
    
    /**
    * Test unitaire qui vérifie que l'élément cas d'utilisation est autorisé dans un diagramme.
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise( this.monCasUtilisation));
    }    

    /**
    * Test unitaire qui vérifie que l'instanciation de la liste d'éléments graphiques.
    * 
    * Vérifie que :
    *  - la liste d'éléments graphiques est une liste d'éléments graphiques vide
    */
    @Test
    public void testGetElementsGraphiques(){
        assertEquals(this.monDiagramme.getElementsGraphiques(),new Liste<ElementGraphique>());
    } 
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique traitement est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGraphiqueViaCelluleTraitement(){
        ElementGraphique elemTeste = this.monTraitement;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique classe est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGraphiqueViaCelluleClasse(){
        ElementGraphique elemTeste = this.maClasse;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique lien est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGraphiqueViaCelluleLien(){
        ElementGraphique elemTeste = this.monLien;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique acteur actif est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGraphiqueViaCelluleActeurActif(){
        ElementGraphique elemTeste = this.monActeurActif;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique acteur passif est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGraphiqueViaCelluleActeurPassif(){
        ElementGraphique elemTeste = this.monActeurPassif;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique interface est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGreaphiqueViaCelluleInterface(){
        ElementGraphique elemTeste = this.monInterface;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
    
    /**
    * Test unitaire qui vérifie que qu'un élément graphique cas d'utilisation est bien relié à sa cellule.
    * 
    * Vérifie que :
    *  - la méthode getElementGraphiqueViaCellule retourne bien l'élément graphique dont la cellule est mise en paramètre.
    */
    @Test
    public void getElementGraphiqueViaCelluleCasUtilisation(){
        ElementGraphique elemTeste = this.monCasUtilisation;
        elemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(elemTeste.getCellule()) == elemTeste);
    }
}
