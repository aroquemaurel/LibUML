package util;

import java.util.ArrayList;

/**
 * Cette classe permet de gérer et de modifier la liste des éléments d'un diagramme.
 * @author Antoine
 */
public class Liste<T> extends ArrayList<T> {
    
    /**
     * Construit une liste vide
     */
    public Liste(){
        super();
    }
    
    /**
     * Ajouter un élément à la fin de la liste
	 *
     * @param p_element L'élément qui sera ajouté
     */
    public void ajouterElement(T p_element){
        super.add(p_element);
    }
    
    /**
     * Supprimer l'élément à l'index spécifié
	 *
     * @param p_index le rang de l'élément à supprimer
     * @return l'élément supprimé
     */
    public T supprimerElement(int p_index){
        return (super.remove(p_index));
    }

    /**
     * Retourne l'élément à l'index spécifié
	 *
     * @param p_index L'index de l'élément à retourner
     * @return L'élément à la place p_index
     */
    public T getElement(int p_index){
        return (super.get(p_index));
    }
        
    /**
     * Méthode qui contrôle si la liste est vide
	 * Equivalent à (l.taille() == 0)
	 *
     * @return Vrai si la liste est vide, faux sinon
     */
    public boolean estVide(){
        return (super.isEmpty());
    }
    
    /**
     * Retourne le nombre d'éléments de la liste
	 *
     * @return La taille de la liste
     */
    public int taille(){
        return (super.size());
    }
}
