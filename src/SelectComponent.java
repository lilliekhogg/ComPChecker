
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
    CreateBuild createForm;
    EditBuild editForm;
    ArrayList<Integer> Parts = new ArrayList<Integer>();
    CreateBuild form;

    /**
     *
     * @param type type of form this form was opened from.
     * @param create
     * @param edit
     */
    public SelectComponent(String type, CreateBuild create, EditBuild edit) {
        if (create != null) {
            createForm = create;
            Parts = createForm.Parts;
        } else if (edit != null) {
            editForm = edit;
            Parts = editForm.Parts;
        }
        form = create;
        partType = type;
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
     * Returns the ID of the selected row,
     *
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

    private void createConfirm() {
        //temp save part, change button label to part text
        int ID = getID();
        System.out.println(ID);
        if (partType == "CPU") {
            createForm.CPU = ID;
            createForm.btnProcessor.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "Motherboard") {
            createForm.motherboard = ID;
            createForm.btnMotherboard.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "RAM") {
            createForm.RAM = ID;
            createForm.btnRAM.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "GPU") {
            createForm.GPU = ID;
            createForm.btnGraphics.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "Storage") {
            createForm.storage = ID;
            createForm.btnStorage.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "Case") {
            createForm.PCCase = ID;
            createForm.btnCase.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "PSU") {
            createForm.PSU = ID;
            createForm.btnPowerSup.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "Cooler") {
            createForm.cooler = ID;
            createForm.btnCooling.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        } else if (partType == "Accessory") {
            createForm.accessory = ID;
            createForm.btnAccessories.setText(thismake + " " + thismodel);
            createForm.refreshParts();
        }
        this.setVisible(false);
    }

    private void editConfirm() {
        //temp save part, change button label to part text
        int ID = getID();
        System.out.println(ID);
        if (partType == "CPU") {
            editForm.CPU = ID;
            editForm.btnProcessor.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "Motherboard") {
            editForm.motherboard = ID;
            editForm.btnMotherboard.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "RAM") {
            editForm.RAM = ID;
            editForm.btnRAM.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "GPU") {
            editForm.GPU = ID;
            editForm.btnGraphics.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "Storage") {
            editForm.storage = ID;
            editForm.btnStorage.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "Case") {
            editForm.PCCase = ID;
            editForm.btnCase.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "PSU") {
            editForm.PSU = ID;
            editForm.btnPowerSup.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "Cooler") {
            editForm.cooler = ID;
            editForm.btnCooling.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        } else if (partType == "Accessory") {
            editForm.accessory = ID;
            editForm.btnAccessories.setText(thismake + " " + thismodel);
            editForm.refreshParts();
        }
        this.setVisible(false);
    }


    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        if (createForm != null) {
            createConfirm();
        } else if (editForm != null) {
            editConfirm();
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
