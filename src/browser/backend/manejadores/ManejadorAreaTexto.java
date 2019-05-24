package browser.backend.manejadores;

import browser.backend.analizadores.Lexer1;
import browser.backend.analizadores.parser1;
import browser.frontend.AreaTexto;
import browser.frontend.objects.Atributos;
import browser.frontend.objects.TipoLetra;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.StringReader;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author fabricio
 */
public class ManejadorAreaTexto {

    private AreaTexto at = null;
    public static int SALTO_LINEA = 10;

    public ManejadorAreaTexto(AreaTexto at) {
        this.at = at;
    }

    public AreaTexto getAt() {
        return at;
    }

    public void runText(String entrada) {
        if (!entrada.trim().isEmpty()) {
            StringReader sr = new StringReader(entrada);
            Lexer1 lexer = new Lexer1(sr);
            parser1 pars = new parser1(lexer, new ManejadorParser1(this));
            try {
                pars.parse();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Metodo que devuelve la columna actual del cursor
    public int getColumn(String entrada) {
        String texto = at.getjEditorPane1().getText();
        int posicion = at.getjEditorPane1().getCaretPosition();
        String textoLimpio = texto.replaceAll("\r\n", "\n");
        char[] cadenaChar = textoLimpio.toCharArray();
        int contador = 1;
        if (posicion > 0) {
            for (int i = 0; i < posicion; i++) {
                contador++;
                if (cadenaChar[i] == SALTO_LINEA) {
                    contador = 1;
                }
            }
        } else {
            contador = posicion + 1;
        }
        return contador;
    }

    //Metodo que devuelve la linea actual del cursor
    public int getLine() {
        String texto = at.getjEditorPane1().getText();
        int posicion = at.getjEditorPane1().getCaretPosition();
        String textoLimpio = texto.replaceAll("\r\n", "\n");
        char[] cadenaChar = textoLimpio.toCharArray();
        int contador = 1;
        for (int i = 0; i < posicion; i++) {
            if (cadenaChar[i] == SALTO_LINEA) {
                contador++;
            }
        }
        return contador;
    }

    public void mostrarTexto(String entrada, Atributos atributos) {
        // Se inserta
        try {
            SimpleAttributeSet attrs = new SimpleAttributeSet();
            switch(atributos.getEstilo()){
                case 0:
                    break;
                case 1:
                    setBold(attrs);
                    break;
                case 2:
                    setUnderline(attrs);
                    break;
                case 3:
                    setItalica(attrs);
                    break;
                case 4:
                    setStrike(attrs);
                    break;
                case 5:
                    setSubscript(attrs);
                    break;
                case 6:
                    setSuperscript(attrs);
                    break;
            }
            setForeground(atributos.getTextColor(), attrs);
            setFontFamily(atributos.getFont(), attrs);
            setFontSize(atributos.getSize(), attrs);
            setAlignment(atributos.getAlineacion(), attrs);
            at.getNavegador().getStyledDocument().insertString(at.getNavegador().getStyledDocument().getLength(), entrada, attrs);            
//            at.getNavegador().setText(entrada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAlignment(int align, SimpleAttributeSet attrs){
        switch(align){
            case 1:
                StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_LEFT);
                break;
            case 2:
                StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_RIGHT);
                break;
            case 3:
                StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_CENTER);
                break;
            case 4:
                StyleConstants.setAlignment(attrs, StyleConstants.ALIGN_JUSTIFIED);
                break;
        }
    }
    
    public void setBackground(Color color, SimpleAttributeSet attrs) {
        StyleConstants.setBackground(attrs, color);
    }

    public void setForeground(Color color, SimpleAttributeSet attrs) {
        StyleConstants.setForeground(attrs, color);
    }

    public void setFontSize(int size, SimpleAttributeSet attrs) {
        StyleConstants.setFontSize(attrs, size);
    }

    public void setFontFamily(String family, SimpleAttributeSet attrs) {
        StyleConstants.setFontFamily(attrs, family);
    }

    public void setBold(SimpleAttributeSet attrs) {
        StyleConstants.setBold(attrs, true);
    }

    public void setUnderline(SimpleAttributeSet attrs) {
        StyleConstants.setUnderline(attrs, true);
    }

    public void setItalica(SimpleAttributeSet attrs) {
        StyleConstants.setItalic(attrs, true);
    }

    public void setStrike(SimpleAttributeSet attrs) {
        StyleConstants.setStrikeThrough(attrs, true);
    }

    public void setSubscript(SimpleAttributeSet attrs) {
        StyleConstants.setSubscript(attrs, true);
    }

    public void setSuperscript(SimpleAttributeSet attrs) {
        StyleConstants.setSuperscript(attrs, true);
    }

}
