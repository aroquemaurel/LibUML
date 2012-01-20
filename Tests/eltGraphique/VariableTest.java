/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltGraphique;

import eltGraphique.eltModelisation.Variable;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mathieu
 */
public class VariableTest {
	private Variable variable;
	
	@Before
	public void setUp() {
		this.variable = new Variable(false, "Object", "variablePourLesTests");
	}
	
	@After
	public void tearDown() {
		this.variable = null;
	}
	
	@Test
	public void testConstante() {
		this.variable.setConstante(true);
		assertTrue(this.variable.estConstante());
	}
	
	@Test
	public void testType() {
		this.variable.setType("NouveauType");
		assertEquals("NouveauType", this.variable.getType());
	}
	
	@Test
	public void testNom() {
		this.variable.setNom("nouveauNom");
		assertEquals("nouveauNom", this.variable.getNom());
	}
	
	@Test
	public void testToString() {
		assertEquals("variablePourLesTests:Object", this.variable.toString());
	}
}
