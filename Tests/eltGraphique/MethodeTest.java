package eltGraphique;

import eltGraphique.classe.Methode;
import eltGraphique.classe.Variable;
import eltGraphique.classe.Visibilite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.Liste;

public class MethodeTest {
	private Methode methode;
	
	@Before
	public void setUp() {
		Liste<Variable> listeVariables = new Liste<Variable>();
		listeVariables.ajouterElement(new Variable(false, "int", "p_premierAttribut"));
		this.methode = new Methode(Visibilite.PUBLIC, "Object",
			"laMethodePourLesTests", listeVariables, false, false, true);
	}
	
	@After
	public void tearDown() {
		this.methode = null;
	}
	
	@Test
	public void testAjouterParametre() {
		
	}
}
