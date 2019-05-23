package browser.frontend.objects;

import java.awt.Color;

/**
 *
 * @author fabricio
 */
public class Estilo {
    
    private int style;                 // 1 = bold; 2 = underline; 3 = italic; 4 = strike; 5 = sub; 6 = super;
    private String familyFont; //Family font
    private Color color;            //Color of text
    private int size;                  //Size of text
    private boolean item;        //If text is item true
    private String type;           //If type is circle, square, disc, 1, A or a
    private String texto;

    Estilo(EstiloBuilder builder) {
        this.style = builder.getStyle();
        this.familyFont = builder.getFamilyFont();
        this.color = builder.getColor();
        this.size = builder.getSize();
        this.item = builder.isItem();
        this.type = builder.getType();
        this.texto = builder.getTexto();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getFamilyFont() {
        return familyFont;
    }

    public void setFamilyFont(String familyFont) {
        this.familyFont = familyFont;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isItem() {
        return item;
    }

    public void setItem(boolean item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
