package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Classe propre aux acteurs passif (représentation graphique)
 * 
 * @see Acteur
 * @see ActeurPassif
 * 
 * @author satenske
 */
public class ActeurActif extends Acteur {
	/**
	 * Constructeur de la classe ActeurActif qui créer un acteur actif 
	 * lié à un graph donné avec un texte donné
	 * @param p_graph Le graphe sur lequel sera l'acteur actif
	 * @param p_texte Le texte lié à l'acteur actif
	 */
    public ActeurActif(mxGraph p_graph, String p_texte){
        super(p_graph, p_texte);
		this.creer();
    }
    /**
	 * Crée la représentation de l'acteur actif
	 */
    @Override
    public final void creer(){
        Object parent = super.getGraph().getDefaultParent();
        super.setCellule((mxCell) super.getGraph().insertVertex(
            parent, null, super.getTexte(), 30, 30, 60, 85, "ACTEUR"));
        super.getCellule().setVisible(false);
    }

	/**
	 * Affiche l'acteur sur le graphe
	 */
    @Override
    public void afficher() {
        super.getCellule().setVisible(true);
    }
}

