package browser.backend.manejadores;

import browser.frontend.AreaTexto;
import browser.frontend.Analizador;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author fabricio
 */
public class ManejadorAnalizador {

    static final String NEW_TAB = "new tab";
    static final String TIPO_TXT = ".txt";
    private Analizador analizador = null;
    private static ManejadorAnalizador INSTANCE = null;

    private ManejadorAnalizador() {
    }

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ManejadorAnalizador();
        }
    }

    public static ManejadorAnalizador getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }
    
    public void setAnalizador(Analizador analizador) {
        this.analizador = analizador;
    }

    //Metodo encargado de abrir una ventana en blanco
    public void agregarVentana() {
        AreaTexto at = new AreaTexto();
        analizador.jTabbedPane.add(NEW_TAB, at);
        estadoGuardar();
    }

    //Metodo encargado de agregar una nueva ventana con el texto cargado colocando como
    //nombre de la ventana el path absoluta de tal
    public void agregarVentana(String path, String texto) {
        AreaTexto at = new AreaTexto();
        at.getjEditorPane1().setText(texto);
        analizador.jTabbedPane.add(path, at);
    }

    //Metodo encargado de abrir una nueva ventana colocandole como texto inicial el seleccionado
    public void abrirDocumento(int i) {
        
    }

    //Metodo encargado de cerrar una ventanva, verificando que se hayan guardado los cambios o no
    public void cerrarVentana(int ventana) {
        AreaTexto at = (AreaTexto) analizador.jTabbedPane.getSelectedComponent();
        if (at.isModificado()) {
            int respuesta = JOptionPane.showConfirmDialog(analizador, "¿Desea guardar los cambios?",
                    "Alerta!", JOptionPane.YES_NO_CANCEL_OPTION);
            if (respuesta == JOptionPane.NO_OPTION) {
                analizador.jTabbedPane.remove(ventana);
                estadoGuardar();
            } else if (respuesta == JOptionPane.YES_OPTION) {
                guardarArchivo(ventana);
                analizador.jTabbedPane.remove(ventana);
                estadoGuardar();
            }
        } else {
            analizador.jTabbedPane.remove(ventana);
            estadoGuardar();
        }
    }

    //Metodo encargado de guardar un archivo, en el cual dependiendo si ya ha sido guardado o no
    public void guardarArchivo(int i) {
        if (analizador.jTabbedPane.getTitleAt(i).equals(NEW_TAB)) {
            guardarArchivoComo(i, 1);
        } else {
            guardarComo(analizador.jTabbedPane.getTitleAt(i));
        }
    }

    public void guardarArchivoComo(int i, int opcion) {
        
    }

    //Metodo que muestra un dialogo que contiene la informacion del desarrollador
    public void mostrarInformacionDesarrollador() {
        ImageIcon desarrollador = new ImageIcon("desarrollador.png");
        String informacion = "";
        informacion = "                     Analizador Lexico\n\n"
                + "                      Desarrollado por:\n"
                + "            Ivan Fabricio Racancoj García\n"
                + "                            201731115\n5to Semestre Ing. Sistemas CUNOC - USAC";
        JOptionPane.showMessageDialog(analizador, informacion, "About...", JOptionPane.INFORMATION_MESSAGE, desarrollador);
    }

    //Metodo encargado de guardar en un archivo con nombre del path recibido como parametro y escribiendo
    //en el documento el texto contenido en el jEditorPanel del la tabla actual o abierta
    private void guardarComo(String path) {
        
    }

    //Metodo que cambia el estado de los botones "guardar" y "guardar como" dependiendo de las tablas abiertas
    private void estadoGuardar() {
        boolean estado = true;
        if (analizador.jTabbedPane.getComponentCount() < 1) {
            estado = false;
        } else {
            estado = true;
        }
        analizador.jMenuItemSave.setEnabled(estado);
        analizador.jMenuItemSaveAs.setEnabled(estado);
        analizador.jMenuItemCloseTab.setEnabled(estado);
    }

    //Metodo encargado de cerrar todas las ventanas abiertas
    public void cerrarVentanas(int tamaño) {
        for (int i = tamaño - 1; i >= 0; i--) {
            cerrarVentana(i);
        }
        if (analizador.getComponentCount() < 1) {
            System.exit(0);
        }
    }

}
