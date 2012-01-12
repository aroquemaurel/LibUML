package diagramme;

import com.mxgraph.model.mxICell;
import eltGraphique.ElementGraphique;
import util.Liste;

/**
 * @author satenske
 * @author Marie-Ly
 */
public class Diagramme {
     /**
     * Liste des éléments graphiques
     */
    private Liste<ElementGraphique> elementsGraphique;

    public Diagramme(){
        this.elementsGraphique = new Liste<ElementGraphique>();
    }
    
    /**
     * Méthode qui teste si le lien est autorisé ou non, en fonction du 
     * diagramme, de l'origine et de l'extrémité
     * @param p_origine
     * @param p_extremite
     * @param p_typeDeFleche
     * @return true s'il est, false sinon
     */
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, String p_typeDeFleche){
        return true;
    }
 
    /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
     * @param p_element
     * @return true s'il est, false sinon
     */
    public boolean eltAutorise (ElementGraphique p_element){
        return true;
    }
    
    /**
     * Retourne la liste des éléments graphiques présents dans le diagramme
     * @return La liste d'élément graphique
     */
    public Liste<ElementGraphique> getElementsGraphiques(){
        return (this.elementsGraphique);
    }
    
    /**
     * Retourne un élément graphique qu'il a obtenu depuis une cellule du graph
     * @param p_cellule La cellule à laquelle on veut trouver l'élément 
     * graphique correspondant
     * @return L'élément graphique obtenu ou null si aucun élément n'a été 
     * trouvé pour cette cellule
     */
    public ElementGraphique getElementGraphiqueViaCellule(mxICell p_cellule){
        ElementGraphique retour = null;
        
        for(final ElementGraphique element : this.elementsGraphique){
            // on compare les adresses pour savoir si c'est la même cellule
            if(element.getCellule() == p_cellule){
                retour = element;
            }
        }
        return (retour);
    }
}