package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Condicional {

    private Operacion condicion;
    private Bloque bloque1;
    private Bloque bloque2;

    public Condicional(Operacion condicion, Bloque bloque1, Bloque bloque2) {
        this.condicion = condicion;
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
    }

    public Operacion getCondicion() {
        return condicion;
    }

    public void setCondicion(Operacion condicion) {
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
