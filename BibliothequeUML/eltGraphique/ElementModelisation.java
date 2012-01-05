package eltGraphique;

import com.mxgraph.view.mxGraph;
import java.awt.Point;

/**
 * Classe ancêtre à tout élément de modélisation (classe, cas d'utilisation, 
 * acteurs, traitements, etc.). Les flèches sont des liens et non des éléments
 * de modélisation.
 * 
 * @see Lien
 */
abstract public class ElementModelisation extends EltGraphique {
	/**
	 * Texte à afficher avec l'élément
	 */
    private String texte;
	/**
	 * Position de l'élément
	 */
    private Point position;
	/**
	 * Taille en hauteur de l'élément
	 */
    private double hauteur;
	/**
	 * Taille en largeur de l'élément
	 */
    private double largeur;
	
	/**
	 * Constructeur générique aux éléments de modélisation
	 * 
	 * @see CasUtilisation
	 * @see Acteur
	 * @see Classe
	 * @see Traitement
	 * @see Interface
	 */
	public ElementModelisation(mxGraph p_graph, String p_texte) {
		super(p_graph);
		this.texte = p_texte;
                //TODO Initiliser hauteur/largeur/position. Utiliser Dimension ?
	}
	
	/* GETTEURS */
	
	/**
	 * Récupère la taille en hauteur de l'élément
	 * @return La taille en hauteur de l'élément
	 */
    public double getHauteur() {
        return this.hauteur;
    }

	/**
	 * Récupère la taille en largeur de l'élément
	 * @return La taille en largeur de l'élément
	 */
    public double getLargeur() {
        return this.largeur;
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
	 * Modifie la hauteur de l'élément
	 * @param p_hauteur La nouvelle taille en hauteur
	 */
    public void setHauteur(double p_hauteur) {
        this.hauteur = p_hauteur;
    }

	/**
	 * Modifie la taille en largeur de l'élément
	 * @param p_largeur La nouvelle taille en largeur
	 */
    public void setLargeur(double p_largeur) {
        this.largeur = p_largeur;
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
