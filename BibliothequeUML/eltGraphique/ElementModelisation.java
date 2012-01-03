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
	
//	abstract void setStyle();
	
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
	}
	
	/**
	 * Fonction appellée à chaque action 'supprimer' relative à l'élément
	 */
	@Override
    public void supprimer() {
        this.cellule.removeFromParent();
		// TODO le lien avec les actions des menus (barre/contextuel) et de la touche suppr
        // TODO une redéfinition devra être fait pour Classe qui à plusieurs cellules
    }
	
	/* GETTEURS */
	
	/**
	 * 
	 * @return La taille en hauteur de l'élément
	 */
    public double getHauteur() {
        return this.hauteur;
    }

	/**
	 * 
	 * @return La taille en largeur de l'élément
	 */
    public double getLargeur() {
        return this.largeur;
    }

	/**
	 * 
	 * @return Le texte lié à l'élément
	 */
    public String getTexte() {
        return this.texte;
    }

	/**
	 * 
	 * @return La position de l'élément
	 */
    public Point getPosition() {
        return this.position;
    }

	/*
	 * setters
	 */
	
	/**
	 * 
	 * @param p_hauteur La nouvelle taille en hauteur
	 */
    public void setHauteur(double p_hauteur) {
        this.hauteur = p_hauteur;
    }

	/**
	 * 
	 * @param p_largeur La nouvelle taille en largeur
	 */
    public void setLargeur(double p_largeur) {
        this.largeur = p_largeur;
    }

	/**
	 * 
	 * @param p_texte Le nouveau texte lié à l'élément
	 */
    public void setTexte(String p_texte) {
        this.texte = p_texte;
    }

	/**
	 * 
	 * @param p_position La nouvelle position de l'élement
	 */
    public void setPosition(Point p_position) {
        this.position = p_position;
    }

}
