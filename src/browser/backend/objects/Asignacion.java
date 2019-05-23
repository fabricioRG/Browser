package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Asignacion {

    private Variable variable;
    private int indice;
    private int valor;
    private String cadena;
    private boolean bool;

    public Asignacion(Variable variable, int valor) {
        this.indice = 1;
        this.variable = variable;
        this.valor = valor;
    }

    public Asignacion(Variable variable, String cadena) {
        this.indice = 2;
        this.variable = variable;
        this.cadena = cadena;
    }

    public Asignacion(Variable variable, boolean bool) {
        this.indice = 3;
        this.variable = variable;
        this.bool = bool;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
}
