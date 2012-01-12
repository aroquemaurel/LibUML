package diagramme;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marie-Ly
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
