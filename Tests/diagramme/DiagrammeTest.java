package diagramme;

import com.mxgraph.view.mxGraph;
import eltGraphique.ActeurActif;
import eltGraphique.ActeurPassif;
import eltGraphique.CasUtilisation;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author geoffroy
 */
public class DiagrammeTest {
    
    private Diagramme monDiagramme;
    
    @Before
    public void setUp() {
        this.monDiagramme = new Diagramme();
    }
    
    @After
    public void tearDown() {
        this.monDiagramme = null;
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifCasUtilisation(){
        assertTrue(this.monDiagramme.lienAutorise(new ActeurActif(new mxGraph(),
            new Diagramme(), new String()), 
            new CasUtilisation(new mxGraph(), new Diagramme(),
            new String()), "ASSOCIATION"));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()), "ASSOCIATION"));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), "ASSOCIATION"));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertFalse(this.monDiagramme.lienAutorise(new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()), new ActeurActif(new mxGraph(), 
                new Diagramme(), new String()), "ASSOCIATION"));
    } 
    
    @Test
    public void testLienAutoriseAssociationActeurPassifCasUtilisation(){
        assertTrue(this.monDiagramme.lienAutorise(new ActeurPassif(new mxGraph(),
            new Diagramme(), new String()), new CasUtilisation(new mxGraph(),
            new Diagramme(), new String()), "ASSOCIATION"));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurPassif () {
        assertTrue(this.monDiagramme.lienAutorise(new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new ActeurPassif(new mxGraph(), 
                new Diagramme(), new String()), "ASSOCIATION"));
    }
          
    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertFalse(this.monDiagramme.lienAutorise(new ActeurPassif(new mxGraph(), 
                new Diagramme(), new String()), new ActeurPassif(new mxGraph(), 
                new Diagramme(), new String()), "ASSOCIATION"));
    }     
    
    @Test
    public void testEltAutoriseLien () {

        assertTrue(this.monDiagramme.eltAutorise(new Lien(new ActeurPassif(new mxGraph(), 
                new Diagramme(), new String()),new CasUtilisation(new mxGraph(), 
                new Diagramme(), new String()), new mxGraph(), new Diagramme(), 
                TypeLien.ASSOCIATION)));
    }     

    
    
   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
