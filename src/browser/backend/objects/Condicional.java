package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Condicional {

    private boolean condicion;
    private Bloque bloque1;
    private Bloque bloque2;

    public Condicional(boolean condicion, Bloque bloque1, Bloque bloque2) {
        this.condicion = condicion;
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    public Bloque getBloque1() {
        return bloque1;
    }

    public void setBloque1(Bloque bloque1) {
        this.bloque1 = bloque1;
    }

    public Bloque getBloque2() {
        return bloque2;
    }

    public void setBloque2(Bloque bloque2) {
        this.bloque2 = bloque2;
    }
    
}
