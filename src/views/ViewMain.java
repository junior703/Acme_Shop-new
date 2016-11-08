/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author DRAGKOZ
 */
public class ViewMain extends javax.swing.JFrame {

    /**
     * Creates new form ViewMain
     */
    public ViewMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMarchivos = new javax.swing.JMenu();
        jMiniciarsecion = new javax.swing.JMenuItem();
        jmusuario = new javax.swing.JMenuItem();
        jMsalir = new javax.swing.JMenuItem();
        jMcatalogos = new javax.swing.JMenu();
        jMclientes = new javax.swing.JMenuItem();
        jMprovedores = new javax.swing.JMenuItem();
        jMproductos = new javax.swing.JMenuItem();
        jMoperaciones = new javax.swing.JMenu();
        jMoperacionesCompras = new javax.swing.JMenuItem();
        jMoperacionVentas = new javax.swing.JMenuItem();
        jMreportes = new javax.swing.JMenu();
        jMreportesClientes = new javax.swing.JMenuItem();
        jMreportesProductos = new javax.swing.JMenuItem();
        jMreportesProveedores = new javax.swing.JMenuItem();
        jMreportesCompras = new javax.swing.JMenuItem();
        jMreportesVentas = new javax.swing.JMenuItem();
        jMacercade = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fondo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jMarchivos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMarchivos.setForeground(new java.awt.Color(0, 0, 153));
        jMarchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ar2.png"))); // NOI18N
        jMarchivos.setText("Archivos");
        jMarchivos.setContentAreaFilled(false);
        jMarchivos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMarchivos.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jMarchivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMarchivos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMarchivos.setIconTextGap(-3);
        jMarchivos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ar3.png"))); // NOI18N
        jMarchivos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ar1.png"))); // NOI18N
        jMarchivos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMarchivos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMiniciarsecion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMiniciarsecion.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMiniciarsecion.setForeground(new java.awt.Color(0, 0, 153));
        jMiniciarsecion.setText("Iniciar Seccion");
        jMarchivos.add(jMiniciarsecion);

        jmusuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jmusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jmusuario.setForeground(new java.awt.Color(0, 0, 153));
        jmusuario.setText("Usuarios");
        jmusuario.setEnabled(false);
        jMarchivos.add(jmusuario);

        jMsalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMsalir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMsalir.setForeground(new java.awt.Color(0, 0, 153));
        jMsalir.setText("Salir");
        jMarchivos.add(jMsalir);

        jMenuBar1.add(jMarchivos);

