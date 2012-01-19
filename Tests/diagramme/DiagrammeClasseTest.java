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
 * Classe de test unitaires de la classe <b>DiagrammeClasse</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeClasseTest {

    private Diagramme monDiagramme;
    private mxGraph monGraph;
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
        this.monDiagramme = new DiagrammeClasse();
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
    }
    
    @Test
    public void testLienAutoriseCompositionClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseClasseAssociationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.CLASSE_ASSOCIATION));    
    }
    @Test
    public void testLienAutoriseClasseAssociationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.CLASSE_ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseClaseeAssociationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.CLASSE_ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    @Test
    public void testLienAutoriseAssociationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    @Test
    public void testLienAutoriseGeneralisationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseDependanceLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseAgregationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseSpecialisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.SPECIALISATION));
    }
    
    @Test
    public void testLienAutoriseFleche () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testEltAutoriseClasse () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.maClasse));    
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise( this.monLien));
    }
    
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertFalse(this.monDiagramme.eltAutorise(this.monCasUtilisation));
    }
    
    @Test
    public void testEltAutoriseActeurActif () {
        assertFalse(this.monDiagramme.eltAutorise(this.monActeurActif));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertFalse(this.monDiagramme.eltAutorise(this.monActeurPassif));
    }
    
    @Test
    public void testEltAutoriseTraitement () {
        assertFalse(this.monDiagramme.eltAutorise( this.monTraitement));
    }  
    
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise( this.monInterface));
    } 
    
}
