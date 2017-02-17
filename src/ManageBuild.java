
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luke
 */
public class ManageBuild extends javax.swing.JFrame {

    String myPart = "";
    int motherboard;
    int CPU;
    int RAM;
    int storage;
    int GPU;
    int PSU;
    int PCCase;
    int cooler;
    int accessory;
    String name;
    String username;
    
    UserAccount currentUser;

    /**
     * Creates new form EditBuild
     */
    Build build = new Build();

    public ManageBuild() {
        initComponents();
        this.setTitle("Edit Build");     //Adds a title to the frame
        setLocationRelativeTo(null);
    }

    ManageBuild(UserAccount user, String Build) {
        username = user.getUsername();
        initComponents();
        this.setTitle("Edit Build");     //Adds a title to the frame
        setLocationRelativeTo(null);
        currentUser = user;
    }

    ManageBuild(Build build) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ManageBuild(UserAccount currentUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnProcessor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRAM = new javax.swing.JButton();
        txtboxName = new javax.swing.JTextField();
        btnMotherboard = new javax.swing.JButton();
        btnGraphics = new javax.swing.JButton();
        btnStorage = new javax.swing.JButton();
        btnCase = new javax.swing.JButton();
        btnPowerSup = new javax.swing.JButton();
        btnCooling = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnAccessories = new javax.swing.JButton();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProcessor.setText("Processor");
        btnProcessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        jLabel1.setText("Build Name:");

        btnRAM.setText("RAM");
        btnRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAMActionPerformed(evt);
            }
        });

        btnMotherboard.setText("Motherboard");
        btnMotherboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotherboardActionPerformed(evt);
            }
        });

        btnGraphics.setText("Graphics Card");
        btnGraphics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraphicsActionPerformed(evt);
            }
        });

        btnStorage.setText("Storage");
        btnStorage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStorageActionPerformed(evt);
            }
        });

        btnCase.setText("Case");
        btnCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaseActionPerformed(evt);
            }
        });

        btnPowerSup.setText("Power Supply");
        btnPowerSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowerSupActionPerformed(evt);
            }
        });

        btnCooling.setText("Cooling");
        btnCooling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoolingActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        btnAccessories.setText("Accessories");
        btnAccessories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccessoriesActionPerformed(evt);
            }
        });

        btnConfirm.setBackground(new java.awt.Color(0, 255, 0));
        btnConfirm.setText("✔");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setText("✘");

        jButton1.setText("Return to Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(btnProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnMotherboard, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGraphics, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCase, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPowerSup, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCooling, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAccessories, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnProcessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMotherboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRAM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGraphics)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStorage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPowerSup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCooling)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAccessories)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getPart() {
        System.out.println(myPart);
        return myPart;
    }

    private void btnProcessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessorActionPerformed
        myPart = "CPU";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);


    }//GEN-LAST:event_btnProcessorActionPerformed

    private void btnRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAMActionPerformed
        // TODO add your handling code here
        myPart = "RAM";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);

    }//GEN-LAST:event_btnRAMActionPerformed

    private void btnMotherboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotherboardActionPerformed
        myPart = "Motherboard";
        new SelectComponent(myPart, this).setVisible(true);
    }//GEN-LAST:event_btnMotherboardActionPerformed

    private void btnGraphicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphicsActionPerformed
        // TODO add your handling code here:
        myPart = "GPU";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnGraphicsActionPerformed

    private void btnStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStorageActionPerformed
        // TODO add your handling code here:
        myPart = "Storage";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnStorageActionPerformed

    private void btnCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaseActionPerformed
        // TODO add your handling code here:
        myPart = "Case";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnCaseActionPerformed

    private void btnPowerSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerSupActionPerformed
        // TODO add your handling code here:
        myPart = "PSU";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnPowerSupActionPerformed

    private void btnCoolingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoolingActionPerformed
        // TODO add your handling code here:
        myPart = "Cooler";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnCoolingActionPerformed

    private void btnAccessoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessoriesActionPerformed
        // TODO add your handling code here:
        myPart = "Accessory";
        SelectComponent frm = new SelectComponent(myPart, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnAccessoriesActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        getPart();
        Build build = new Build();
        build.CPU = CPU;
        build.motherboard = motherboard;
        build.RAM = RAM;
        build.GPU = GPU;
        build.PCCase = PCCase;
        build.PSU = PSU;
        build.cooler = cooler;
        build.accessory = accessory;
        build.name = name;
        build.storage = storage;
        build.user = username;

        build.SaveBuild();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println(currentUser);
        this.setVisible(false);
        if (currentUser.getType() == true) {        //User is admin
            new AdminMenu(currentUser).setVisible(true);
        } else
            new MainMenu(currentUser).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBuild().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccessories;
    private javax.swing.JButton btnCancel;
    public javax.swing.JButton btnCase;
    private javax.swing.JButton btnConfirm;
    public javax.swing.JButton btnCooling;
    public javax.swing.JButton btnGraphics;
    public javax.swing.JButton btnMotherboard;
    public javax.swing.JButton btnPowerSup;
    public javax.swing.JButton btnProcessor;
    public javax.swing.JButton btnRAM;
    public javax.swing.JButton btnStorage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtboxName;
    // End of variables declaration//GEN-END:variables
}
