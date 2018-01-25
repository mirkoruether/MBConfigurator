package de.mirkoruether.mbconfigurator;

import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import javax.swing.JOptionPane;

public class TestJson extends javax.swing.JFrame
{
    private static final long serialVersionUID = 1L;

    public TestJson()
    {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        jsonTxt = new javax.swing.JTextArea();
        classTxt = new javax.swing.JTextField();
        tryBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jsonTxt.setColumns(20);
        jsonTxt.setRows(5);
        jScrollPane1.setViewportView(jsonTxt);

        classTxt.setText("VehicleComponent");

        tryBtn.setText("Ausprobieren!");
        tryBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tryBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(classTxt)
                    .addComponent(tryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tryBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tryBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tryBtnActionPerformed
    {//GEN-HEADEREND:event_tryBtnActionPerformed
        try
        {
            Class<?> clazz = Class.forName("de.mirkoruether.mbconfigurator.pojo." + classTxt.getText());
            Object o = MBConfigurator.fromJson(jsonTxt.getText(), clazz);
            String out = MBConfigurator.GSON.toJson(o);
            System.out.println(out);
            JOptionPane.showMessageDialog(null, out, "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }//GEN-LAST:event_tryBtnActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new TestJson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classTxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jsonTxt;
    private javax.swing.JButton tryBtn;
    // End of variables declaration//GEN-END:variables
}
