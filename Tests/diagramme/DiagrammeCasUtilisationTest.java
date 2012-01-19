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
public class DiagrammeCasUtilisationTest {

    private Diagramme monDiagramme;
    private mxGraph monGraph;
    private String maString;
    private ActeurActif monActeurActif;
    private CasUtilisation monCasUtilisation;
    private ActeurPassif monActeurPassif;
    private Traitement monTraitement;
    private Classe maClasse;
    private Interface monInterface;
    
    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeCasUtilisation();
        this.monGraph = new mxGraph();
        this.maString = "un test";
        
        this.monActeurActif = new ActeurActif(monGraph, monDiagramme, maString);
        this.monActeurPassif = new ActeurPassif(monGraph, monDiagramme, maString);
        this.monCasUtilisation = new CasUtilisation(monGraph, monDiagramme, maString);
        this.monTraitement = new Traitement(monGraph, monDiagramme, maString, null, false);
        this.maClasse = new Classe(monGraph, monDiagramme, maString);
        this.monInterface = new Interface (monGraph, maString, monDiagramme);
        
        
    }

    @After
    public void tearDown() {
        this.monDiagramme = null;
    }

    @Test
    public void testLienAutoriseAssociationActeurActifCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif, 
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
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
    public void testLienAutoriseAssociationActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif, 
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
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
    public void testLienAutoriseGeneralisationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurActifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurPassif,
                TypeLien.GENERALISATION));
    }
        
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurPassif,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurPassif,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }

    @Test
    public void testLienAutoriseDependanceCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
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
    public void testLienAutoriseDependanceActeurActifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monCasUtilisation,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceCasUtilisationActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monCasUtilisation,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
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
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                this.monActeurPassif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
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
    public void testLienAutoriseComposition () {
        assertFalse(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.COMPOSITION));
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
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monCasUtilisation));
    }

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

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monActeurActif));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertFalse(this.monDiagramme.eltAutorise(
                this.monActeurPassif));
    }
    @Test
    public void testEltAutoriseTraitement () {
        assertFalse(this.monDiagramme.eltAutorise(
                this.monTraitement));
    }
    @Test
    public void testEltAutoriseClasse () {
        assertFalse(this.monDiagramme.eltAutorise(
                this.maClasse));    
    }
    
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise( 
                this.monInterface));
    }
}