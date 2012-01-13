package diagramme;

import eltGraphique.Interface;
import eltGraphique.classe.Classe;
import eltGraphique.ActeurPassif;
import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import com.mxgraph.view.mxGraph;
import eltGraphique.Traitement;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Marie-Ly
 */
public class DiagrammeSequenceTest {
    
    private Diagramme monDiagramme;
   
    @Before
    public void setUp() {
        this.monDiagramme = new DiagrammeSequence();
    }
    
    @After
    public void tearDown() {
        this.monDiagramme = null;
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.ASSOCIATION));
    } 
    @Test
    public void testLienAutoriseAssociationActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
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
    public void testLienAutoriseDependanceTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme, null, null, true),
                new Traitement(null, monDiagramme, null, null, true),
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
    public void testLienAutoriseDependanceActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.DEPENDANCE));
    } 
    @Test
    public void testLienAutoriseDependanceActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
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
                TypeLien.DEPENDANCE ));
    } 
    
    @Test
    public void testLienAutoriseDependanceActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
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
        assertTrue(this.monDiagramme.eltAutorise(new Traitement(null, monDiagramme, 
                null, null, true)));
    }
    
    @Test
    public void testEltAutoriseClasse () {
        assertFalse(this.monDiagramme.eltAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String())));    
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(new Lien(new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()),new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new mxGraph(), new Diagramme(), 
                TypeLien.ASSOCIATION)));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(new ActeurActif(new mxGraph(),
                new Diagramme(), new String())));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(new ActeurPassif(new mxGraph(), 
                new Diagramme(), new String())));
    }
    
    @Test
    public void testEltAutoriseInterface () {
        assertFalse(this.monDiagramme.eltAutorise(new Interface(new mxGraph(), 
            new String(),new Diagramme())));
    } 
    
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertFalse(this.monDiagramme.eltAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String())));
    }
}