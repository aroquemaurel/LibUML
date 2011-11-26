package ElementModelisation.DiagrammeClasse;

import java.util.ArrayList;

/**
 *
 * @author satenske
 */
public class Classe extends ElementModelisation.ElementModelisation {
    private String typeDeRetour;
    private boolean abstraite;
    private Visibilite visibilite;
    private ArrayList<Methode> methodes;
    private ArrayList<Attribut> attributs;
    private boolean constante;

    public void ajouterMethode(String p_nomMethode, String p_typeDeRetour,
                               Visibilite p_visibilite, boolean p_deClasse,
                               boolean p_constante) {

    }

    public void ajouterAttributs(String p_type, String p_nom,
                                 Visibilite p_visibilite, boolean p_constante,
                                 boolean p_deClasse) {

    }

    /*
     * Guetteurs
     */
    public boolean estConstante() {
        return (this.constante);
    }

    public boolean estAbstraite() {
        return (this.abstraite);
    }

    public ArrayList<Attribut> getAttributs() {
        return (this.attributs);
    }

    public ArrayList<Methode> getMethodes() {
        return (this.methodes);
    }

    public String getTypeDeRetour() {
        return (this.typeDeRetour);
    }

    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

	/*
	 * Setters
	 */
	public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }

    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

    public void setAbstraite(boolean p_abstraite) {
        this.abstraite = p_abstraite;
    }

    public void setAttributs(ArrayList<Attribut> p_attributs) {
        this.attributs = p_attributs;
    }

    public void setMethodes(ArrayList<Methode> p_methodes) {
        this.methodes = p_methodes;
    }

    public void setTypeDeRetour(String p_typeDeRetour) {
        this.typeDeRetour = p_typeDeRetour;
    }

}
