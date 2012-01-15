package diagramme;

import com.mxgraph.model.mxICell;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.TypeLien;
import util.Liste;

/**
* Cette classe permet de représenter et de manipuler <b>un Diagramme</b>.
* @author Antoine
* @author Marie-Ly
*/
public class Diagramme {
    /**
    * Liste des éléments graphiques
    */
    private final Liste<ElementGraphique> elementsGraphiques;
    
    /**
    * Constructeur qui crée une liste vide d'éléments graphiques 
    */
    public Diagramme(){
        this.elementsGraphiques = new Liste<ElementGraphique>();
    }
    
    /**
    * Méthode qui teste si le lien est autorisé ou non, en fonction du 
    * diagramme, de l'origine et de l'extrémité
    *
    * @param p_origine Element graphique qui est l'origne du lien
    * @param p_extremite Element graphique qui est l'extrémité du lien
    * @param p_typeDeFleche Type de lien testé
    * @return true s'il est, false sinon
    */
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        return true;
    }
 
    /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
     *
     * @param p_element Element à tester
     * @return true s'il est, false sinon
     */
    public boolean eltAutorise (ElementGraphique p_element){
        return true;
    }
    
    /**
     * Retourne la liste des éléments graphiques présents dans le diagramme
     *
     * @return La liste d'élément graphique
     */
    public Liste<ElementGraphique> getElementsGraphiques(){
        return (this.elementsGraphiques);
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
        
        for(final ElementGraphique element : this.elementsGraphiques){
            // on compare les adresses pour savoir si c'est la même cellule, 
	    // si c'est le cas, on a trouvé l'élément graphique, on quitte le foreach
            if(element.getCellule() == p_cellule){
                retour = element;
				break;
            }
        }

        return (retour);
    }
}
