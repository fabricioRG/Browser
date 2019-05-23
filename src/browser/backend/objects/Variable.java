package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Variable {

    private int indice;
    private String string;
    private int integer;
    private boolean bool;

    public Variable(String string) {
        this.indice = 1;
        this.string = string;
    }

    public Variable(int integer) {
        this.indice = 2;
        this.integer = integer;
    }

    public Variable(boolean bool) {
        this.indice = 3;
        this.bool = bool;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
    
    
    
}
