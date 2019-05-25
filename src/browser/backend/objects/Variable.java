package browser.backend.objects;

/**
 *
 * @author fabricio
 */
public class Variable {

    private int indice;
    private String key;
    private String string; //1
    private int integer; // 2   
    private boolean bool; //3
    private String texto; // 4

    public Variable() {
    }

    public Variable(String string, int option) {
        if(option == 1){
            this.indice = 1;
            this.string = string.substring(1, string.length() - 1);
        } else if (option == 2){
            this.indice = 4;
            this.texto = string;
        }
    }

    public Variable(int integer) {
        this.indice = 2;
        this.integer = integer;
    }

    public Variable(boolean bool) {
        this.indice = 3;
        this.bool = bool;
    }    
    
    public Variable(String string, String key) {
        this.indice = 1;
        this.key = key;
        this.string = string;
    }

    public Variable(int integer, String key) {
        this.indice = 2;
        this.key = key;
        this.integer = integer;
    }

    public Variable(boolean bool, String key) {
        this.indice = 3;
        this.key = key;
        this.bool = bool;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
