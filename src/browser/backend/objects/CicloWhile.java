package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class CicloWhile {

    private Condicional condicional;
    private Bloque bloquer;    

    public CicloWhile(Condicional condicional, Bloque bloquer) {
        this.condicional = condicional;
        this.bloquer = bloquer;
    }

    public Condicional getCondicional() {
        return condicional;
    }

    public void setCondicional(Condicional condicional) {
        this.condicional = condicional;
    }

    public Bloque getBloquer() {
        return bloquer;
    }

    public void setBloquer(Bloque bloquer) {
        this.bloquer = bloquer;
    }
    
}
