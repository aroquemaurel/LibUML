package eltGraphique;

import java.awt.Point;

/**
 *
 * @author satenske
 */
abstract public class ElementModelisation extends EltGraphique {
    private String nom;
    private Point position;
    private double hauteur;
    private double largeur;

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

    public String getNom() {
        return this.nom;
    }

    public Point getPosition() {
        return this.position;
    }

	/*
	 * setters
	 */
    public void setHauteur(double p_hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(double p_largeur) {
        this.largeur = p_largeur;
    }

    public void setNom(String p_nom) {
        this.nom = p_nom;
    }

    public void setPosition(Point p_position) {
        this.position = p_position;
    }

}
