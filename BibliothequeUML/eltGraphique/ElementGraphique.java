package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import eltGraphique.ligne.Lien;
import util.Liste;

/**
 * Classe ancêtre à tout élément graphique
 *
 * @see eltGraphique.ligne.Lien
 * @see ElementModelisation
 * 
 * @author Mathieu
 * @author Antoine
 */
abstract public class ElementGraphique extends mxCell implements IntElementGraphique {
	/**
	 * Graph dans lequel aparait l'élément graphique 
	 */
    private mxGraph graph;
    
    
    /** 
     * Liste de liens partant ou pointant de l'élément graphique 
     */
    private Liste <Lien> liens;
            
       
    /**
     * Diagramme dans lequel apparait l'élément graphique 
     */
    private final Diagramme diagramme;

    /**
    * Constructeur générique des éléments graphiques
    *
    * @param p_graph Graphe auquel sera ajouté l'élément graphique
    */
    public ElementGraphique(mxGraph p_graph, Diagramme p_diagramme) {
        this.graph = p_graph;
        this.diagramme = p_diagramme;
        this.liens = new Liste<Lien>();
    }

    /**
    * Méthode générique qui supprime l'élément du graphe où il est
    */
    @Override
    public void supprimer() {
        Liste<ElementModelisation> elementRelies = new Liste<ElementModelisation>();
        
        super.getTarget().removeFromParent();  

        /* on supprime tous les liens qui vont avec l'élément graphique */
        for(Lien element : this.liens){
            elementRelies.add(element.getDestination());
            elementRelies.add(element.getSource());
            element.supprimer();
        }
        
        /* on met à jour le diagramme */
       ElementModelisation.mettreAJour(elementRelies);

        super.setTarget(null);
        super.setParent(null);
    }

    public void ajouterLien(Lien p_lien){
        this.liens.ajouterElement(p_lien);
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
    * 
    * @param p_cellule La nouvelle cellule que représente l'élément
    */
    @Override
    public mxICell getCellule(){
        return (super.getTarget());
    }

    /**
    * Modifie la cellule que représente l'élément
    * 
    * @param p_cellule La nouvelle cellule que représente l'élément
    */
    @Override
    public void setCellule(mxCell p_cellule){
        p_cellule.setConnectable(false);
        super.setTarget(p_cellule);
        super.setParent(p_cellule);
    }

    /**
    * Récupère le graphe auquel est associ l'élément
    * 
    * @return Le graph auquel est associé l'élément
    */
    @Override
    public mxGraph getGraph(){
        return (this.graph);
    }

    /**
    * Modifie le graphe auquel est associé l'élément
    * 
    * @param p_graph Le nouveau graphe associé à l'élément graphique
    */
    @Override
    public void setGraph(mxGraph p_graph){
        this.graph = p_graph;
    }

    /**
     * Récupère Le diagramme dans lequel est l'élément de modélisation
     * 
     * @return Le diagramme
     */
    @Override
    public Diagramme getDiagramme(){
        return (this.diagramme);
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
    @Override
    abstract public void creer();
}
