/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementModelisation;

import com.mxgraph.model.mxCell;
import java.awt.Point;

/**
 *
 * @author satenske
 */
abstract public class ElementModelisation extends mxCell {
    private String nom;
    private Point position;
    private double hauteur;
    private double largeur;

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    public void supprimer() {
        
    }
}
