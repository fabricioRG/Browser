package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class CicloFor {

    private Variable variable;
    private int inicio;
    private int fin;
    private Bloque bloque;

    public CicloFor(Variable variable, int inicio, int fin, Bloque bloque) {
        this.variable = variable;
        this.inicio = inicio;
        this.fin = fin;
        this.bloque = bloque;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }
    
}
