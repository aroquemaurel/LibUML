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
    
    public ElementGraphique getElementGraphiqueViaCellule(mxICell p_cellule){
        ElementGraphique retour = null;
        
        for(final ElementGraphique element : this.elementsGraphique){
            if(element.getCellule() == p_cellule){
                System.out.print("CACAMOU!!");
            }
        }
        return (retour);
    }
}
