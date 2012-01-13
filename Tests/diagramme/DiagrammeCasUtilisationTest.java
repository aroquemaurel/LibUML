package diagramme;

import eltGraphique.classe.Classe;
import eltGraphique.Traitement;
import eltGraphique.ActeurPassif;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import com.mxgraph.view.mxGraph;
import eltGraphique.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeCasUtilisationTest {

    private Diagramme monDiagramme;
    
    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeCasUtilisation();
    }

    @After
    public void tearDown() {
        this.monDiagramme = null;
    }

    @Test
    public void testLienAutoriseAssociationActeurActifCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()), 
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation( new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }

    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()), 
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()), 
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurActifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
        
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }

    @Test
    public void testLienAutoriseDependanceCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
     @Test
    public void testLienAutoriseDependanceActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
     
    
    @Test
    public void testLienAutoriseDependanceActeurActifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceCasUtilisationActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurPassifCasUtilisation () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceCasUtilisationActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
            
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
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
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String())));
    }

    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(
                new Lien(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new mxGraph(), 
                new Diagramme(),
                TypeLien.ASSOCIATION)));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String())));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertFalse(this.monDiagramme.eltAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String())));
    }
    @Test
    public void testEltAutoriseTraitement () {
        assertFalse(this.monDiagramme.eltAutorise(
                new Traitement(new mxGraph(), new Diagramme(),new String(), null, false)));
    }
    @Test
    public void testEltAutoriseClasse () {
        assertFalse(this.monDiagramme.eltAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String())));    
    }
    
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise( new Interface( new mxGraph(), new String(),new Diagramme())));
    }
}