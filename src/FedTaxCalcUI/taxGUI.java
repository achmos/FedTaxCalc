package FedTaxCalcUI;

import FedTaxCalc.Exceptions.TaxCalculatorException;
import FedTaxCalc.Exceptions.TaxCalculatorYearException;
import FedTaxCalc.Exceptions.TaxDataLoadFailException;
import FedTaxCalc.FedTaxCalc;
import FedTaxCalc.FilingType;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramin
 */
public class taxGUI extends javax.swing.JFrame {
    private FedTaxCalc taxCalculator;
    
    /**
     * Creates new form taxGUI
     */
    public taxGUI() {
        taxCalculator = new FedTaxCalc();
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

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tax Calculator");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(taxCalculator.getYears().toArray(new Integer [0])));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearSelectActionPerformed(evt);
            }
        });

        jLabel1.setLabelFor(jComboBox1);
        jLabel1.setText("Year:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married filing jointly", "Married filing separately", "Head of household" }));
        jComboBox2.setSelectedIndex(-1);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filingSelectActionPerformed(evt);
            }
        });

        jLabel2.setLabelFor(jComboBox2);
        jLabel2.setText("Filing Status:");

        jLabel3.setLabelFor(jFormattedTextField1);
        jLabel3.setText("Taxable Income");

        jLabel4.setLabelFor(jFormattedTextField2);
        jLabel4.setText("Tax Amount:");

        jButton1.setText("Calculate Tax");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateTaxActionPerformed(evt);
            }
        });

        jFormattedTextField1.setColumns(20);
        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField1.setToolTipText("");

        jFormattedTextField2.setEditable(false);
        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBox2, 0, 148, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextField2)
                                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void yearSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearSelectActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        Integer year = (Integer)cb.getSelectedItem();
        
        try {
            taxCalculator.setTaxYear(year);
        } catch (TaxCalculatorYearException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Year Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_yearSelectActionPerformed

    private void filingSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filingSelectActionPerformed
        JComboBox cb = (JComboBox)evt.getSource();
        Integer index = (Integer)cb.getSelectedIndex();
        
        FilingType [] types = FilingType.values();
        taxCalculator.setFilingStatus(types[index]);
    }//GEN-LAST:event_filingSelectActionPerformed

    private void calculateTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateTaxActionPerformed
        String strAmount = jFormattedTextField1.getText();
        if (strAmount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an income amount.", "No Amount",JOptionPane.WARNING_MESSAGE);   
            return;
        }
        
        Double amount = ((Number)jFormattedTextField1.getValue()).doubleValue();
        
        try {
            double result = taxCalculator.calcTaxes(amount);
            jFormattedTextField2.setValue(new Double(result));
        } catch (TaxCalculatorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning! Incorrect setting!",JOptionPane.WARNING_MESSAGE);   
        } catch (TaxDataLoadFailException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
            //send window event to shutdown the application.
            WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
        }
    }//GEN-LAST:event_calculateTaxActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(taxGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                taxGUI tg;
                try {
                    tg = new taxGUI();
                    tg.setVisible(true);
                } catch (TaxDataLoadFailException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
