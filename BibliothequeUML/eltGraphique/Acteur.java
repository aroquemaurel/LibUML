package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Classe ancête aux deux types d'acteurs : actifs et passifs.
 * Ces deux types d'acteurs sont différenciers pour une raison de 
 * représentation graphique principalement
 * 
 * @see ActeurActif
 * @see ActeurPassif
 *
 * @author satenske
 */
abstract public class Acteur extends ElementModelisation {
	/**
	 * Mettre abstraite
	 * 
	 * @see ActeurActif
	 * @see ActeurPassif
	 */
    abstract public void creer();
  
	/**
	 * Mettre abstraite
	 * 
	 * @see ActeurActif
	 * @see ActeurPassif
	 */
    abstract public void afficher();
    
	/**
	 * Constructeur le la classe Acteur
	 * 
	 * @param p_graph le graphe sur lequel il faut ajouter l'acteur
	 * @param p_texte le texte qui sera afficher sur l'acteur
	 * 
	 */
	public Acteur(mxGraph p_graph, String p_texte) {
		super(p_graph, p_texte);
    }
	
	/**
	 * 
	 * @return La cellule représentée par l'acteur
	 */
	@Override
    public mxCell getCellule(){
        return this.cellule;
    }
	
	/**
	 * 
	 * @param p_cellule La cellule représentée par l'acteur
	 */
	@Override
    public void setCellule(mxCell p_cellule){
        this.cellule = p_cellule;
    }
	
	/**
	 * 
	 * @return Le graphe dans lequel est l'acteur
	 */
	@Override
    public mxGraph getGraph(){
        return this.graph;
	}
	
	/**
	 * 
	 * @param p_texte Le texte lié à l'acteur
	 */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        this.cellule.setValue(p_texte);
    }
}
