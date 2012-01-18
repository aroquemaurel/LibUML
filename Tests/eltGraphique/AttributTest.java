package eltGraphique;

import eltModelisation.Attribut;
import eltModelisation.Visibilite;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class AttributTest {
	private Attribut attribut;
	
	@Before
	public void setUp() {
		this.attribut = new Attribut(Visibilite.PRIVATE, false, false, "String", "attributPourLesTests");
	}
	
	@After
	public void tearDown() {
		this.attribut = null;
	}
	
	@Test
	public void testVisibilite() {
		this.attribut.setVisibilite(Visibilite.PACKAGE);
		assertEquals(Visibilite.PACKAGE, this.attribut.getVisibilite());
	}
	
	@Test
	public void testDeClasse() {
		this.attribut.setDeClasse(true);
		assertTrue(this.attribut.estDeClasse());
	}
	
	@Test
	public void testToString() {
		assertEquals("- attributPourLesTests:String\n", this.attribut.toString());
	}
}
