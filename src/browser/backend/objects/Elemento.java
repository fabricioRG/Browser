package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Elemento {

    private int indice;
    private Condicional condicional;
    private Asignacion asignacion;
    private Print print;
    private CicloFor cicloFor;
    private CicloWhile cicloWhile;
    private Elemento siguienteElemento;

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
