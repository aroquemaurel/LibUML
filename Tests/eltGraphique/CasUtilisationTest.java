package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class CasUtilisationTest {
	private ElementModelisation monUseCase;

    @Before
    public void setUp() {
		this.monUseCase= new CasUtilisation(new mxGraph(), "un super test");
        this.monUseCase.creer();
    }

    @After
    public void tearDown() {
		this.monUseCase = null;
    }

    @Test
    public void testGetCellule(){
        mxICell maCellule1 = this.monUseCase.getParent();
        assertEquals(maCellule1, this.monUseCase.getCellule());

        mxICell maCellule2 = this.monUseCase.getTarget();
        assertEquals(maCellule2, this.monUseCase.getCellule());
	}

	@Test
	public void testCreer1 (){
        mxICell maCellule = this.monUseCase.getCellule();
        assertEquals(maCellule, this.monUseCase.getCellule());
	}

	@Test
	public void testCreer2(){
		assertTrue(this.monUseCase instanceof CasUtilisation);
	}

	@Test
	public void testCreer3(){
		assertEquals("USECASE", this.monUseCase.getCellule().getStyle());
	}


    @Test
    public void testSetTexte(){
		this.monUseCase.setTexte("testouille");
        assertEquals("testouille", this.monUseCase.getTexte());
    }

	@Test
	public void testSetCellule(){
		mxCell maCellulle = new mxCell();
		this.monUseCase.setCellule(maCellulle);
		assertEquals(maCellulle, this.monUseCase.getParent());
		assertEquals(maCellulle, this.monUseCase.getTarget());
	}

	@Test
    public void testSupprimer(){
        this.monUseCase.supprimer();
        assertNull(this.monUseCase.getCellule());
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}