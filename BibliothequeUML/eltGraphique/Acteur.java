package eltGraphique;

import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import java.awt.Dimension;

/**
 * Classe ancête aux deux types d'acteurs : actifs et passifs.
 * Ces deux types d'acteurs sont différenciers pour une raison de
 * représentation graphique principalement
 *
 * @see ActeurActif
 * @see ActeurPassif
 *
 */
abstract public class Acteur extends ElementModelisation {
    /**
     * Méthode abstraite
     * Crée la représentation graphique de l'acteur
     *
     * @see ActeurActif
     * @see ActeurPassif
     */
    @Override
    abstract public void creer();


    /**
     * Constructeur le la classe Acteur
     *
     * @param p_graph le graphe sur lequel il faut ajouter l'acteur
     * @param p_texte le texte qui sera afficher sur l'acteur
     *
     */
    public Acteur(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Dimension p_dimension) {
            super(p_graph, p_diagramme, p_texte, p_dimension);
    }

    /**
     * Modifie le texte lié à l'acteur.
     * @param p_texte Le texte lié à l'acteur
     */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.setValue(p_texte);
    }
}
