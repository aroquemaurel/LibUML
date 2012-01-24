package diagramme;

import com.mxgraph.model.mxICell;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.TypeLien;
import util.Liste;

/**
* Cette classe permet de représenter et de manipuler <b>un Diagramme</b>.
* @author Antoine
* @author Marie-Ly
* @author Geoffroy
*/
public class Diagramme {
    /**
    * Liste des éléments graphiques présents sur le diagramme
    */
    private final Liste<ElementGraphique> elementsGraphiques;
    
    /**
    * Constructeur qui crée une liste vide d'éléments graphiques 
    */
    public Diagramme(){
        this.elementsGraphiques = new Liste<ElementGraphique>();
    }
    
    /**
    * Méthode qui teste si le lien est autorisé, en fonction du 
    * diagramme, de l'origine et de l'extrémité
	* 
	* Méthode surchargée dans les classes déscendantes. Ici, elle ne 
	* restreint aucune combinaison.
    *
    * @param p_origine Elément graphique qui est l'origne du lien
    * @param p_extremite Elément graphique qui est l'extrémité du lien
    * @param p_typeDeFleche Type de lien testé
    * @return Vrai si la combinaison est autorisée, faux sinon
	* 
	* @see eltGraphique.ElementGraphique
	* @see eltGraphique.ligne.TypeLien
    */
    public boolean lienAutorise (ElementGraphique p_origine , 
            ElementGraphique p_extremite, TypeLien p_typeDeFleche){
        return true;
    }
 
    /**
     * Méthode qui teste si l'élément est autorisé ou pas dans le diagramme
	 * 
	 * Méthode surchargée dans les classes déscendantes. Ici, elle n'interdit
	 * aucun élément.
     *
     * @param p_element Elément à tester
     * @return Vrai si l'élément est autiorisé dans le diagramme, faux sinon
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
     * Retourne l'élément graphique correspondant à une cellule passée
	 * en paramètre
	 * 
     * @param p_cellule La cellule à laquelle on veut trouver l'élément 
     * graphique correspondant
	 * 
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
    
    @Override
    public String toString(){
        return("Aucune contrainte");     
    }
}
