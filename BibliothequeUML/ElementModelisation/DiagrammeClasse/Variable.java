/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementModelisation.DiagrammeClasse;

/**
 *
 * @author spongebob
 */
abstract class Variable {
    private String type;
    private boolean constante;

    public boolean isConstante() {
        return (this.constante);
    }

    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

    public String getType() {
        return (this.type);
    }

    public void setType(String p_type) {
        this.type = p_type;
    }
}
