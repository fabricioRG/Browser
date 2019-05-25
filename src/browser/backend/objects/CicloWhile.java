package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class CicloWhile {

    private Operacion condicion;
    private Bloque bloquer;    

    public CicloWhile(Operacion condicion, Bloque bloquer) {
        this.condicion = condicion;
        this.bloquer = bloquer;
    }

    public Operacion getCondicion() {
        return condicion;
    }

    public void setCondicion(Operacion condicion) {
        this.condicion = condicion;
    }

    public Bloque getBloquer() {
        return bloquer;
    }

    public void setBloquer(Bloque bloquer) {
        this.bloquer = bloquer;
    }
    
}
