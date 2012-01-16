package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;

/**
 * Interface d'un élément graphique
 *
 * @author Antoine
 */
public interface IntElementGraphique {
    /**
    * Méthode généique qui supprime l'élément du graphe où il est
    */
    public void supprimer();

    /**
    * Rend (in)visible l'élément grahique sur le graphe
    *
    * @param p_bool
    */
    public void setVisible(boolean p_bool);
    
    /**
    * Récupère la cellule associée à l'élément graphique
    *
    * @param p_cellule La nouvelle cellule que représente l'élément
    */
    public mxICell getCellule();

    /**
    * Modifie la cellule que représente l'élément
    *
    * @param p_cellule La nouvelle cellule que représente l'élément
    */
    public void setCellule(mxCell p_cellule);

    /**
    * Récupère le graphe auquel est associé l'élément
    * 
    * @return Le graph auquel est associé l'élément
    */
    public mxGraph getGraph();

    /**
    * Modifie le graphe auquel est associé l'élément
    *
    * @param p_graph Le nouveau graphe associé à l'élément graphique
    */
    public void setGraph(mxGraph p_graph);

    /**
     * Récupère le diagramme dans lequel est l'élément de modélisation
     *
     * @return Le diagramme
     */
    public Diagramme getDiagramme();

    /**
    * Methode abstraite
    * Crée la représentation graphique de l'élément
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
