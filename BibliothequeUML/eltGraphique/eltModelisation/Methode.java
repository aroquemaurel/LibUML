package eltGraphique.eltModelisation;

import util.Liste;

/**
* Représente une méthode en général
* 
* @author Mathieu
*/
public class Methode {
	/**
	 * Nom de la méthode
	 */
	private String nom;
        
	/**
	 * Type de retour de la méthode
	 */
	private String typeRetour;
        
	/**
	 * Visibilite de la méthode
	 *
	 * @see Visibilite
	 */
	private Visibilite visibilite;
        
	/**
	 * Liste des paramètres de la méthodes
	 *
	 * @see Variable
	 */
	private Liste<Variable> parametres;
        
	/**
	 * Méthode constante ?
	 */
	private boolean constant;
        
	/**
	 * Méthode acstraite ?
	 */
	private boolean abstraite;
        
	/**
	 * Méthode de classe ?
	 */
	private boolean deClasse;
        

	/**
	 * Constructeur d'une méthode
	 *
	 * @param p_visibilite Visibilite de la méthode
	 * @param p_typeDeRetour Type de retour de la méthode
	 * @param p_nom Nom de la méthode
	 * @param p_parametres Liste de paramètres de la méthode
	 * @param p_abstraite Méthode abstraite ?
	 * @param p_deClasse Méthode de classe ?
	 * @param p_constante Méthode constante ?
	 */
	public Methode(Visibilite p_visibilite, String p_typeDeRetour, String p_nom,
					Liste<Variable> p_parametres,
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

	/**
	 * Ajoute un paramètre à la liste de paramètres de la méthode
	 *
	 * @param p_nouveau Le nouveau paramètre qui sera ajouté
	 * @return Le paramètre ajouté
	 * @see Variable
	 */
	public Variable ajouterParametre(Variable p_nouveauParametre) {
		this.parametres.ajouterElement(p_nouveauParametre);
		return (p_nouveauParametre);
	}
	
	/**
	 * Ajoute un paramètre à la liste de paramètre de la méthode
	 * à la position souhaitée
	 *
	 * @param p_nouveauParametre Le paramètre qui sera ajouté
	 * @param p_index La position du nouvel élément dans la liste (Indice de départ : 1)
	 * @return La paramètre ajouté
	 * @see Variable
	 */
	public Variable ajouterParametre(int p_index, Variable p_nouveauParametre) {
		this.parametres.add(p_index, p_nouveauParametre);
		return (p_nouveauParametre);
	}

	/**
	 * Retourne vrai si la methode est abstraite, faux sinon.
	 *
	 * @return Méthode abstraite ?
	 */
	public boolean estAbstraite() {
		return (this.abstraite);
	}

	/**
	 * Modifie l'abstraction d'une méthode.
	 *
	 * @param abstraite Méthode abstraite ?
	 */
	public void setAbstraite(boolean abstraite) {
		this.abstraite = abstraite;
	}

	/**
	 * Retourne le nom de la méthode.
	 *
	 * @return Le nom de la méthode
	 */
	public String getNom() {
		return (this.nom);
	}

	/**
	 * Change le nom de la méthode.
	 *
	 * @param p_nom Le nouveau nom de la méthode
	 */
	public void setNom(String p_nom) {
			this.nom = p_nom;
	}

	/**
	 * Retourne vrai si la méthode est constante, faux sinon.
	 *
	 * @return Méthode constante ?
	 */
	public boolean estConstant() {
		return (this.constant);
	}

	/**
	 * Retourne vrai si la méthode est de classe, faux sinon.
	 * 
	 * @return Méthode de classe ?
	 */
	public boolean estDeClasse() {
		return (this.deClasse);
	}

	/**
	 * Récupère les paramètres de la méthode.
	 *
	 * @return La liste des paramètres de la méthode
	 */
	public Liste<Variable> getParametres() {
		return (this.parametres);
	}

	/**
	 * Récupère le type de retour de la méthode.
	 *
	 * @return Le type de retour de la méthode
	 */
	public String getTypeRetour() {
		return (this.typeRetour);
	}

	/**
	 * Récupère la visibilité de la méthode.
	 *
	 * @return La visibilite de la méthode
	 * @see Visibilite
	 */
	public Visibilite getVisibilite() {
		return (this.visibilite);
	}

	/**
	 * Modifie les paramètres de la méthode.
	 *
	 * @param p_parametres La nouvelle liste de paramètres de la méthode
	 */
	public void setParametres(Liste<Variable> p_parametres) {
		this.parametres = p_parametres;
	}

	/**
	 * Modifie le type de retour de la variable
	 *
	 * @param p_typeRetour Le nouveau type de retour de la méthode
	 */
	public void setTypeRetour(String p_typeRetour) {
		this.typeRetour = p_typeRetour;
	}

	/**
	 * Modifie la constance d'une methode.
	 *
	 * @param p_constant Méthode constante ?
	 */
	public void setConstant(boolean p_constant) {
		this.constant = p_constant;
	}

	/**
	 * Modifie le fait que la méthode est de classe.
	 *
	 * @param p_deClasse Méthode de classe ?
	 */
	public void setDeClasse(boolean p_deClasse) {
		this.deClasse = p_deClasse;
	}

	/**
	 * Modifie la visibilité de la méthode
	 *
	 * @param p_visibilite Nouvelle visibilite de la méthode
	 * @see Visibilite
	 */
	public void setVisibilite(Visibilite p_visibilite) {
		this.visibilite = p_visibilite;
	}
        
	/**
	 * Retourne une description sous forme de chaine de caractères de l'état de visibilité de la méthode.
	 *
	 * @return La chaine de caractère
	 */
	@Override
	public String toString(){
            String retour = "";

            switch(this.visibilite){
                case PRIVATE:
                    retour += "- ";
                    break;
                case PUBLIC:
                    retour += "+ ";
                    break;
                case PROTECTED:
                    retour += "~ ";
                    break;
                case PACKAGE:
                    retour += "# ";
                    break;
		}
                retour += this.getNom();
                retour += "():";
                retour += this.typeRetour;
                retour += "\n";
		return (retour);
	}
}
