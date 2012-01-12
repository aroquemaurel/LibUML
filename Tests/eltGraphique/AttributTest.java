package eltGraphique;

import eltGraphique.classe.Attribut;
import eltGraphique.classe.Visibilite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
	
}
