package eltGraphique;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Mathieu
 */
public interface IntElementModelisation {
	/**
	 * Récupère la taille de l'élément (hauteur/largeur)
	 * @return La dimension de l'élément (hauteur/largeur)
	 */
    public Dimension getDimension();

	/**
	 * Récupère le texte lié à l'élément
	 * @return Le texte lié à l'élément
	 */
    public String getTexte();

	/**
	 * Récupère la position de l'élément sur le graphe
	 * @return La position de l'élément
	 */
    public Point getPosition();

	/**
	 * Modifie la dimension de l'élément (hauteur/largeur)
	 * @param p_dimension La nouvelle dimension (hauteur/largeur)
	 */
    public void setDimension(Dimension p_dimension);

	/**
	 * Modifie le texte lié à l'élément
	 * @param p_texte Le nouveau texte lié à l'élément
	 */
    public void setTexte(String p_texte);

	/**
	 * Modifie la position de l'élément
	 * @param p_position La nouvelle position de l'élement
	 */
    public void setPosition(Point p_position);

}
