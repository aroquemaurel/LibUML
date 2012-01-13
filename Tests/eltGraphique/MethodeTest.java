package eltGraphique;

import eltGraphique.classe.Methode;
import eltGraphique.classe.Variable;
import eltGraphique.classe.Visibilite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.Liste;

public class MethodeTest {
	private Methode methode;
	
	@Before
	public void setUp() {
		Liste<Variable> listeVariables = new Liste<Variable>();
		listeVariables.ajouterElement(new Variable(false, "int", "p_premierAttribut"));
		this.methode = new Methode(Visibilite.PUBLIC, "Object",
			"laMethodePourLesTests", listeVariables, false, false, false);
	}
	
	@After
	public void tearDown() {
		this.methode = null;
	}
	
	@Test
	public void testAjouterParametreSansIndex() {
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(nouveauParametre);
		assertTrue(this.methode.getParametres().contains(nouveauParametre));
	}
	
	@Test
	public void testAjouterParametreSansIndexTailleListe() {
		int taille = this.methode.getParametres().taille();
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(nouveauParametre);
		assertEquals(taille+1, this.methode.getParametres().size());
	}
	
	@Test
	public void testAjouterParametreAvecIndex() {
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(1, nouveauParametre);
		assertEquals(nouveauParametre, this.methode.getParametres().get(1));
	}
	
	@Test
	public void testAjouterParametreAvecIndexTailleListe() {
		int taille = this.methode.getParametres().taille();
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(1, nouveauParametre);
		assertEquals(taille+1, this.methode.getParametres().size());
	}
	
	@Test
	public void testAbstraite() {
		this.methode.setAbstraite(true);
		assertTrue(this.methode.estAbstraite());
	}
	
	@Test
	public void testConstante() {
		this.methode.setConstant(true);
		assertTrue(this.methode.estConstant());
	}
	
	@Test
	public void testDeClasse() {
		this.methode.setDeClasse(true);
		assertTrue(this.methode.estDeClasse());
	}
	
	@Test
	public void testNom() {
		this.methode.setNom("nouveauNom");
		assertEquals("nouveauNom", this.methode.getNom());
	}
	
	@Test
	public void testInstanceParametre() {
		assertTrue(this.methode.getParametres() instanceof Liste);
	}
	
	@Test
	public void testParametres() {
		Liste<Variable> nouvelleListe = new Liste<Variable>();
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		this.methode.setParametres(nouvelleListe);
		assertEquals(nouvelleListe, this.methode.getParametres());
	}
	
	@Test
	public void testParametresTailleListe() {
		Liste<Variable> nouvelleListe = new Liste<Variable>();
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		this.methode.setParametres(nouvelleListe);
		assertEquals(3, this.methode.getParametres().size());
	}
	
	@Test
	public void testVisibilite() {
		this.methode.setVisibilite(Visibilite.PACKAGE);
		assertEquals(Visibilite.PACKAGE, this.methode.getVisibilite());
	}
	
	@Test
	public void testTypeDeRetour() {
		this.methode.setTypeRetour("String");
		assertEquals("String", this.methode.getTypeRetour());
	}
	
	@Test
	public void testToString() {
		assertEquals("+ laMethodePourLesTests():Object\n", this.methode.toString());
	}
}
