package browser.frontend.objects;

/**
 *
 * @author fabricio
 */
public class Sangria {
    
    public static String TAB = "\t";
    private String texto;

    public Sangria(String texto) {
        this.texto = TAB + texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}
