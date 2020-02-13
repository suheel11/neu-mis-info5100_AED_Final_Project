/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FarmerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FarmerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SubsidyWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author suhee
 */
public class ViewSubsidyRequestsJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private FarmerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;

    /**
     * Creates new form ViewSubsidyRequestsJPanel
     */
    public ViewSubsidyRequestsJPanel(JPanel userProcessContainer, UserAccount account, FarmerOrganization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.system =system;
        populateSubsidyRequestTable();
    }
    
    public void populateSubsidyRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable2.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            if(request instanceof SubsidyWorkRequest){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((SubsidyWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        workRequestJTable2 = new javax.swing.JTable();
        refreshTestJButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(194, 223, 252));

        workRequestJTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(workRequestJTable2);

        refreshTestJButton2.setText("Refresh");
        refreshTestJButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshTestJButton2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(refreshTestJButton2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(685, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTestJButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButton2ActionPerformed
        // TODO add your handling code here:
        populateSubsidyRequestTable();
    }//GEN-LAST:event_refreshTestJButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton refreshTestJButton2;
    private javax.swing.JTable workRequestJTable2;
    // End of variables declaration//GEN-END:variables
}