        jMcatalogos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMcatalogos.setForeground(new java.awt.Color(0, 0, 153));
        jMcatalogos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cat2.png"))); // NOI18N
        jMcatalogos.setText("Catalogos");
        jMcatalogos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMcatalogos.setEnabled(false);
        jMcatalogos.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jMcatalogos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMcatalogos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMcatalogos.setIconTextGap(-3);
        jMcatalogos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cat3.png"))); // NOI18N
        jMcatalogos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cat1.png"))); // NOI18N
        jMcatalogos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMcatalogos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMclientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMclientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMclientes.setForeground(new java.awt.Color(0, 0, 153));
        jMclientes.setText("Clientes");
        jMclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMclientesActionPerformed(evt);
            }
        });
        jMcatalogos.add(jMclientes);

        jMprovedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMprovedores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMprovedores.setForeground(new java.awt.Color(0, 0, 153));
        jMprovedores.setText("Proveedores");
        jMcatalogos.add(jMprovedores);

        jMproductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMproductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMproductos.setForeground(new java.awt.Color(0, 0, 153));
        jMproductos.setText("Productos");
        jMcatalogos.add(jMproductos);

        jMenuBar1.add(jMcatalogos);

        jMoperaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMoperaciones.setForeground(new java.awt.Color(0, 0, 153));
        jMoperaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/op2.png"))); // NOI18N
        jMoperaciones.setText("Operaciones");
        jMoperaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMoperaciones.setDoubleBuffered(true);
        jMoperaciones.setEnabled(false);
        jMoperaciones.setFont(new java.awt.Font("Elephant", 0, 14)); // NOI18N
        jMoperaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMoperaciones.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMoperaciones.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/op3.png"))); // NOI18N
        jMoperaciones.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/op1.png"))); // NOI18N
        jMoperaciones.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMoperaciones.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMoperacionesCompras.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMoperacionesCompras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMoperacionesCompras.setForeground(new java.awt.Color(0, 0, 153));
        jMoperacionesCompras.setText("Compras");
        jMoperaciones.add(jMoperacionesCompras);

        jMoperacionVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMoperacionVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMoperacionVentas.setForeground(new java.awt.Color(0, 0, 153));
        jMoperacionVentas.setText("Ventas");
        jMoperaciones.add(jMoperacionVentas);

        jMenuBar1.add(jMoperaciones);

        jMreportes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMreportes.setForeground(new java.awt.Color(0, 0, 153));
        jMreportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rep2.png"))); // NOI18N
        jMreportes.setText("Reportes");
        jMreportes.setContentAreaFilled(false);
        jMreportes.setEnabled(false);
        jMreportes.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jMreportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMreportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMreportes.setIconTextGap(-3);
        jMreportes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rep3.png"))); // NOI18N
        jMreportes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rep1.png"))); // NOI18N
        jMreportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMreportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jMreportesClientes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMreportesClientes.setForeground(new java.awt.Color(0, 0, 153));
        jMreportesClientes.setText("Clientes");
        jMreportes.add(jMreportesClientes);

        jMreportesProductos.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMreportesProductos.setForeground(new java.awt.Color(0, 0, 153));
        jMreportesProductos.setText("Productos");
        jMreportesProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMreportesProductosActionPerformed(evt);
            }
        });
        jMreportes.add(jMreportesProductos);

        jMreportesProveedores.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMreportesProveedores.setForeground(new java.awt.Color(0, 0, 153));
        jMreportesProveedores.setText("Proveedores");
        jMreportes.add(jMreportesProveedores);

        jMreportesCompras.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMreportesCompras.setForeground(new java.awt.Color(0, 0, 153));
        jMreportesCompras.setText("Compras");
        jMreportes.add(jMreportesCompras);

        jMreportesVentas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jMreportesVentas.setForeground(new java.awt.Color(0, 0, 153));
        jMreportesVentas.setText("Ventas");
        jMreportes.add(jMreportesVentas);

        jMenuBar1.add(jMreportes);
        jMreportes.getAccessibleContext().setAccessibleParent(jMreportes);

        jMacercade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMacercade.setForeground(new java.awt.Color(0, 0, 153));
        jMacercade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ac2.png"))); // NOI18N
        jMacercade.setText("Acerca de");
        jMacercade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMacercade.setFont(new java.awt.Font("Elephant", 0, 12)); // NOI18N
        jMacercade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMacercade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMacercade.setIconTextGap(-3);
        jMacercade.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ac3.png"))); // NOI18N
        jMacercade.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ac1.png"))); // NOI18N
        jMacercade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMacercade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMacercade);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMreportesProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMreportesProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMreportesProductosActionPerformed

    private void jMclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMclientesActionPerformed

/*ponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, Short.MAX_VALUE)
        );*/
                                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    public javax.swing.JMenu jMacercade;
    public javax.swing.JMenu jMarchivos;
    public javax.swing.JMenu jMcatalogos;
    public javax.swing.JMenuItem jMclientes;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMiniciarsecion;
    public javax.swing.JMenuItem jMoperacionVentas;
    public javax.swing.JMenu jMoperaciones;
    public javax.swing.JMenuItem jMoperacionesCompras;
    public javax.swing.JMenuItem jMproductos;
    public javax.swing.JMenuItem jMprovedores;
    public javax.swing.JMenu jMreportes;
    public javax.swing.JMenuItem jMreportesClientes;
    public javax.swing.JMenuItem jMreportesCompras;
    public javax.swing.JMenuItem jMreportesProductos;
    public javax.swing.JMenuItem jMreportesProveedores;
    public javax.swing.JMenuItem jMreportesVentas;
    public javax.swing.JMenuItem jMsalir;
    public javax.swing.JMenuItem jmusuario;
    // End of variables declaration//GEN-END:variables
}
