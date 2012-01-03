package eltGraphique;

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
	 * @param p_texte Le texte lié à l'acteur
	 */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.getTarget().setValue(p_texte);
    }
}
