package eltGraphique.classe;

/**
 *
 * @author spongebob
 */
abstract class Variable {
    private boolean constante;
    private String type;
    private String nom;	
    
    public Variable(boolean p_constante, String p_type, String p_nom) {
	    this.constante = p_constante;
	    this.type = p_type;
	    this.nom = p_nom;
    }

    public boolean isConstante() {
        return (this.constante);
    }

    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

    public String getType() {
        return (this.type);
    }

    public void setType(String p_type) {
        this.type = p_type;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
