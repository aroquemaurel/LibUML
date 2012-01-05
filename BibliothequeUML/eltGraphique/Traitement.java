package eltGraphique;

import com.mxgraph.view.mxGraph;
import eltGraphique.ligne.Lien;

/**
 * Modélise un traitement par un rectangle vertical et un élément déclencheur
 */
public class Traitement extends ElementModelisation {
	/**
	 * L'élément qui déclenche le traitement (appel de méthode, etc.)
	 */
	private Lien evenementDeclencheur;

	/**
	 * Constructeur de la classe traitement
	 * @param p_graph Le graphe auquel sera ajouter le traitement
	 * @param p_texte Le texte qui sera associé au traitement
	 */
    public Traitement(mxGraph p_graph, String p_texte, Lien p_evenementDeclencheur){
        super(p_graph, p_texte);
        this.evenementDeclencheur = p_evenementDeclencheur;
    }

	/*
	 * TODO Ajouter l'acteur associé  ca peut être intéressant ??
	 * TODO String p_texte || Methode p_eltDeclencheur ?
				Problème d'héritage : Pb de modélisation;
	 */

	/**
	 * Crée la représentation graphique d'un traitement
	 */
    @Override
    public final void creer() {

    }

    public Lien getEvenementDeclencheur() {
        return evenementDeclencheur;
    }

    public void setEvenementDeclencheur(Lien evenementDeclencheur) {
        this.evenementDeclencheur = evenementDeclencheur;
    }
}
