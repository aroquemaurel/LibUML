package eltGraphique.eltModelisation;

import com.mxgraph.model.mxGeometry;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import java.awt.Dimension;
import java.awt.Point;
import util.Liste;

/**
 * Classe ancêtre à tout élément de modélisation (classe, cas d'utilisation,
 * acteurs, traitements, etc.). Les flèches sont des liens et non des éléments
 * de modélisation.
 *
 * @see Lien
 * 
 * @author Antoine
 * @author Mathieu
 */
abstract public class ElementModelisation extends ElementGraphique implements IntElementModelisation {
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
            super(p_graph, p_diagramme);
            this.texte = p_texte;
            this.dimension = p_dimension;
    }

    /**
    * Met à jour l'élément grahique courant
    */
    public void mettreAJour(){
        super.getGraph().updateCellSize(super.getCellule());
        super.getGraph().resizeCell(super.getCellule(),
                    new mxGeometry(super.getCellule().getGeometry().getX(),
                    super.getCellule().getGeometry().getY(),
                    this.getDimension().getWidth(),this.getDimension().getHeight()));

    }

        /**
    * Met à jour la liste des éléments de la liste
    * @param p_elements La liste d'éléments graphiques à mettre à jour
    */
    static public void mettreAJour(Liste<ElementModelisation> p_elements){
        for(ElementModelisation element : p_elements){
            element.mettreAJour();
        }
    }
    
    /**
    * Récupère la taille de l'élément (hauteur/largeur)
	*
    * @return La dimension de l'élément (hauteur/largeur)
    */
    @Override
    public Dimension getDimension() {
        return (this.dimension);
    }

    /**
    * Récupère le texte lié à l'élément
	*
    * @return Le texte lié à l'élément
    */
    @Override
    public String getTexte() {
        return this.texte;
    }

    /**
    * Récupère la position de l'élément sur le graphe
	*
    * @return La position de l'élément
    */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
    * Modifie la dimension de l'élément (hauteur/largeur)
	*
    * @param p_dimension La nouvelle dimension (hauteur/largeur)
    */
    @Override
    public void setDimension(Dimension p_dimension) {
        this.dimension = p_dimension;
		super.getGraph().getModel().beginUpdate();
                super.getGraph().updateCellSize(super.getCellule());
                super.getCellule().getGeometry().setWidth(p_dimension.getWidth());
                super.getCellule().getGeometry().setHeight(p_dimension.getHeight());
		super.getGraph().getModel().endUpdate();
    }

    /**
    * Modifie le texte lié à l'élément
	*
    * @param p_texte Le nouveau texte lié à l'élément
    */
    @Override
    public void setTexte(String p_texte) {
                super.getCellule().setValue(p_texte);
                this.texte = p_texte;
    }

    /**
    * Modifie la position de l'élément
	*
    * @param p_position La nouvelle position de l'élement
    */
    @Override
    public void setPosition(Point p_position) {
        this.position = p_position;
    }

}
