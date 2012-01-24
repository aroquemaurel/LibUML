package eltGraphique.eltModelisation;

import com.mxgraph.model.mxGeometry;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import java.awt.Dimension;
import util.Liste;
import util.Position;

/**
 * Classe ancêtre à tout élément de modélisation (classe, cas d'utilisation,
 * acteurs, traitements, etc.). Les flèches sont des liens et non des éléments
 * de modélisation.
 *
 * @see eltGraphique.ElementGraphique
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
    private Position position;

    /**
    * Taille de l'élément (hauteur/largeur)
    */
    private Dimension dimension;
	
	/**
     * Constructeur générique aux éléments de modélisation
	 * 
	 * @param p_graph Le graph auquel sera ajouté l'élément de modélisation
	 * @param p_diagramme Le diagramme auquel sera ajouté l'élément de modélisation
	 * @param p_texte Le texte qui sera associé à l'élément de modélisation
	 * @param p_dimension Les dimension de l'élément de modélisation
	 * @param p_position La position de l'élément de modélisation
	 * 
     * @see CasUtilisation
     * @see Acteur
     * @see Classe
     * @see Traitement
     * @see Interface
	 * 
	 * @see diagramme.Diagramme
	 * @see util.Position
	 */
    public ElementModelisation(mxGraph p_graph,
                                Diagramme p_diagramme, String p_texte, Dimension p_dimension, Position p_position) {
            super(p_graph, p_diagramme);
            this.texte = p_texte;
            this.dimension = p_dimension;
            this.position = p_position;
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
    * Récupère la dimension de l'élément (hauteur/largeur)
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
	* @see util.Position
    */
    @Override
    public Position getPosition() {
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
	* @see util.Position
    */
    @Override
    public void setPosition(Position p_position) {
        this.position = p_position;
    }

}
