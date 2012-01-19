package diagramme;

import com.mxgraph.view.mxGraph;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import eltModelisation.*;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeSequenceTest {
    
    private Diagramme monDiagramme;private mxGraph monGraph;
    private String maString;
    private ActeurActif monActeurActif;
    private CasUtilisation monCasUtilisation;
    private ActeurPassif monActeurPassif;
    private Traitement monTraitement;
    private Classe maClasse;
    private Interface monInterface;
    private Lien monLien;
    
    
   
    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeSequence();
        this.monGraph = new mxGraph();
        this.maString = "un test";
        
        this.monActeurActif = new ActeurActif(monGraph, monDiagramme, maString);
        this.monActeurPassif = new ActeurPassif(monGraph, monDiagramme, maString);
        this.monCasUtilisation = new CasUtilisation(monGraph, monDiagramme, maString);
        this.monTraitement = new Traitement(monGraph, monDiagramme, maString, null, false);
        this.maClasse = new Classe(monGraph, monDiagramme, maString);
        this.monInterface = new Interface (monGraph, maString, monDiagramme);
        this.monLien = new Lien (null, null, monGraph, monDiagramme, null);
    }
    
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
    
    @Test
    public void testLienAutoriseAssociationTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    } 
    @Test
    public void testLienAutoriseAssociationActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    } 
    
    @Test
    public void testLienAutoriseAssociationActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    } 
    
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    } 
    
    @Test
    public void testLienAutoriseDependanceTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif, 
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
        
    @Test
    public void testLienAutoriseDependanceActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    } 
    @Test
    public void testLienAutoriseDependanceActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurPassif,
                TypeLien.DEPENDANCE));
    }
    
    
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.DEPENDANCE));
    } 
    
    @Test
    public void testLienAutoriseDependanceActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.DEPENDANCE ));
    } 
    
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseFlecheTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monTraitement,
                TypeLien.FLECHE));
    } 
    @Test
    public void testLienAutoriseFlecheActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monTraitement,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurActif,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monActeurPassif,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.FLECHE));
    } 
    
    @Test
    public void testLienAutoriseFlecheActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.FLECHE));
    } 
    
    @Test
    public void testLienAutoriseFlecheActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseSpecialisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.SPECIALISATION));
    }
    
    @Test
    public void testLienAutoriseAgregation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.AGREGATION));
    } 
    @Test
    public void testLienAutoriseClasseAssociation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.CLASSE_ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseComposition () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.COMPOSITION));
    }
    
    @Test
    public void testEltAutoriseTraitement () {
        assertTrue(this.monDiagramme.eltAutorise(this.monTraitement));
    }
    
    @Test
    public void testEltAutoriseClasse () {
        assertFalse(this.monDiagramme.eltAutorise(this.maClasse));    
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(this.monLien));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(this.monActeurActif));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(this.monActeurPassif));
    }
    
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise(this.monInterface));
    } 
    
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertFalse(this.monDiagramme.eltAutorise(this.monCasUtilisation));
    }
}