package eltGraphique;

import eltGraphique.eltModelisation.Methode;
import eltGraphique.eltModelisation.Variable;
import eltGraphique.eltModelisation.Visibilite;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import util.Liste;

/**
 * Cas de test JUnit regroupant les tests unitaires de chaque méthode
 * de la classe Methode
 * 
 * @see Methode
 */
public class MethodeTest {
	/**
	 * Le champ sur lequel on effectuera les tests
	 */
	private Methode methode;
	
	/**
	 * Initialisation du champ avant chaque test
	 */
	@Before
	public void setUp() {
		Liste<Variable> listeVariables = new Liste<Variable>();
		listeVariables.ajouterElement(new Variable(false, "int", "p_premierAttribut"));
		this.methode = new Methode(Visibilite.PUBLIC, "Object",
			"laMethodePourLesTests", listeVariables, false, false, false);
	}
	
	/**
	 * Suppression de ce champ après chaque test
	 */
	@After
	public void tearDown() {
		this.methode = null;
	}
	
	/**
	 * Test unitaire qui vérifie l'ajout d'un paramètre à la liste
	 * des paramètres de la méthode sans passage de l'index
	 * 
	 * Vérifie que :
	 *  - le nouveau paramètre est dans la liste des paramètres de la méthode
	 */
	@Test
	public void testAjouterParametreSansIndex() {
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(nouveauParametre);
		assertTrue(this.methode.getParametres().contains(nouveauParametre));
	}
	
	/**
	 * Test unitaire qui teste que la taille est incrémentée de 1 après ajout
	 * d'un paramètre sans index
	 * 
	 * Vérifie que :
	 *  - la nouvelle taille est égale à l'ancienne + 1
	 */
	@Test
	public void testAjouterParametreSansIndexTailleListe() {
		int taille = this.methode.getParametres().taille();
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(nouveauParametre);
		assertEquals(taille+1, this.methode.getParametres().size());
	}
	
	/**
	 * Test unitaire qui vérifie l'ajout d'un paramètre à la liste
	 * des paramètres de la méthode avec passage de l'index
	 * 
	 * Vérifie que :
	 *  - le nouveau paramètre est dans la liste des paramètres de la méthode
	 */
	@Test
	public void testAjouterParametreAvecIndex() {
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(1, nouveauParametre);
		assertEquals(nouveauParametre, this.methode.getParametres().get(1));
	}
	
	/**
	 * Test unitaire qui teste que la taille est incrémentée de 1 après ajout
	 * d'un paramètre avec index
	 * 
	 * Vérifie que :
	 *  - la nouvelle taille est égale à l'ancienne + 1
	 */
	@Test
	public void testAjouterParametreAvecIndexTailleListe() {
		int taille = this.methode.getParametres().taille();
		Variable nouveauParametre = new Variable(false, "Object", "p_nouveauParam");
		this.methode.ajouterParametre(1, nouveauParametre);
		assertEquals(taille+1, this.methode.getParametres().size());
	}
	
	/**
	 * Test unitaire qui vérifie la modification de l'état abstrait d'une méthode
	 * 
	 * Vérifie que :
	 *  - la classe est passée abstraite
	 */
	@Test
	public void testAbstraite() {
		this.methode.setAbstraite(true);
		assertTrue(this.methode.estAbstraite());
	}
	
	/**
	 * Test unitaire qui vérifie la modification de l'état constant d'une méthode
	 * 
	 * Vérifie que :
	 *  - la classe est passée constante
	 */
	@Test
	public void testConstante() {
		this.methode.setConstant(true);
		assertTrue(this.methode.estConstant());
	}
	
	
	/**
	 * Test unitaire qui vérifie la modification de l'état de classe d'une méthode
	 * 
	 * Vérifie que :
	 *  - la classe est passée de classe
	 */
	@Test
	public void testDeClasse() {
		this.methode.setDeClasse(true);
		assertTrue(this.methode.estDeClasse());
	}
	
	/**
	 * Test unitaire qui teste la modification du nom de la méthode
	 * 
	 * Vérifie que :
	 *  - le texte est assigné correctement
	 */
	@Test
	public void testNom() {
		this.methode.setNom("nouveauNom");
		assertEquals("nouveauNom", this.methode.getNom());
	}
	
	/**
	 * Test unitaire qui vérifie l'instanciation de la liste des paramètres
	 * d'une méthode
	 * 
	 * Vérifie que :
	 *  - la liste des paramètres est une instance de Liste
	 */
	@Test
	public void testInstanceParametre() {
		assertTrue(this.methode.getParametres() instanceof Liste);
	}
	
	/**
	 * Test unitaire qui vérifie la modification de la liste des paramètres
	 * de la méthode
	 * 
	 * Vérifie que :
	 *  - la liste des méthodes est assignée correctement
	 */
	@Test
	public void testParametres() {
		Liste<Variable> nouvelleListe = new Liste<Variable>();
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		this.methode.setParametres(nouvelleListe);
		assertEquals(nouvelleListe, this.methode.getParametres());
	}
	
	/**
	 * Test unitaire qui vérifie la modification de la taille de la liste
	 * des paramètres de la classe lors de l'ajout d'un paramètre à la méthode
	 * 
	 * Vérifie que :
	 *  - la nouvelle taille est égale à l'ancienne + 1
	 */
	@Test
	public void testParametresTailleListe() {
		Liste<Variable> nouvelleListe = new Liste<Variable>();
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		nouvelleListe.ajouterElement(new Variable(true, null, null));
		this.methode.setParametres(nouvelleListe);
		assertEquals(3, this.methode.getParametres().size());
	}
	
	/**
	 * Test unitaire qui vérifie la modification de la visibilite de la méthode
	 * 
	 * Vérifie que :
	 *  - la nouvelle visibilite est assignée correctement
	 */
	@Test
	public void testVisibilite() {
		this.methode.setVisibilite(Visibilite.PACKAGE);
		assertEquals(Visibilite.PACKAGE, this.methode.getVisibilite());
	}
	
	/**
	 * Test unitaire qui vérifie la modification du type de retour de la
	 * méthode
	 * 
	 * Vérifie que :
	 *  - le nouveau type de retour est assigné correctement
	 */
	@Test
	public void testTypeDeRetour() {
		this.methode.setTypeRetour("String");
		assertEquals("String", this.methode.getTypeRetour());
	}
	
	/**
	 * Test unitaire qui teste le retour de la méthode toString
	 * 
	 * Vérifie que :
	 *  - la chaîne retournée est correcte
	 */
	@Test
	public void testToString() {
		assertEquals("+ laMethodePourLesTests():Object\n", this.methode.toString());
	}
}
