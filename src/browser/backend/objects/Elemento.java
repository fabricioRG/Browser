package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Elemento {

    private int indice;
    private Condicional condicional;// 1
    private Asignacion asignacion;// 2
    private Print print;// 3
    private CicloFor cicloFor;// 4
    private CicloWhile cicloWhile;// 5
    private Variable variable; // 6
    private Operacion operacion;// 7
    private Elemento siguienteElemento;
    private Elemento elementoAnterior;

    public Elemento(Condicional condicional) {
        this.indice = 1;
        this.condicional = condicional;
    }

    public Elemento(Asignacion asignacion) {
        this.indice = 2;
        this.asignacion = asignacion;
    }

    public Elemento(Print print) {
        this.indice = 3;
        this.print = print;
    }

    public Elemento(CicloFor cicloFor) {
        this.indice = 4;
        this.cicloFor = cicloFor;
    }

    public Elemento(CicloWhile cicloWhile) {
        this.indice = 5;
        this.cicloWhile = cicloWhile;
    }

    public Elemento(Variable variable) {
        this.indice = 6;
        this.variable = variable;
    }
    
    public Elemento(Operacion operacion) {
        this.indice = 7;
        this.operacion = operacion;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Elemento getElementoAnterior() {
        return elementoAnterior;
    }

    public void setElementoAnterior(Elemento elementoAnterior) {
        this.elementoAnterior = elementoAnterior;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Condicional getCondicional() {
        return condicional;
    }

    public void setCondicional(Condicional condicional) {
        this.condicional = condicional;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public Print getPrint() {
        return print;
    }

    public void setPrint(Print print) {
        this.print = print;
    }

    public CicloFor getCicloFor() {
        return cicloFor;
    }

    public void setCicloFor(CicloFor cicloFor) {
        this.cicloFor = cicloFor;
    }

    public CicloWhile getCicloWhile() {
        return cicloWhile;
    }

    public void setCicloWhile(CicloWhile cicloWhile) {
        this.cicloWhile = cicloWhile;
    }

    public Elemento getSiguienteElemento() {
        return siguienteElemento;
    }

    public void setSiguienteElemento(Elemento siguienteElemento) {
        this.siguienteElemento = siguienteElemento;
    }
    
}
