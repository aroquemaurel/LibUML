package util;

/**
 * Position d'un élément graphique
 */
public class Position {
    private double abscisse;
    private double ordonne;
    
    public Position(double p_abscisse, double p_ordonnee){
        this.abscisse = p_abscisse;
        this.ordonne = p_ordonnee;
    }

    public double getAbscisse() {
        return abscisse;
    }

    public void setAbscisse(double p_abscisse) {
        this.abscisse = p_abscisse;
    }

    public double getOrdonne() {
        return ordonne;
    }

    public void setOrdonne(double p_ordonne) {
        this.ordonne = p_ordonne;
    }
    

    
}
