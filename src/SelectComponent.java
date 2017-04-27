
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tom
 */
public class SelectComponent extends javax.swing.JDialog {

    /**
     * Creates new form SelectComponent
     */
    int cpuID;
    int motherboardID;
    String thismake;
    String thismodel;
    String partType;
    CreateBuild form;
    ArrayList<Integer> Parts = new ArrayList<Integer>();

    /**
     *
     * @param parent parent form
     * @param modal modal
     */
    public SelectComponent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Select Component");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
    }

    /**
     *
     * @param type type of form this form was opened from.
     * @param form1 parent form
     */
    public SelectComponent(String type, CreateBuild form1) {
        Parts = form1.Parts;
        partType = type;
        form = form1;
        initComponents();
        this.setTitle("Select Component");     //Adds a title to the frame
        setLocationRelativeTo(null);    //Centers the frame in the middle of ths screen
        TableColumn col = new TableColumn();
        ArrayList<String> columns = new ArrayList<>();
        columns.add("Make");
        columns.add("Model");
        columns.add("Price");
        if (type == "CPU") {
            columns.add("Speed");
            columns.add("Cores");
            columns.add("Graphics");
        } else if (type == "Motherboard") {
            columns.add("Socket");
            columns.add("Form Factor");
            columns.add("RAM Slots");
            columns.add("Max RAM");
        } else if (type == "RAM") {
            columns.add("Speed");
            columns.add("Size");
            columns.add("Sticks");
        } else if (type == "GPU") {

            columns.add("Series");
            columns.add("Chipset");
            columns.add("Memory");
            columns.add("CoreClock");

        } else if (type == "Storage") {
            columns.add("Series");
            columns.add("HHD");
            columns.add("Speed");
            columns.add("Capacity");

        } else if (type == "PSU") {
            columns.add("Series");
            columns.add("Modular");

        } else if (type == "Cooler") {
            columns.add("Min RPM");
            columns.add("Max RPM");

        } else if (type == "Accessory") {
            columns.add("Description");

        }

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableColumn col1 = new TableColumn(model.getColumnCount());
        for (String temp : columns) { //Adds columns to table.
            col.setHeaderValue(temp);
            jTable.addColumn(col);
            model.addColumn(temp);
        }

        Connection con = DatabaseConnection.establishConnection();
        boolean issue = false;
        Issue compatibility = new Issue();
        try {
            Statement stmt = (Statement) con.createStatement();
            String query;
            String make;
            String mdl;
            double price;
            if (type == "CPU") {
                query = ("Select P.PartID, P.Make, P.Model, P.Price, Speed, Cores, Graphics FROM CPU JOIN Part AS P on CPU.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    double speed = rs.getDouble("Speed");
                    int cores = rs.getInt("Cores");
                    boolean graphics = rs.getBoolean("Graphics");
                    int ID = rs.getInt("PartID");

                    for (int i = 0; i < Parts.size(); i++) {
                        issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }

                    model.addRow(new Object[]{make, mdl, price, speed, cores, graphics});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);

                    }
                }
                /**
                 * model.addRow(new Object[]{make, mdl, price, speed, cores,
                 * graphics});
                 *
                 */
            } else if (type == "Motherboard") {
                query = ("Select P.PartID, P.Make, P.Model, P.Price, Socket, Form_Factor, RAM_Slots,MAX_RAM FROM Motherboard JOIN Part AS P on Motherboard.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    String socket = rs.getString("Socket");
                    String size = rs.getString("Form_Factor");
                    int slots = rs.getInt("RAM_Slots");
                    int maxRAM = rs.getInt("MAX_RAM");
                    int ID = rs.getInt("PartID");
                    for (int i = 0; i < Parts.size(); i++) {
                        issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, socket, size, slots, maxRAM});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }
            } else if (type == "RAM") {

                query = ("Select P.PartID, P.Make, P.Model, P.Price, Speed, SizeGB, Sticks FROM RAM JOIN Part AS P on RAM.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    String speed = rs.getString("Speed");
                    int size = rs.getInt("SizeGB");
                    int sticks = rs.getInt("Sticks");
                    int ID = rs.getInt("PartID");
                    for (int i = 0; i < Parts.size(); i++) {
                        issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, speed, size, sticks});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }
            } else if (type == "GPU") {

                query = ("Select P.PartID, P.Make, P.Model, P.Price, Series, Chipset, Memory, CoreClock FROM GPU JOIN Part AS P on GPU.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    String series = rs.getString("Series");
                    String chipset = rs.getString("Chipset");
                    int memory = rs.getInt("Memory");
                    double clock = rs.getFloat("CoreClock");
                    int ID = rs.getInt("PartID");
                    for (int i = 0; i < Parts.size(); i++) {
                       issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, series, chipset, memory, clock});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }
            } else if (type == "Storage") {
                query = ("Select P.PartID, P.Make, P.Model, P.Price, Series, HHD, Speed, CapacityGB FROM Storage JOIN Part AS P on Storage.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    String series = rs.getString("Series");
                    boolean HHD = rs.getBoolean("HHD");
                    int speed = rs.getInt("Speed");
                    int capacity = rs.getInt("CapacityGB");
                    int ID = rs.getInt("PartID");
                    String storageType;
                    if (HHD == true) {
                        storageType = "HDD";

                    } else {
                        storageType = "SSD";
                    }
                    for (int i = 0; i < Parts.size(); i++) {
                        issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, series, storageType, speed, capacity});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }

            } else if (type == "Case") {

                query = ("Select P.PartID, P.Make, P.Model, P.Price, Height, Width, CDepth, Colour, Motherboard FROM PCCase JOIN Part AS P on PCCase.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    int height = rs.getInt("Height");
                    int width = rs.getInt("Width");
                    int CDepth = rs.getInt("CDepth");
                    String colour = rs.getString("Colour");
                    String motherboard = rs.getString("Motherboard");
                    int ID = rs.getInt("PartID");
                    for (int i = 0; i < Parts.size(); i++) {
                       issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, height, width, CDepth, colour, motherboard});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }

            } else if (type == "PSU") {
                query = ("Select P.PartID, P.Make, P.Model, P.Price, Wattage, Modular FROM PSU JOIN Part AS P on PSU.ID=P.PartID");
                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    int wattage = rs.getInt("Wattage");
                    boolean modular = rs.getBoolean("Modular");
                    int ID = rs.getInt("PartID");
                    String modularity;

                    if (modular == true) {

                        modularity = "Yes";
                    } else {
                        modularity = "No";

                    }
                    for (int i = 0; i < Parts.size(); i++) {
                        issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, wattage, modularity});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }

            } else if (type == "Cooler") {

                query = ("Select P.PartID, P.Make, P.Model, P.Price, MinRPM, MaxRPM FROM Cooler JOIN Part AS P on Cooler.ID=P.PartID");
                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    int MinRPM = rs.getInt("MinRPM");
                    int MaxRPM = rs.getInt("MaxRPM");
                    int ID = rs.getInt("PartID");
                    for (int i = 0; i < Parts.size(); i++) {
                        issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, MinRPM, MaxRPM});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }
            } else if (type == "Accessory") {
                query = ("Select P.PartID, P.Make, P.Model, P.Price, Description FROM Accessory JOIN Part AS P on Accessory.ID=P.PartID");

                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();

                while (rs.next()) {
                    make = rs.getString("Make");
                    mdl = rs.getString("Model");
                    price = rs.getDouble("Price");
                    String description = rs.getString("Description");
                    int ID = rs.getInt("PartID");
                    for (int i = 0; i < Parts.size(); i++) {
                      issue = compatibility.compatbilityIssue(ID, Parts.get(i), con);
                    }
                    model.addRow(new Object[]{make, mdl, price, description});
                    if (issue) {
                        model.removeRow((model.getRowCount()) - 1);
                    }
                }

            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 
        }
    }

    SelectComponent(String myPart, EditBuild aThis) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTableMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(jTable);

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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(390, 390, 390))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *Returns the ID of the selected row,
     * @return ID returns the ID of the selected row
     */
    public int getID() {
        int column1 = 0;
        int column2 = 1;
        int partID = 0;
        int row = jTable.getSelectedRow();
        String make = jTable.getModel().getValueAt(row, column1).toString();
        String model = jTable.getModel().getValueAt(row, column2).toString();
        Connection con = DatabaseConnection.establishConnection();

        try {
            Statement stmt = (Statement) con.createStatement();
            String query = "SELECT PartID, Model, Make FROM Part WHERE Model ='" + model + "' && Make = '" + make + "'";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                thismake = rs.getString("Make");
                thismodel = rs.getString("Model");
                partID = rs.getInt("PartID");
            }
            return partID;
        } catch (SQLException err) {
            System.out.println(err.getMessage());   //Prints out SQL error 

        }
        return 0;
    }

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMouseClicked

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        //temp save part, change button label to part text
        int ID = getID();
        System.out.println(ID);
        if (partType == "CPU") {
            form.CPU = ID;
            form.btnProcessor.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "Motherboard") {
            form.motherboard = ID;
            form.btnMotherboard.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "RAM") {
            form.RAM = ID;
            form.btnRAM.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "GPU") {
            form.GPU = ID;
            form.btnGraphics.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "Storage") {
            form.storage = ID;
            form.btnStorage.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "Case") {
            form.PCCase = ID;
            form.btnCase.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "PSU") {
            form.PSU = ID;
            form.btnPowerSup.setText(thismake + " " + thismodel);
            form.refreshParts();

        } else if (partType == "Cooler") {
            form.cooler = ID;
            form.btnCooling.setText(thismake + " " + thismodel);
            form.refreshParts();
        } else if (partType == "Accessory") {
            form.accessory = ID;
            form.btnAccessories.setText(thismake + " " + thismodel);
            form.refreshParts();

        }

        this.setVisible(false);

    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(SelectComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectComponent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SelectComponent dialog = new SelectComponent(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
