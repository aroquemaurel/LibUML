package eltGraphique;

import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import eltGraphique.classe.Methode;
/**
 * Modélise une interface par un petit cercle et un texte
 * 
 * @author satenske
 */
public class Interface extends ElementModelisation {
	/**
	 * Liste des méthodes fournies par l'inteface
	 */
    private ArrayList<Methode> listeDeMethodes;
    
	/**
	 * Constructeur d'une interface
	 * @param p_graph Le graphe auquel sera ajouter l'interface
	 * @param p_texte Le texte qui sera lié à l'interface
	 */
    public Interface(mxGraph p_graph, String p_texte){
        super(p_graph, p_texte);
		this.creer();
    }
	
	/**
	 * 
	 * @return La liste des méthodes fournies
	 */
    public ArrayList<Methode> getListeDeMethodes() {
        return (this.listeDeMethodes);
    }

	/**
	 * 
	 * @param p_listeDeMethodes La nouvelle liste des méthodes fournies
	 */
    public void setListeDeMethodes(ArrayList<Methode> p_listeDeMethodes) {
        this.listeDeMethodes = p_listeDeMethodes;
    }

	/**
	 * Crée la représentation graphique de l'interface
	 */
    @Override
    public void creer() {
		
    }
}
