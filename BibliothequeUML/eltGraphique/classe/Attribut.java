package eltGraphique.classe;

/**
 *
 * @author spongebob
 */
class Attribut extends Variable {
    private Visibilite visibilite;
    private boolean deClasse;
	public Attribut(Visibilite p_visibilite,
					boolean p_deClasse, boolean p_constante,
					String p_type, String p_nom) {
		super(p_constante, p_type, p_nom);
		this.deClasse = p_deClasse;
		this.visibilite = p_visibilite;
	}

    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

    public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }

	public boolean isDeClasse() {
		return deClasse;
	}

	public void setDeClasse(boolean deClasse) {
		this.deClasse = deClasse;
	}
}
