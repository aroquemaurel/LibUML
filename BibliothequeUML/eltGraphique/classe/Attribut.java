package eltGraphique.classe;

/**
 * Représente un attibut d'une classe
 * 
 * @see Classe
 * @see Variable
 */
class Attribut extends Variable {
	/**
	 * La visibilité de l'attribut
	 * @see Visibilite
	 */
    private Visibilite visibilite;
	/**
	 * Attribut de classe ?
	 */
    private boolean deClasse;
	/**
	 * Constructeur de l'attribut
	 * @param p_visibilite Visibilité de l'attribut
	 * @param p_deClasse Attribut de classe ?
	 * @param p_constante Attribut constant ?
	 * @param p_type Type de l'attribut
	 * @param p_nom Nom de l'attribut
	 * 
	 * @see Visibilite
	 */
	public Attribut(Visibilite p_visibilite,
					boolean p_deClasse, boolean p_constante,
					String p_type, String p_nom) {
		super(p_constante, p_type, p_nom);
		this.deClasse = p_deClasse;
		this.visibilite = p_visibilite;
	}

	/**
	 * 
	 * @return La visibilite de l'attribut
	 * @see Visibilite
	 */
    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

	/**
	 * 
	 * @param p_visibilite La nouvelle visibilité de l'attribut
	 * @see Visibilite
	 */
    public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }

	/**
	 * 
	 * @return Attribut de classe ?
	 */
	public boolean isDeClasse() {
		return deClasse;
	}

	/**
	 * 
	 * @param deClasse Attribut de classe ?
	 */
	public void setDeClasse(boolean deClasse) {
		this.deClasse = deClasse;
	}
}
