package diagramme;

import eltGraphique.eltModelisation.Traitement;
import eltGraphique.eltModelisation.CasUtilisation;
import eltGraphique.eltModelisation.Interface;
import eltGraphique.eltModelisation.ActeurPassif;
import eltGraphique.eltModelisation.ActeurActif;
import eltGraphique.eltModelisation.Classe;
import com.mxgraph.view.mxGraph;
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
 * de la classe DiagrammeSequenceTest
 * 
 * @see DiagrammeSequence
 * 
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeSequenceTest {
    
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
        this.monDiagramme = new DiagrammeSequence();
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
    * Test unitaire qui vérifie que le lien d'association entre un traitement et un traitement est autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un traitement n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un traitement n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un traitement et un acteur actif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un traitement et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseAssociationTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un acteur actif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien d'association entre un acteur actif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien d'association entre un acteur passif et un acteur actif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un traitement et un traitement est autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un acteur actif et un acteur actif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un acteur actif et un traitement n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    } 
    
    /**
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un acteur passif et un traitement n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un traitement et un acteur actif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un traitement et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurPassif,
                TypeLien.DEPENDANCE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un acteur passif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un acteur actif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseDependanceActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.DEPENDANCE ));
    } 
    
    /**
    * Test unitaire qui vérifie que le lien de dependance fonctionnelle entre un acteur passif et un acteur actif n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de flèche entre un traitement et un traitement est autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne vrai
    */
    @Test
    public void testLienAutoriseFlecheTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un acteur actif et un traitement n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monTraitement,
                TypeLien.FLECHE));
    } 
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un acteur passif et un traitement n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monTraitement,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un traitement et un acteur actif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurActif,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un traitement et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurPassif,
                TypeLien.FLECHE));
    }
    
     /**
    * Test unitaire qui vérifie que le lien de flèche entre un acteur actif et un acteur actif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un acteur passif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.FLECHE));
    } 
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un acteur actif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.FLECHE));
    } 
    
    /**
    * Test unitaire qui vérifie que le lien de flèche entre un acteur passif et un acteur passif n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseFlecheActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.FLECHE));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de spécialisation entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien d'agrégation entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de classe-association entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que le lien de généralisation entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de séquence.
    * 
    * Vérifie que :
    *  - la méthode lienAutorise() retourne faux
    */
    @Test
    public void testLienAutoriseGeneralisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.GENERALISATION));
    }
    
    /**
    * Test unitaire qui vérifie que le lien de composition entre n'importe quels éléments graphiques n'est pas autorisé dans un diagramme de séquence.
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
    * Test unitaire qui vérifie que l'élément traitement est autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseTraitement () {
        assertTrue(this.monDiagramme.eltAutorise(this.monTraitement));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément classe n'est pas autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseClasse () {
        assertFalse(this.monDiagramme.eltAutorise(this.maClasse));    
    }
    
    /**
    * Test unitaire qui vérifie que l'élément lien n'est pas autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(this.monLien));
    }

    /**
    * Test unitaire qui vérifie que l'élément acteur actif est autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(this.monActeurActif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément acteur passif est autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne vrai
    */
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(this.monActeurPassif));
    }
    
    /**
    * Test unitaire qui vérifie que l'élément interface n'est pas autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise(this.monInterface));
    } 
    
    /**
    * Test unitaire qui vérifie que l'élément cas d'utilisation n'est pas autorisé dans un diagramme de séquence
    * 
    * Vérifie que :
    *  - la méthode eltAutorise() retourne faux
    */
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertFalse(this.monDiagramme.eltAutorise(this.monCasUtilisation));
    }
}