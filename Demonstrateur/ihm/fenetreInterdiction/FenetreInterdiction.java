package ihm.fenetreInterdiction;

import evenements.btn.BtnJeNeLeFeraisPlus;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * superclasse étant une fenetre d'interdiction
 */
public class FenetreInterdiction extends JDialog {
    private JLabel texteInterdiction;
    private JPanel panneau;
    private ImageIcon panneauErreur;
    private BtnJeNeLeFeraisPlus boutonJeNeLeFeraisPlus;
    
    /** 
     * Paramètre la fenetre d'interdiction 
     */
    private void parametrerBoiteDialogue(){
        this.setSize(400, 130);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.boutonJeNeLeFeraisPlus.setPreferredSize(new Dimension(270,20));
        this.add(this.panneau);
        this.panneau.add(new JLabel(this.panneauErreur));
        this.panneau.add(this.texteInterdiction);
        this.panneau.add(this.boutonJeNeLeFeraisPlus);
    }
    
    /**
     * Construit la fenetre d'interdiction
     * @param p_fenetre La fenêtre dans laquelle s'afichera l'interdiction
     * @param p_texte Le texte qui devra s'afficher
     */
    public FenetreInterdiction(FenetreDemo p_fenetre, String p_texte){
        super(p_fenetre, "Interdiction");
        this.panneau = new JPanel();
        this.boutonJeNeLeFeraisPlus = new BtnJeNeLeFeraisPlus(this);
        this.texteInterdiction = new JLabel(p_texte);
        this.panneauErreur = new ImageIcon("images/erreur.png");
        this.parametrerBoiteDialogue();
    }
    
    /**
     * Affiche l'interdiction
     */
    public void afficherInterdiction(){
        this.setVisible(true);
    }
}
