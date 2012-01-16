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
 * @author Marie-Ly
 * @author Geoffroy
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
    public void testLienAutoriseFlecheTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheActeurActifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.FLECHE));
    } 
    @Test
    public void testLienAutoriseFlecheActeurPassifTraitement () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheTraitementActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheTraitementActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme,null, null, true),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.FLECHE));
    }
    
    @Test
    public void testLienAutoriseFlecheActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.FLECHE));
    } 
    
    @Test
    public void testLienAutoriseFlecheActeurActifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.FLECHE));
    } 
    
    @Test
    public void testLienAutoriseFlecheActeurPassifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
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