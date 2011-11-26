/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementModelisation.DiagrammeClasse;

/**
 *
 * @author spongebob
 */
class Attribut extends Variable {
    private Visibilite visibilite;

    public Visibilite getVisibilite() {
        return (this.visibilite);
    }

    public void setVisibilite(Visibilite p_visibilite) {
        this.visibilite = p_visibilite;
    }
}
