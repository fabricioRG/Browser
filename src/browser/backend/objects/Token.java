package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Token {

    private int indice;
    private String texto;
    private Variable variable;
    private Token siguienteToken;
    private Token tokenAnterior;

    public Token(String texto) {
        this.indice = 1;
        this.texto = texto;
    }

    public Token(Variable variable) {
        this.indice = 2;
        this.variable = variable;
    }    

    public Token getTokenAnterior() {
        return tokenAnterior;
    }

    public void setTokenAnterior(Token tokenAnterior) {
        this.tokenAnterior = tokenAnterior;
    }

    public Token getSiguienteToken() {
        return siguienteToken;
    }

    public void setSiguienteToken(Token siguienteToken) {
        this.siguienteToken = siguienteToken;
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
}
