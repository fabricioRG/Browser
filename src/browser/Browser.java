package browser;

import browser.backend.manejadores.ManejadorAnalizador;
import browser.frontend.Analizador;

/**
 *
 * @author fabricio
 */
public class Browser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Analizador an = new Analizador();
        an.setVisible(true);
    }
    
}
