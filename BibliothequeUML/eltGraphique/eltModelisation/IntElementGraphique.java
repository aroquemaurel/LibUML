package eltGraphique.eltModelisation;

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
    * Méthode générique qui supprime l'élément du graphe où il est
    */
    public void supprimer();

    /**
    * Rend (in)visible l'élément grahique sur le graphe
	*
    * @param p_bool L'élément est visible ?
    */
    public void setVisible(boolean p_bool);
    
    /**
    * Récupère la cellule associé à l'élément graphique
	*
    * @return la cellule assicié à l'élément
    */
    public mxICell getCellule();

    /**
    * Modifie la cellule que représente l'élément
	*
    * @param p_cellule La nouvelle cellule que représente l'élément
    */
    public void setCellule(mxCell p_cellule);

    /**
    * Récupère le graphe auquel est associ l'élément
	* 
    * @return Le graphe auquel est associé l'élément
    */
    public mxGraph getGraph();

    /**
    * Modifie le graphe auquel est associé l'élément
	*
    * @param p_graph Le nouveau graphe associé à l'élément graphique
    */
    public void setGraph(mxGraph p_graph);

    /**
     * Récupère Le diagramme dans lequel est l'élément de modélisation
	 *
     * @return Le diagramme
     */
    public Diagramme getDiagramme();

    /**
    * Methode abstraite
    * Créer la représentation graphique de l'élément
    *
    * @see eltGraphique.eltModelisation.ActeurActif
    * @see eltGraphique.eltModelisation.ActeurPassif
    * @see eltGraphique.eltModelisation.CasUtilisation
    * @see eltGraphique.eltModelisation.Interface
    * @see eltGraphique.eltModelisation.Traitement
    * @see eltGraphique.eltModelisation.Classe
    */
    abstract public void creer();
}
