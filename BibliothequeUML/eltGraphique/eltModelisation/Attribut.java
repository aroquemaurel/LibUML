package eltGraphique.eltModelisation;

/**
 * Représente un attibut d'une classe
 * 
 * @see Classe
 * @see Variable
 * 
 * @author Mathieu
 */
public class Attribut extends Variable {
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
    * Constructeur de la classe attribut
	*
    * @param p_visibilite Visibilité de l'attribut
    * @param p_deClasse Attribut de classe ?
    * @param p_constante Attribut constant ?
    * @param p_type Type de l'attribut
    * @param p_nom Nom de l'attribut
    * 
    * @see Visibilite
    */
    public Attribut(Visibilite p_visibilite, boolean p_deClasse, boolean p_constante,
                                    String p_type, String p_nom) {
            super(p_constante, p_type, p_nom);
            this.deClasse = p_deClasse;
            this.visibilite = p_visibilite;
    }

    /**
    * Récupère la visibilite de l'attribut
	*
    * @return La visibilite de l'attribut
    * @see Visibilite
    */
    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

    /**
    * Modifie la visibilité de l'attribut
	*
    * @param p_visibilite La nouvelle visibilité de l'attribut
    * @see Visibilite
    */
    public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }

    /**
    * Attribut de classe ?
	*
    * @return Retourne vrai si l'attribut est de classe, faux sinon
    */
    public boolean estDeClasse() {
            return deClasse;
    }

    /**
    * Modifie le fait que l'attribut soit de classe
	*
    * @param deClasse Attribut de classe ?
    */
    public void setDeClasse(boolean deClasse) {
            this.deClasse = deClasse;
    }

	/**
	 * Chaîne formatée des caractéristiques de l'attribut
	 *
	 * @return La chaîne de caractère contenant l'attribut formaté 
	 */
    @Override
    public String toString() {
        String retour = new String();
        switch(this.visibilite) {
            case PRIVATE:
                retour += "- ";
                break;
            case PUBLIC:
                retour += "+ ";
                break;
            case PACKAGE:
                retour += "# ";
                break;
            case PROTECTED:
                retour += "~ ";
            default:
                retour += " ";                   
        }
        retour += super.toString();
        retour += "\n";

        return(retour);
    }
}
