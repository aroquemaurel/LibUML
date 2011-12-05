/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm.Menu;

import javax.swing.JButton;

/**
 *
 * @author satenske
 */
public class MenuGauche extends Menu {
    public MenuGauche(int p_largeurPanneau, int p_longueurPanneau){
        super(p_largeurPanneau, p_longueurPanneau);
    }
    
    @Override
    public void ajouterObjetsGraphiques() {
        super.add(new JButton("mkj"));        
        super.add(new JButton("mkj"));  
        super.add(new JButton("mkj"));  
        super.add(new JButton("mkj"));  
        super.add(new JButton("mkj"));  
        super.add(new JButton("mkj"));  
        super.add(new JButton("mkj"));  
    }
    
}
