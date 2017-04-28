
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Luke
 */
public class EditBuild extends javax.swing.JFrame {

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

    ArrayList<Integer> Parts = new ArrayList<Integer>();

    UserAccount currentUser;
    Build currentBuild;

    /**
     * Creates new form EditBuild
     */
    Build build = new Build();

    public EditBuild() {
        initComponents();
        this.setTitle("Edit Build");     //Adds a title to the frame
        setLocationRelativeTo(null);
    }

    //Contructor for CreateBuild - where a build doesn't need to be passed...
    //... as the user is creating a new one
    EditBuild(UserAccount user) {
        initComponents();
        this.setTitle("Edit Build");     //Adds a title to the frame - need this to change bassed on option
        setLocationRelativeTo(null);
        currentUser = user;
    }

    //Contructor for EditBuild & Viewbuild - where a build needs to be passed...
    //... as the user is referencing an existing one
    EditBuild(UserAccount user, Build myBuild) {
        Connection con = DatabaseConnection.establishConnection();
        initComponents();
        this.setTitle("Edit Build");     //Adds a title to the frame
        setLocationRelativeTo(null);
        currentUser = user;
        currentBuild = myBuild;

        currentBuild.loadBuild(currentUser, currentBuild.getName());
        System.out.println("user" + currentBuild.getUser());

        txtboxName.setText(currentBuild.getName());
        txtboxName.setEditable(false);
        btnProcessor.setText(getMakeModel(currentBuild.getCPU(), con));
        btnMotherboard.setText(getMakeModel(currentBuild.getMotherboard(), con));
        btnRAM.setText(getMakeModel(currentBuild.getRAM(), con));
        btnGraphics.setText(getMakeModel(currentBuild.getGPU(), con));
        btnStorage.setText(getMakeModel(currentBuild.getStorage(), con));
        btnCase.setText(getMakeModel(currentBuild.getCase(), con));
        btnPowerSup.setText(getMakeModel(currentBuild.getPSU(), con));
        btnCooling.setText(getMakeModel(currentBuild.getCooler(), con));
        btnAccessories.setText(getMakeModel(currentBuild.getAccessory(), con));

    }

