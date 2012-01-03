package eltGraphique.classe;

import com.mxgraph.view.mxGraph;
import java.util.ArrayList;

/**
 *
 */
public class Classe extends eltGraphique.ElementModelisation {
	/**
	 * Classe abstraite ?
	 */
    private boolean abstraite;
	/**
	 * Visibilité de la classe
	 * @see Visibilite
	 */
    private Visibilite visibilite;
	/**
	 * Liste des méthodes de la classe
	 * @see Methode
	 */
    private ArrayList<Methode> methodes;
	/**
	 * Liste des attributs de la classe
	 * @see Attribut
	 */
    private ArrayList<Attribut> attributs;
	/**
	 * Classe cosntante ?
	 */
    private boolean constante;
    
	/**
	 * Constructeur d'un élément 'classe'
	 * @param p_graph Le graphe auquel sera ajouter la classe
	 * @param p_texte Le texte associé à la classe (son nom)
	 */
    public Classe(mxGraph p_graph, String p_texte){
        super(p_graph, p_texte);
    }
    
	/**
	 * Ajoute une méthode à la liste des méthoes de la classe
	 * @param p_nomMethode Nom de la méthode
	 * @param p_typeDeRetour Type de retour de la méthode
	 * @param p_visibilite Visibilité de al méthode
	 * @param p_parametres Parametres de la méthode
	 * @param p_abstraite Méthode abstraite ?
	 * @param p_deClasse Méthode de classe ?
	 * @param p_constante Méthode constante ?
	 */
    public void ajouterMethode(String p_nomMethode, String p_typeDeRetour,
			       Visibilite p_visibilite, 
			       ArrayList<Variable> p_parametres,
			       boolean p_abstraite, boolean p_deClasse,
			       boolean p_constante) {
	    this.methodes.add(new Methode(p_visibilite, p_typeDeRetour,
					p_nomMethode,
					p_parametres,
					p_abstraite, p_deClasse, p_constante));
    }

	/**
	 * Ajoue un attribut à la liste d'attributs de la classe
	 * @param p_type Type de l'atribut
	 * @param p_nom Nom de l'attribut
	 * @param p_visibilite Visibilité de l'atribut
	 * @param p_constante Attribut constant ?
	 * @param p_deClasse Attribut de classe ?
	 */
    public void ajouterAttribut(String p_type, String p_nom,
                                 Visibilite p_visibilite, boolean p_constante,
                                 boolean p_deClasse) {
		this.attributs.add(new Attribut(p_visibilite,
										p_deClasse,
										p_constante,
										p_type,
										p_nom));
    }

    /*
     * Guetteurs
     */
	/**
	 * 
	 * @return Classe constante ?
	 */
    public boolean estConstante() {
        return (this.constante);
    }

	/**
	 * Classe abstraite ?
	 * @return si la classe est abstraite ou non.
	 */
    public boolean estAbstraite() {
        return (this.abstraite);
    }

	/**
	 * 
	 * @return Liste des attributs de la classe
	 * @see Attribut
	 */
    public ArrayList<Attribut> getAttributs() {
        return (this.attributs);
    }

	/**
	 * 
	 * @return Liste des méthodes de la classe
	 * @see Methode
	 */
    public ArrayList<Methode> getMethodes() {
        return (this.methodes);
    }

	/**
	 * 
	 * @return Visibilite de al classe
	 * @see Visibilite
	 */
    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

	/*
	 * Setters
	 */
	/**
	 * 
	 * @param p_visibilite Le nouvelle visibilite de la classe
	 * @see Visibilite
	 */
	public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }

	/**
	 * 
	 * @param p_constante Classe constante ?
	 */
    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

	/**
	 * 
	 * @param p_abstraite Classe abstraite ?
	 */
    public void setAbstraite(boolean p_abstraite) {
        this.abstraite = p_abstraite;
    }

	/**
	 * 
	 * @param p_attributs La nouvelle liste d'attributs
	 * @see Attribut
	 */
    public void setAttributs(ArrayList<Attribut> p_attributs) {
        this.attributs = p_attributs;
    }

	/**
	 * 
	 * @param p_methodes La nouvelle liste de méthodes
	 * @see Methode
	 */
    public void setMethodes(ArrayList<Methode> p_methodes) {
        this.methodes = p_methodes;
    }

	/**
	 * Crée la représentation graphique de la classe
	 */
    @Override
    public void creer() {
		
    }

}
