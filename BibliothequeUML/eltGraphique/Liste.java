package eltGraphique;

import java.util.ArrayList;

/**
 *
 */
public class Liste<T> {
    private ArrayList<T> laListe; 
    
    /**
     * Construit une liste vide
     */
    public Liste(){
        this.laListe = new ArrayList<T>();
    }
    
    /**
     * Ajouter un élément à la fin de la liste
     * @param p_element
     */
    public void ajouterElement(T p_element){
        this.laListe.add(p_element);
    }
    
    /**
     * Supprimer l'élément à l'index spécifié
     * @param p_index le rang à supprimer
     * @return l'élément supprimé
     */
    public T supprimerElement(int p_index){
        return (this.laListe.remove(p_index));
    }

    /**
     * Retour l'élément à l'index spécifié
     * @param p_index Le numéro de l'élément à retourner
     * @return L'élément à la place p_index
     */
    public T getElement(int p_index){
        return (this.laListe.get(p_index));
    }
        
    /**
     * Retourne vrai si la liste est vide
     * @return si la liste est vide ou non
     */
    public boolean estVide(){
        return (this.laListe.isEmpty());
    }
    
    /**
     * Retourne le nombre d'éléments de la liste
     * @return La taille de la liste
     */
    public int size(){
        return (this.laListe.size());
    }
}
