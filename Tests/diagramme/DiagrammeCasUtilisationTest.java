package diagramme;

import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import com.mxgraph.view.mxGraph;
import eltGraphique.ActeurActif;
import eltGraphique.CasUtilisation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
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
		new Diagramme(), new String()), 
                new CasUtilisation(new mxGraph(), new Diagramme(),
		new String()), TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()), TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()), new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()), TypeLien.ASSOCIATION));
    }

    @Test
    public void testLienAutoriseGeneralisation () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), TypeLien.GENERALISATION));
    }

    @Test
    public void testLienAutoriseDependance () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), TypeLien.DEPENDANCE));
    }

    @Test
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String())));
    }

    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(new Lien(new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()),new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new mxGraph(), 
                new Diagramme(), TypeLien.ASSOCIATION)));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(new ActeurActif(new mxGraph(), 
                new Diagramme(), new String())));
	}
}