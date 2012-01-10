package diagramme;

import com.mxgraph.model.mxICell;
import eltGraphique.ElementGraphique;
import eltGraphique.Liste;

/**
 *
 * @author satenske
 */
public class Diagramme {
     /**
     * liste des éléments graphiques
     */
    private Liste<ElementGraphique> elementsGraphique;

    public Diagramme(){
        this.elementsGraphique = new Liste<ElementGraphique>();
    }
    
    public boolean lienAutorise (ElementGraphique p_origine , ElementGraphique p_extremite, String p_typeDeFleche){
        return true;
    }
 
    public boolean eltAutorise (ElementGraphique p_element){
        return true;
    }
    
    /**
     * Retourne la liste des éléments graphiques présent dans le diagramme
     * @return La liste d'élément graphique
     */
    public Liste<ElementGraphique> getElementsGraphiques(){
        return (this.elementsGraphique);
    }
    
    /**
     * Retourne un élément graphique qu'il a obtenu depuis une cellule du graph
     * @param p_cellule La cellule à laquelle on veut trouver l'élément graphique correspondant
     * @return L'élément graphique obtenu ou null si aucun élément n'a été trouvé pour cette cellule
     */
    public ElementGraphique getElementGraphiqueViaCellule(mxICell p_cellule){
        ElementGraphique retour = null;
        
        for(final ElementGraphique element : this.elementsGraphique){
            // on compare les adresse pour savoir si c'est la même cellule
            if(element.getCellule() == p_cellule){
                retour = element;
            }
        }
        
        return (retour);
    }
}
