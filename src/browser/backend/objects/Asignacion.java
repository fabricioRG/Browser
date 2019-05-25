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
    private Operacion operacion;

    public Asignacion(Variable variable, Operacion operacion) {
        this.variable = variable;
        this.operacion = operacion;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
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
