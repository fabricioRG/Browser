package browser.backend.objects;

import java.util.List;

/**
 *
 * @author fabricio
 */
public class Print {

    private int indice;
    private String texto;
    private Variable variable;
    private List<Print> siguientePrint;

    public Print(String texto) {
        this.indice = 1;
        this.texto = texto;
    }

    public Print(Variable variable) {
        this.indice = 2;
        this.variable = variable;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }    

    public List<Print> getSiguientePrint() {
        return siguientePrint;
    }

    public void setSiguientePrint(List<Print> siguientePrint) {
        this.siguientePrint = siguientePrint;
    }
    
}
