package util;

/**
 * Position d'un élément graphique représentée par 2 coordonnées
 */
public class Position {
	/**
	 * Coordonnée d'abscisse
	 */
    private double abscisse;
	
	/**
	 * Coordonnée d'ordonnée
	 */
    private double ordonnee;
    
	/**
	 * Constructeur de la classe Position
	 * 
	 * @param p_abscisse La coordonnée en abscisse
	 * @param p_ordonnee La coordonnée en ordonnée
	 */
    public Position(double p_abscisse, double p_ordonnee){
        this.abscisse = p_abscisse;
        this.ordonnee = p_ordonnee;
    }

	/**
	 * Accesseur de l'abscisse de la position
	 * @return L'abscisse de la position
	 */
    public double getAbscisse() {
        return abscisse;
    }

	/**
	 * Modifie l'abscisse de la position
	 * @param p_abscisse La nouvelle abscisse
	 */
    public void setAbscisse(double p_abscisse) {
        this.abscisse = p_abscisse;
    }

	/**
	 * Accesseur de l'ordonnée de la position
	 * @return L'ordonnée de la position
	 */
    public double getOrdonnee() {
        return ordonnee;
    }

	/**
	 * Modifie l'ordonnée de la position
	 * @param p_ordonne La nouvelle ordonnée de la position
	 */
    public void setOrdonnee(double p_ordonne) {
        this.ordonnee = p_ordonne;
    }
    

    
}
