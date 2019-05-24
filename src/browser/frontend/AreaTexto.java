package browser.frontend;

import browser.backend.manejadores.ManejadorAreaTexto;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JEditorPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author fabricio
 */
public class AreaTexto extends javax.swing.JPanel implements KeyListener, MouseListener {

    public String textoIngresado = "";
    private ManejadorAreaTexto mat = null;
    private boolean modificado = false;

    /**
     * Creates new form AreaTexto
     */
    public AreaTexto() {
        initComponents();
        interprete.addKeyListener(this);
        interprete.addMouseListener(this);
        mat = new ManejadorAreaTexto(this);
        navegador.setEditable(false);
        jPanelErrores.setVisible(false); //Panel no visible hasta que se encuentre un error o se llame por aparte
        sizeLabel.setText(navegador.getPreferredSize().height + " x " + navegador.getPreferredSize().width);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        interprete = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelColummna = new javax.swing.JLabel();
        jLabelLinea = new javax.swing.JLabel();
        jPanelErrores = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableErrores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        navegador = new javax.swing.JTextPane();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setPreferredSize(new java.awt.Dimension(844, 455));

        interprete.setBackground(new java.awt.Color(2, 36, 61));
        interprete.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        interprete.setForeground(new java.awt.Color(254, 254, 254));
        interprete.setToolTipText("");
        interprete.setCaretColor(new java.awt.Color(248, 248, 240));
        interprete.setMargin(new java.awt.Insets(7, 7, 7, 7));
        jScrollPane1.setViewportView(interprete);

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 36, 61));
        jLabel1.setText("Line:");

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 36, 61));
        jLabel2.setText("Column:");

        jLabelColummna.setForeground(new java.awt.Color(2, 36, 61));
        jLabelColummna.setText(" ");

        jLabelLinea.setForeground(new java.awt.Color(2, 36, 61));
        jLabelLinea.setText(" ");

        jPanelErrores.setBackground(new java.awt.Color(2, 36, 61));
        jPanelErrores.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaErrorObser}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTableErrores);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreLexema}"));
        columnBinding.setColumnName("Lexema");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${columna}"));
        columnBinding.setColumnName("Columna");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fila}"));
        columnBinding.setColumnName("Fila");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTableErrores);

        jLabel3.setFont(new java.awt.Font("Caviar Dreams", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setText("Variables");

        javax.swing.GroupLayout jPanelErroresLayout = new javax.swing.GroupLayout(jPanelErrores);
        jPanelErrores.setLayout(jPanelErroresLayout);
        jPanelErroresLayout.setHorizontalGroup(
            jPanelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelErroresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelErroresLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelErroresLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(50, 50, 50))))
        );
        jPanelErroresLayout.setVerticalGroup(
            jPanelErroresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelErroresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(17, 189, 1));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Run >>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 111, 189));
        jButton2.setForeground(new java.awt.Color(254, 254, 254));
        jButton2.setText("Run all >>");

        jButton3.setBackground(new java.awt.Color(255, 92, 0));
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Debug");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        navegador.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 7, 7, 7));
        jScrollPane4.setViewportView(navegador);

        jButton5.setBackground(new java.awt.Color(254, 254, 254));
        jButton5.setForeground(new java.awt.Color(2, 4, 179));
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setText("Size:");

        sizeLabel.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelColummna, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(14, 14, 14)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addGap(6, 6, 6)
                        .addComponent(jPanelErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addGap(54, 54, 54))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(jPanelErrores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabelColummna)
                    .addComponent(jLabelLinea)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(sizeLabel))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        navegador.setText("");
        mat.runText(interprete.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        interprete.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    public JEditorPane getjEditorPane1() {
        return interprete;
    }

    public void setjEditorPane1(JEditorPane jEditorPane1) {
        this.interprete = jEditorPane1;
    }

    public JPanel getjPanelErrores() {
        return jPanelErrores;
    }

    public void setjPanelErrores(JPanel jPanelErrores) {
        this.jPanelErrores = jPanelErrores;
    }

    public ManejadorAreaTexto getMat() {
        return mat;
    }

    public void setMat(ManejadorAreaTexto mat) {
        this.mat = mat;
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        jLabelColummna.setText(Integer.toString(mat.getColumn(interprete.getText()))); //Funcion encargada de obtener la columna del cursor
        jLabelLinea.setText(Integer.toString(mat.getLine())); //Funcion encargada de obtener la linea del cursor
        this.modificado = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jLabelColummna.setText(Integer.toString(mat.getColumn(interprete.getText()))); //Funcion encargada de obtener la columna del cursor
        jLabelLinea.setText(Integer.toString(mat.getLine())); //Funcion encargada de obtener la linea del cursor
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    //Metodo encargado de actualizar el estado de los botones segun "Undo Manager"
    public void updateButtons() {
    }

    public boolean isModificado() {
        return modificado;
    }

    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }

    public JTextPane getNavegador() {
        return navegador;
    }

    public void setNavegador(JTextPane navegador) {
        this.navegador = navegador;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane interprete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelColummna;
    private javax.swing.JLabel jLabelLinea;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanelErrores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jTableErrores;
    private javax.swing.JTextPane navegador;
    private javax.swing.JLabel sizeLabel;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
