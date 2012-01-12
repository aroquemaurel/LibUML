package eltGraphique.classe;

/**
 * Représente une variable en général
 */
public class Variable {
	/**
	 * Variable constante ?
	 */
    private boolean constante;
	/**
	 * Type de la variable
	 */
    private String type;
	/**
	 * Nom de la variable
	 */
    private String nom;

	/**
	 * Constructeur d'une variable
	 * @param p_constante Variable constante ?
	 * @param p_type Type de la variable
	 * @param p_nom Nom de la variable
	 */
    public Variable(boolean p_constante, String p_type, String p_nom) {
	    this.constante = p_constante;
	    this.type = p_type;
	    this.nom = p_nom;
    }

	/**
	 * Retourne vrai si la variable est constante, faux sinon
	 * @return Variable constante ?
	 */
    public boolean isConstante() {
        return (this.constante);
    }

	/**
	 * Modifie la constance de la variable
	 * @param p_constante Variable constante ?
	 */
    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

	/**
	 * Récupère le type de la variable
	 * @return Le type de la variable
	 */
    public String getType() {
        return (this.type);
    }

	/**
	 * Modifie le type de la variable
	 * @param p_typeLe nouveau type de la variable
	 */
    public void setType(String p_type) {
        this.type = p_type;
    }

	/**
	 * Récupère le nom de la variable
	 * @return Le nom de la variable
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom de la variable
	 * @param nom Le nouveau nom de la variable
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString(){
		String retour = "";
		retour += this.getNom();
		retour += ":";
		retour += this.type;

		return retour;
	}
}
