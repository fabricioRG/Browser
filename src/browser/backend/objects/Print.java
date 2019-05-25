package browser.backend.objects;

import java.util.List;

/**
 *
 * @author fabricio
 */
public class Print {

    private int indice;
    private Token listaToken;

    public Print(Token listaToken) {
        this.listaToken = listaToken;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Token getListaToken() {
        return listaToken;
    }

    public void setListaToken(Token siguientePrint) {
        this.listaToken = siguientePrint;
    }
    
}
