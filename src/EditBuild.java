
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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

    /**
     *
     */
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
        

        currentBuild.loadBuild(currentUser, currentBuild);
        
        motherboard = currentBuild.getMotherboard();
        CPU = currentBuild.getCPU();
        RAM = currentBuild.getRAM();
        storage = currentBuild.getStorage();
        GPU = currentBuild.getGPU();
        PSU = currentBuild.getPSU();
        PCCase = currentBuild.getCase();
        cooler = currentBuild.getCooler();
        accessory = currentBuild.getAccessory();
        name = currentBuild.getName();
        username = currentBuild.getUser();

        txtboxName.setText(name);
        txtboxName.setEditable(false);
        btnProcessor.setText(getMakeModel(CPU, con));
        btnMotherboard.setText(getMakeModel(motherboard, con));
        btnRAM.setText(getMakeModel(RAM, con));
        btnGraphics.setText(getMakeModel(GPU, con));
        btnStorage.setText(getMakeModel(storage, con));
        btnCase.setText(getMakeModel(PCCase, con));
        btnPowerSup.setText(getMakeModel(PSU, con));
        btnCooling.setText(getMakeModel(cooler, con));
        btnAccessories.setText(getMakeModel(accessory, con));

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblReturn)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Returning part selected to the user
     * @return myPart
     */
    public String getPart() {
        System.out.println(myPart);
        return myPart;
    }

    private void btnProcessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessorActionPerformed
        //opening CPU form of components
        myPart = "CPU";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);


    }//GEN-LAST:event_btnProcessorActionPerformed

    private void btnRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRAMActionPerformed
        // opening RAM form of components
        myPart = "RAM";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);

    }//GEN-LAST:event_btnRAMActionPerformed

    private void btnMotherboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotherboardActionPerformed
        //opening Motherboard form of components
        myPart = "Motherboard";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnMotherboardActionPerformed

    private void btnGraphicsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraphicsActionPerformed
        // opening GPU form of components
        myPart = "GPU";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnGraphicsActionPerformed

    private void btnStorageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStorageActionPerformed
        // opening Storage form of components
        myPart = "Storage";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnStorageActionPerformed

    private void btnCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaseActionPerformed
        // opening Case form of components
        myPart = "Case";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnCaseActionPerformed

    private void btnPowerSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowerSupActionPerformed
        // opening PSU form of components
        myPart = "PSU";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnPowerSupActionPerformed

    private void btnCoolingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoolingActionPerformed
        // opening Cooler form of components
        myPart = "Cooler";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnCoolingActionPerformed

    private void btnAccessoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessoriesActionPerformed
        // opening Accessory form of components
        myPart = "Accessory";
        SelectComponent frm = new SelectComponent(myPart, null, this); //
        frm.setVisible(true);
    }//GEN-LAST:event_btnAccessoriesActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        //selecting components and adding them to build array in database
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
            
            //checking the compatibility of two components in database
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
    //saving the Build into the databse
    private void saveBuild() {
        currentBuild.setCPU(CPU);
        currentBuild.setMotherboard(motherboard);
        currentBuild.setRAM(RAM);
        currentBuild.setGPU(GPU);
        currentBuild.setCase(PCCase);
        currentBuild.setPSU(PSU);
        currentBuild.setCooler(cooler);
        currentBuild.setAccessory(accessory);
        currentBuild.setName(name);
        currentBuild.setStorage(storage);
        currentBuild.setUser(username);

        currentBuild.editBuild();
    }
    //user return to menu
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

    /**
     *Setting parts back to 0 
     */
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
        //System.out.println(Parts);

    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //cancelling edit build
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
