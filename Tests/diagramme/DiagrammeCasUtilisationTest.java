/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diagramme;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
