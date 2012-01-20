package eltGraphique;

import eltGraphique.eltModelisation.Attribut;
import eltGraphique.eltModelisation.Visibilite;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe Attribut
 * 
 * @see Attribut
 */
public class AttributTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private Attribut attribut;
	
	/**
	 * Initialisation du champ avant chaque test
	 */
	@Before
	public void setUp() {
		this.attribut = new Attribut(Visibilite.PRIVATE, false, false, "String", "attributPourLesTests");
	}
	
	/**
	 * Suppression de ce champ après chaque test
	 */
	@After
	public void tearDown() {
		this.attribut = null;
	}
	
	/**
	 * Test unitaire qui teste la modification de l'attribut visibilite
	 * 
	 * Vérifie que :
	 *  - la modification de l'attribut visibilite est effective
	 */
	@Test
	public void testVisibilite() {
		this.attribut.setVisibilite(Visibilite.PACKAGE);
		assertEquals(Visibilite.PACKAGE, this.attribut.getVisibilite());
	}
	
	/**
	 * Test unitaire qui teste la modification du fait que l'attribut
	 * est de classe
	 * 
	 * Vérifie que :
	 *  - la modification de l'attribut deClasse est effective
	 */
	@Test
	public void testDeClasse() {
		this.attribut.setDeClasse(true);
		assertTrue(this.attribut.estDeClasse());
	}
	
	/**
	 * Test unitaire qui teste le retour de la méthode toString()
	 * 
	 * Vérifie que :
	 *  - la génération de la chaîne est correcte
	 */
	@Test
	public void testToString() {
		assertEquals("- attributPourLesTests:String\n", this.attribut.toString());
	}
}
