package eltGraphique.classe;

import java.util.ArrayList;

/**
*
* @author spongebob
*/
public class Methode {
	private String nom;
	private String typeRetour;
	private Visibilite visibilite;
	private ArrayList<Variable> parametres;
	private boolean constant;
	private boolean abstraite;
	private boolean deClasse;

	public Methode(Visibilite p_visibilite, String p_typeDeRetour, String p_nom,
					ArrayList<Variable> p_parametres,
					boolean p_abstraite,
					boolean p_deClasse,
					boolean p_constante) {
		this.visibilite = p_visibilite;
		this.typeRetour = p_typeDeRetour;
		this.nom = p_nom;
		this.parametres = p_parametres;
		this.abstraite = p_abstraite;
		this.deClasse = p_deClasse;
		this.constant = p_constante;
	}

	public void ajouterParametre(String nom, String type, boolean constant) {

	}

	/*
	 * Getters
	 */


	public boolean isAbstraite() {
		return abstraite;
	}

	public void setAbstraite(boolean abstraite) {
		this.abstraite = abstraite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
			this.nom = nom;
	}
	
	public boolean estConstant() {
		return (this.constant);
	}

	public boolean estDeClasse() {
		return (this.deClasse);
	}

	public ArrayList<Variable> getParametres() {
		return (this.parametres);
	}

	public String getTypeRetour() {
		return (this.typeRetour);
	}

	public Visibilite getVisibilite() {
		return (this.visibilite);
	}

	/*
	 * Setters
	 */
	public void setParametres(ArrayList<Variable> p_parametres) {
		this.parametres = p_parametres;
	}

	public void setTypeRetour(String p_typeRetour) {
		this.typeRetour = p_typeRetour;
	}

	public void setConstant(boolean p_constant) {
		this.constant = p_constant;
	}

	public void setDeClasse(boolean p_deClasse) {
		this.deClasse = p_deClasse;
	}

	public void setVisibilite(Visibilite p_visibilite) {
		this.visibilite = p_visibilite;
	}
}
