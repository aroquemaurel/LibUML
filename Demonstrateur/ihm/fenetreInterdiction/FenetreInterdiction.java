package ihm.fenetreInterdiction;

import evenements.btn.BtnJeNeLeFeraisPlus;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 */
public class FenetreInterdiction extends JDialog {
    //private JButton boutonJeNeLeFeraisPlus;
    private JLabel texteInterdiction;
    private JPanel panneau;
    private ImageIcon panneauErreur;
    private BtnJeNeLeFeraisPlus boutonJeNeLeFeraisPlus;
    
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
    public FenetreInterdiction(FenetreDemo p_fenetre, String p_texte){
        super(p_fenetre, "Interdiction");
        this.panneau = new JPanel();
        this.boutonJeNeLeFeraisPlus = new BtnJeNeLeFeraisPlus(this);
        this.texteInterdiction = new JLabel(p_texte);
        this.panneauErreur = new ImageIcon("images/erreur.png");
        this.parametrerBoiteDialogue();
    }
    
    public void afficherInterdiction(){
        this.setVisible(true);
    }
}
