/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramme;

import eltGraphique.ElementModelisation;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import java.awt.Dimension;
import com.mxgraph.view.mxGraph;
import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marie-Ly
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
        assertTrue(this.monDiagramme.lienAutorise(new ActeurActif(new mxGraph(),
			new Diagramme(), new String()), new CasUtilisation(new mxGraph(), new Diagramme(),
			new String()), "ASSOCIATION"));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), new Diagramme(),
			new String()), new ActeurActif(new mxGraph(), new Diagramme(), new String()), "ASSOCIATION"));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), new Diagramme(),
			new String()), new CasUtilisation(new mxGraph(), new Diagramme(), new String()), "ASSOCIATION"));
    }
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(new ActeurActif(new mxGraph(), new Diagramme(),
			new String()), new ActeurActif(new mxGraph(), new Diagramme(), new String()), "ASSOCIATION"));
    }

    @Test
    public void testLienGeneralisation () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), new Diagramme(),
			new String()), new CasUtilisation(new mxGraph(), new Diagramme(), new String()), "GENERALISATION"));
    }

    @Test
    public void testLienDependance () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), new Diagramme(),
			new String()), new CasUtilisation(new mxGraph(), new Diagramme(), new String()), "DEPENDANCE"));
    }

    @Test
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise(new CasUtilisation(new mxGraph(), new Diagramme(),
			new String())));
    }

    @Test
    public void testEltAutoriseLien () {
//        assertTrue(this.monDiagramme.eltAutorise(new Lien(ElementModelisation, ElementModelisation,
//			new mxGraph, newTypeLien())));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(new ActeurActif(new mxGraph(), new Diagramme(),
			new String())));
	}
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
