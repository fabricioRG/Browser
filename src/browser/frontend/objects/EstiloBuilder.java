package browser.frontend.objects;

import java.awt.Color;

/**
 *
 * @author fabricio
 */
public class EstiloBuilder {
    
    private int style;                 // 1 = bold; 2 = underline; 3 = italic; 4 = strike; 5 = sub; 6 = super;
    private String familyFont; //Family font
    private Color color;            //Color of text
    private int size;                  //Size of text
    private boolean item;        //If text is item true
    private String type;           //If type is circle, square, disc, 1, A or a
    private String texto;
    
    public EstiloBuilder(){
    }
    
    public EstiloBuilder style(int style){
        this.style = style;
        return this;
    }
    
    public EstiloBuilder familyFont(String familyFont){
        this.familyFont = familyFont;
        return this;
    }
    
    public EstiloBuilder color(Color color){
        this.color = color;
        return this;
    }
    
    public EstiloBuilder size(int size){
        this.size = size;
        return this;
    }
    
    public EstiloBuilder item(boolean item){
        this.item = item;
        return this;
    }
    
    public EstiloBuilder type(String type){
        this.type = type;
        return this;
    }
     
    public EstiloBuilder texto(String texto){
        this.texto = texto;
        return this;
    }
    
    public Estilo build(){
       return new Estilo(this);
    }

    public int getStyle() {
        return style;
    }

    public String getTexto() {
        return texto;
    }

    public String getFamilyFont() {
        return familyFont;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public boolean isItem() {
        return item;
    }

    public String getType() {
        return type;
    }
    
}
