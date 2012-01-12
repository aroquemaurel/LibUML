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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
