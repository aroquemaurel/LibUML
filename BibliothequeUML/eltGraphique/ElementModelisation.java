package eltGraphique;

import java.awt.Point;

/**
 * Classe ancêtre à tout élément de modélisation (classe, cas d'utilisation, 
 * acteurs, traitements, etc.). Les flèches sont des liens et non des éléments
 * de modélisation.
 * 
 * @see Lien
 * @author satenske
 */
abstract public class ElementModelisation extends EltGraphique {
    private String texte;
    private Point position;
    private double hauteur;
    private double largeur;
	
//	abstract void setStyle();

    public void supprimer() {

    }
	/*
	 * getters
	 */
    public double getHauteur() {
        return this.hauteur;
    }

    public double getLargeur() {
        return this.largeur;
    }

    public String getTexte() {
        return this.texte;
    }

    public Point getPosition() {
        return this.position;
    }

	/*
	 * setters
	 */
    public void setHauteur(double p_hauteur) {
        this.hauteur = p_hauteur;
    }

    public void setLargeur(double p_largeur) {
        this.largeur = p_largeur;
    }

    public void setTexte(String p_nom) {
        this.texte = p_nom;
    }

    public void setPosition(Point p_position) {
        this.position = p_position;
    }

}