    private String getMakeModel(int ID, Connection myCon) {
        //Connection con = DatabaseConnection.establishConnection();
        String make = null; //Intialise variables
        String model = null;
        try {
            Statement stmt = (Statement) myCon.createStatement();
            String query = ("SELECT * FROM Part Where PartID ='" + ID + "'");       //Selet part from database
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                make = rs.getString("Make");            //Get data
                model = rs.getString("Model");

            }
            String makeModel = (make + " " + model);

            return makeModel;   //Return string to be displayed on form.
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
        return null;
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
        lblBuildName = new javax.swing.JLabel();
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
        lblReturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnProcessor.setText("Processor");
        btnProcessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessorActionPerformed(evt);
            }
        });

        lblBuildName.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        lblBuildName.setText("Build Name:");

        btnRAM.setText("RAM");
        btnRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRAMActionPerformed(evt);
            }
        });

        txtboxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxNameActionPerformed(evt);
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
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblReturn.setText("Return to Menu");
        lblReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblReturnActionPerformed(evt);
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
                        .addComponent(lblReturn)
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
                                .addComponent(lblBuildName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(208, 208, 208))))
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
                            .addComponent(lblBuildName)
                            .addComponent(txtboxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
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
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReturn)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getPart() {
        System.out.println(myPart);
        return myPart;
    }

    private void btnProcessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessorActionPerformed
        myPart = "CPU";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);


    }//GEN-LAST:event_btnProcessorActionPerformed

    private void btnRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAMActionPerformed
        // TODO add your handling code here
        myPart = "RAM";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);

    }//GEN-LAST:event_btnRAMActionPerformed

    private void btnMotherboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotherboardActionPerformed
        myPart = "Motherboard";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnMotherboardActionPerformed

    private void btnGraphicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphicsActionPerformed
        // TODO add your handling code here:
        myPart = "GPU";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnGraphicsActionPerformed

    private void btnStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStorageActionPerformed
        // TODO add your handling code here:
        myPart = "Storage";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnStorageActionPerformed

    private void btnCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaseActionPerformed
        // TODO add your handling code here:
        myPart = "Case";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnCaseActionPerformed

    private void btnPowerSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerSupActionPerformed
        // TODO add your handling code here:
        myPart = "PSU";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnPowerSupActionPerformed

    private void btnCoolingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoolingActionPerformed
        // TODO add your handling code here:
        myPart = "Cooler";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnCoolingActionPerformed

    private void btnAccessoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessoriesActionPerformed
        // TODO add your handling code here:
        myPart = "Accessory";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnAccessoriesActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String buildName = txtboxName.getText();

        if (buildName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please complete the build name field.", "Please complete fields", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ArrayList<Integer> IDs = new ArrayList<Integer>();
            IDs.add(motherboard);
            IDs.add(CPU);
            IDs.add(RAM);
            IDs.add(storage);
            IDs.add(GPU);
            IDs.add(PSU);
            IDs.add(PCCase);
            IDs.add(cooler);
            IDs.add(accessory);
            Issue check = new Issue();
            boolean issues = false;

            Connection con = DatabaseConnection.establishConnection();
            for (int i = 0; i < IDs.size(); i++) {
                for (int j = i + 1; j < IDs.size(); j++) {
                    boolean result = check.compatbilityIssue(IDs.get(i), IDs.get(j), con);
                    if (result) {
                        issues = true;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "We will now check your components are compatable. Please wait..", "Please wait.", JOptionPane.INFORMATION_MESSAGE);
            if (issues) {
                JOptionPane.showMessageDialog(null, "WARNING. Issues have been deceted between the selected parts. Please chose different parts..", "WARNING", JOptionPane.INFORMATION_MESSAGE);
            } else {
                saveBuild();
                //this.setVisible(false);
                //new EditBuilds(currentUser).setVisible(true);       //Resets components when build is saved
            }
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void saveBuild() {
//        getPart();
//        Build myBuild = new Build();
//        myBuild.CPU = CPU;
//        myBuild.motherboard = motherboard;
//        myBuild.RAM = RAM;
//        myBuild.GPU = GPU;
//        myBuild.PCCase = PCCase;
//        myBuild.PSU = PSU;
//        myBuild.cooler = cooler;
//        myBuild.accessory = accessory;
//        myBuild.name = txtboxName.getText();
//        myBuild.storage = storage;
        //myBuild.user = username;

        //BUG IS HERE
        
        currentBuild.setCPU(CPU);
        currentBuild.setMotherboard(motherboard);
        currentBuild.setRAM(currentBuild.getRAM());
        currentBuild.setGPU(currentBuild.getGPU());
        currentBuild.setCase(currentBuild.getCase());
        currentBuild.setPSU(currentBuild.getPSU());
        currentBuild.setCooler(currentBuild.getCooler());
        currentBuild.setAccessory(currentBuild.getAccessory());
        currentBuild.setName(currentBuild.getName());
        currentBuild.setStorage(currentBuild.getStorage());
        currentBuild.setUser(currentBuild.getUser());

        System.out.println("motherboard" + currentBuild.getMotherboard());
        System.out.println("name" + currentBuild.getName());
        System.out.println("user" + currentBuild.getUser());

        currentBuild.editBuild();
    }

    private void returnToMenu() {
        this.setVisible(false);
        if (currentUser.getType() == true) {        //User is admin
            new AdminMenu(currentUser).setVisible(true);
        } else {
            new MainMenu(currentUser).setVisible(true);
        }
    }

    private void lblReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblReturnActionPerformed
        this.setVisible(false);
        //returnToMenu();
    }//GEN-LAST:event_lblReturnActionPerformed

    public void refreshParts() {

        Parts.clear();
        if (CPU != 0) {
            Parts.add(CPU);
        }
        if (motherboard != 0) {
            Parts.add(motherboard);
        }
        if (RAM != 0) {
            Parts.add(RAM);
        }
        if (storage != 0) {
            Parts.add(storage);
        }
        if (GPU != 0) {
            Parts.add(GPU);
        }
        if (PSU != 0) {
            Parts.add(PSU);
        }
        if (PCCase != 0) {
            Parts.add(PCCase);
        }
        if (cooler != 0) {
            Parts.add(cooler);
        }
        if (accessory != 0) {
            Parts.add(accessory);
        }
        System.out.println(Parts);

    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        String message = "Do you wish to cancel without saving?";
        int answer = JOptionPane.showConfirmDialog(this, message);
        if (answer == JOptionPane.YES_OPTION) {
            // User clicked YES.
            returnToMenu();
        } else if (answer == JOptionPane.NO_OPTION) {
            // User clicked NO.
            // Nothing happens
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtboxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtboxNameActionPerformed

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
            java.util.logging.Logger.getLogger(CreateBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateBuild.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditBuild().setVisible(true);
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
    private javax.swing.JLabel lblBuildName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JButton lblReturn;
    private javax.swing.JTextField txtboxName;
    // End of variables declaration//GEN-END:variables
}
