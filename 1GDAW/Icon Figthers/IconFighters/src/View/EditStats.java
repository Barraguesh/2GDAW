/**
 * @author Barraguesh
 * @version %I% %G%
 * @since v0.2 alpha
 */
package View;

import Classes.Icon;
import IconFighters.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditStats extends javax.swing.JFrame {
    String name = null;
    boolean addmore = true;
    /**
     * Creates new form WindowEditStats
     */
    public EditStats() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IconSelection = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AttackText = new javax.swing.JTextField();
        DefenseText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LifePointsText = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        Switch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        IconSelection.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        IconSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a figther", "Hazard", "XML", "Folder" }));
        IconSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IconSelectionActionPerformed(evt);
            }
        });

        jLabel1.setText("Attack");

        jLabel2.setText("Defense");

        AttackText.setEnabled(false);

        DefenseText.setEnabled(false);

        jLabel3.setText("Life points");

        LifePointsText.setEnabled(false);

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        Switch.setText("Switch to villains");
        Switch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwitchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(IconSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AttackText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(DefenseText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(LifePointsText, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(OK))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Switch)
                        .addGap(93, 93, 93)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(Switch)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AttackText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IconSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DefenseText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LifePointsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OK)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IconSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IconSelectionActionPerformed
        try {
            switch (IconSelection.getSelectedIndex()){
                case 1:
                    name = "Hazard";
                    Icon h = Controller.GetStats(name);
                    AttackText.setText(String.valueOf(h.getAttack()));
                    DefenseText.setText(String.valueOf(h.getDefense()));
                    LifePointsText.setText(String.valueOf(h.getLifePoints()));
                break;
                case 2:
                    name = "XML";
                    Icon x = Controller.GetStats(name);
                    AttackText.setText(String.valueOf(x.getAttack()));
                    DefenseText.setText(String.valueOf(x.getDefense()));
                    LifePointsText.setText(String.valueOf(x.getLifePoints()));
                break;
                case 3:
                    //Other stats
                break;
            }
            AttackText.setEnabled(true);
            DefenseText.setEnabled(true);
            LifePointsText.setEnabled(true);
        } catch (Exception ex) {
            System.out.println("Exception in Icon stats selection " + ex.getMessage());
        }
    }//GEN-LAST:event_IconSelectionActionPerformed

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed

        try {
            if(AttackText.getText().matches("[0-9]{1,3}") && DefenseText.getText().matches("[0-9]{1,3}") && LifePointsText.getText().matches("[0-9]{1,3}")){
                Controller.UpdateStatsDB(name, Integer.parseInt(AttackText.getText()), Integer.parseInt(DefenseText.getText()), Integer.parseInt(LifePointsText.getText()));
            }else{
                JOptionPane.showMessageDialog(this, "Only up to 3 numbers allowed in each parameter");
                return;
            }
        } catch (Exception ex) {
            System.out.println("Exception in loading the stats " + ex.getMessage());
        }
        if(JOptionPane.showConfirmDialog(this, "New stats loaded. Do you want to edit more?") == 1){
            dispose();
        }else{
            IconSelectionActionPerformed(evt);
        }
    }//GEN-LAST:event_OKActionPerformed

    private void SwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SwitchActionPerformed
        
    }//GEN-LAST:event_SwitchActionPerformed

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
            java.util.logging.Logger.getLogger(EditStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStats().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AttackText;
    private javax.swing.JTextField DefenseText;
    private javax.swing.JComboBox<String> IconSelection;
    private javax.swing.JTextField LifePointsText;
    private javax.swing.JButton OK;
    private javax.swing.JButton Switch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}