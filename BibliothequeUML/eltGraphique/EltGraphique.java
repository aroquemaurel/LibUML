package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.util.HashMap;

/**
 * Classe ancêtre à tout élément graphique
 *
 * @author satenske
 * 
 * @see eltGraphique.ligne.Lien
 * @see ElementModelisation
 */
abstract public class EltGraphique {
    protected mxCell cellule;
    protected mxGraph graph;    
    
	/**
	 * Crée tous les styles nécessaires à la représentations des éléments 
	 * graphiques
	 * 
	 * @see eltGraphique
	 */
    private void creerLesStyle() {
		mxStylesheet stylesheet =
		    this.graph.getStylesheet();
		HashMap<String, Object> style =
		    new HashMap<String, Object>();

        /* Ateur */
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ACTOR);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("ACTEUR", style);


		/* UseCase */
		style = null;
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("USECASE", style);
        
        /* Spécialisation */
        style = null;
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_EDGE,
			  mxConstants.EDGESTYLE_ORTHOGONAL);
        style.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		stylesheet.putCellStyle("SPECIALISATION", style);        
        
        /* Lien continu */
        style = null;
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_EDGE,
			  mxConstants.EDGESTYLE_ORTHOGONAL);
        style.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_SPACING);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		stylesheet.putCellStyle("LIENCONTINU", style);          
	}
   
	/**
	 * Constructeur générique des éléments graphiques
	 * 
	 * @param p_graph Graphe auquel sera ajouté l'élément graphique
	 */
    public EltGraphique(mxGraph p_graph){
        this.graph = p_graph;
        this.creerLesStyle();
    }
    
    /**
	 * Méthode généique qui supprime l'élément du graphe où il est
	 */
    public void supprimer() {
        this.cellule.removeFromParent();
    }
    
	/**
	 * Rend (in)visible l'élément grahique sur le graphe
	 * @param p_bool 
	 */
    public void setVisible(boolean p_bool){
        this.cellule.setVisible(p_bool);     
    }
    
	/**
	 * 
	 * @return La cellule que représente l'élément graphique
	 */
    public mxCell getCellule(){
        return this.cellule;
    }
	
    /**
	 * 
	 * @param p_cellule La nouvelle cellule que représente l'élément
	 */
    public void setCellule(mxCell p_cellule){
        this.cellule = p_cellule;
    }    
    
	/**
	 * 
	 * @return Le graph auquel est associé la cellule
	 */
    public mxGraph getGraph(){
        return (this.graph);
    }
    
	/**
	 * 
	 * @param p_graph Le nouveau graphe associé à l'élément graphique
	 */
    public void setGraph(mxGraph p_graph){
        this.graph = p_graph;
    }
	
	/**
	 * Methode abstraite
	 * 
	 * @see ActeurActif
	 * @see ActeurPassif
	 * @see CasUtilisation
	 * @see Interface
	 * @see Traitement
	 * @see classe.Classe
	 */
    abstract public void creer();    
}
