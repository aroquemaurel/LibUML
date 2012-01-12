/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramme;

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
 *
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
        assertTrue(this.monDiagramme.lienAutorise(new Traitement(null, monDiagramme, null, null, true), new Traitement(null, monDiagramme, null, null, true), "ASSOCIATION"));
    }
    
    @Test
    public void testLienDependanceAssociationTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(new Traitement(null, monDiagramme, null, null, true), new Traitement(null, monDiagramme, null, null, true), "DEPENDANCE"));
    }
    
    @Test
    public void testEltAutoriseTraitement () {
        assertTrue(this.monDiagramme.eltAutorise(new Traitement(null, monDiagramme, null, null, true)));
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(new Lien( new ActeurActif(new mxGraph(), new Diagramme(), new String()),new CasUtilisation(new mxGraph(), new Diagramme(), new String()), new mxGraph(), new Diagramme(), TypeLien.ASSOCIATION)));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(new ActeurActif(new mxGraph(), new Diagramme(),
			new String())));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(new ActeurPassif(new mxGraph(), new Diagramme(),
			new String())));
    }
}
