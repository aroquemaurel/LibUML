package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;

/**
 * Classe ancêtre à tout élément graphique
 *
 *
 * @see eltGraphique.ligne.Lien
 * @see ElementModelisation
 */
abstract public class ElementGraphique extends mxCell implements IntElementGraphique {
    private mxGraph graph;

	/**
	 * Constructeur générique des éléments graphiques
	 *
	 * @param p_graph Graphe auquel sera ajouté l'élément graphique
	 */
    public ElementGraphique(mxGraph p_graph) {
        this.graph = p_graph;
    }

    /**
	 * Méthode généique qui supprime l'élément du graphe où il est
	 */
    public void supprimer() {
		super.getTarget().removeFromParent();
		super.setTarget(null);
		super.setParent(null);
    }

	/**
	 * Rend (in)visible l'élément grahique sur le graphe
	 * @param p_bool
	 */
    @Override
    public void setVisible(boolean p_bool){
        super.setVisible(p_bool);
    }
    /**
	 * Récupère la cellule associé à l'élément graphique
	 * @param p_cellule La nouvelle cellule que représente l'élément
	 */
    public mxICell getCellule(){
        return (super.getTarget());
    }

    /**
	 * Modifie la cellule que représente l'élément
	 * @param p_cellule La nouvelle cellule que représente l'élément
	 */
    public void setCellule(mxCell p_cellule){
		p_cellule.setConnectable(false);
        super.setTarget(p_cellule);
        super.setParent(p_cellule);
    }

	/**
	 * Récupère le graphe auquel est associ l'élément
	 * @return Le graph auquel est associé l'élément
	 */
    public mxGraph getGraph(){
        return (this.graph);
    }

	/**
	 * Modifie le graphe auquel est associé l'élément
	 * @param p_graph Le nouveau graphe associé à l'élément graphique
	 */
    public void setGraph(mxGraph p_graph){
        this.graph = p_graph;
    }

	/**
	 * Methode abstraite
	 * Créer la représentation graphique de l'élément
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
