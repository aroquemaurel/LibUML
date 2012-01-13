package diagramme;

import com.mxgraph.view.mxGraph;
import eltGraphique.*;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeClasseTest {

    private Diagramme monDiagramme;

    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeClasse();
    }

    @After
    public void tearDown() {
	this.monDiagramme = null;
    }
    
    @Test
    public void testLienAutoriseCompositionClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.ASSOCIATION));    
    }
    @Test
    public void testLienAutoriseAssociationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.GENERALISATION));    
    }
    @Test
    public void testLienAutoriseGeneralisationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseDependanceLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseAgregationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationClasseLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienClasse () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienLien () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testEltAutoriseAgregationClasse () {
        assertTrue(this.monDiagramme.eltAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String())));    
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise( new Lien( null, null, new mxGraph(), new Diagramme(),null)));
    }
    
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertFalse(this.monDiagramme.eltAutorise(new CasUtilisation(new mxGraph(), new Diagramme(),
			new String())));
    }
    
    @Test
    public void testEltAutoriseActeurActif () {
        assertFalse(this.monDiagramme.eltAutorise(new ActeurActif(new mxGraph(), new Diagramme(),
			new String())));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertFalse(this.monDiagramme.eltAutorise(new ActeurPassif(new mxGraph(), new Diagramme(),
			new String())));
    }
    
    @Test
    public void testEltAutoriseTraitement () {
        assertFalse(this.monDiagramme.eltAutorise( new Traitement( new mxGraph(), new Diagramme(),new String(), null)));
    }  
    
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise( new Interface( new mxGraph(), new String(),new Diagramme())));
    } 
    
}