package eltGraphique;

import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import java.awt.Dimension;
import java.awt.Point;

/**
 * Classe ancêtre à tout élément de modélisation (classe, cas d'utilisation,
 * acteurs, traitements, etc.). Les flèches sont des liens et non des éléments
 * de modélisation.
 *
 * @see Lien
 */
abstract public class ElementModelisation extends ElementGraphique {
	/**
	 * Texte à afficher avec l'élément
	 */
    private String texte;

	/**
	 * Position de l'élément
	 */
    private Point position;

	/**
	 * Taille de l'élément (hauteur/largeur)
	 */
	private Dimension dimension;
        
        private Diagramme diagramme;

	/**
	 * Constructeur générique aux éléments de modélisation
	 *
	 * @see CasUtilisation
	 * @see Acteur
	 * @see Classe
	 * @see Traitement
	 * @see Interface
	 */
	public ElementModelisation(mxGraph p_graph,
                                   Diagramme p_diagramme, String p_texte, Dimension p_dimension) {
		super(p_graph);
                this.diagramme = p_diagramme;
		this.texte = p_texte;
		this.dimension = p_dimension;
		//TODO Initiliser hauteur/largeur/position. Utiliser Dimension ?
	}

	/* GETTEURS */

	/**
	 * Récupère la taille de l'élément (hauteur/largeur)
	 * @return La dimension de l'élément (hauteur/largeur)
	 */
    public Dimension getDimension() {
        return (this.dimension);
    }

	/**
	 * Récupère le texte lié à l'élément
	 * @return Le texte lié à l'élément
	 */
    public String getTexte() {
        return this.texte;
    }

	/**
	 * Récupère la position de l'élément sur le graphe
	 * @return La position de l'élément
	 */
    public Point getPosition() {
        return this.position;
    }

	/*
	 * setters
	 */

	/**
	 * Modifie la dimension de l'élément (hauteur/largeur)
	 * @param p_dimension La nouvelle dimension (hauteur/largeur)
	 */
    public void setDimension(Dimension p_dimension) {
        this.dimension = p_dimension;
    }

	/**
	 * Modifie le texte lié à l'élément
	 * @param p_texte Le nouveau texte lié à l'élément
	 */
    public void setTexte(String p_texte) {
        this.texte = p_texte;
    }

	/**
	 * Modifie la position de l'élément
	 * @param p_position La nouvelle position de l'élement
	 */
    public void setPosition(Point p_position) {
        this.position = p_position;
    }

}
