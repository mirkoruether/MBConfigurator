package de.mirkoruether.mbconfigurator.gui;

import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import de.mirkoruether.util.LinqList;
import de.mirkoruether.util.gui.CoolComboBoxModel;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class Main extends javax.swing.JFrame
{
    public static final String MARKET = "de_DE";

    private static final long serialVersionUID = 1L;

    private final DefaultComboBoxModel<String> classComboModel;
    private final CoolComboBoxModel<VehicleBody> bodyComboModel;
    private final CoolComboBoxModel<Model> modelComboModel;

    private final LinqList<VehicleClass> classes;

    public Main()
    {
        initComponents();
        classes = new LinqList<>(MBConfigurator.getVehicleClasses(MARKET, null, null));
        LinqList<String> classNames = new LinqList<String>();
        for(VehicleClass cl : classes)
        {
            String className = cl == null ? null : cl.getClassName();
            if(cl == null)
                continue;
            if(!classNames.contains(className))
            {
                classNames.add(className);
            }
        }
        classNames.sort(null);

        classComboModel = new DefaultComboBoxModel<String>(classNames.toArray(String.class));
        bodyComboModel = new CoolComboBoxModel<>((b) -> b.getBodyName(), true);
        modelComboModel = new CoolComboBoxModel<>((m) -> m.getName(), true);

        classCombo.setModel(classComboModel);
        bodyCombo.setModel(bodyComboModel);
        modelCombo.setModel(modelComboModel);

        classCombo.setSelectedItem(null);

        pack();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        classCombo = new javax.swing.JComboBox<>();
        bodyCombo = new javax.swing.JComboBox<>();
        modelCombo = new javax.swing.JComboBox<>();
        newConfigurationBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        saveAsBtn = new javax.swing.JButton();
        openBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        imageLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        searchTxt = new javax.swing.JTextField();
        clearSearchBtn = new javax.swing.JButton();
        tableScrollPane = new javax.swing.JScrollPane();
        componentsTable = new javax.swing.JTable();
        componentImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        classCombo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                classComboActionPerformed(evt);
            }
        });

        bodyCombo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bodyComboActionPerformed(evt);
            }
        });

        newConfigurationBtn.setText("Neue Konfiguration starten");

        saveBtn.setText("Speichern");

        saveAsBtn.setText("Speichern unter");

        openBtn.setText("Öffnen");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setText("Bild");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        clearSearchBtn.setText("X");

        componentsTable.setAutoCreateRowSorter(true);
        componentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "?", "Code", "Name"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                true, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tableScrollPane.setViewportView(componentsTable);

        componentImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        componentImageLabel.setText("Bild");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveAsBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bodyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modelCombo, 0, 345, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newConfigurationBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearSearchBtn))
                            .addComponent(componentImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator4))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bodyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newConfigurationBtn)
                        .addComponent(saveBtn)
                        .addComponent(saveAsBtn)
                        .addComponent(openBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearSearchBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componentImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_classComboActionPerformed
    {//GEN-HEADEREND:event_classComboActionPerformed
        List<String> selectedClassIds = getSelectedClassIds();
        if(selectedClassIds.isEmpty())
        {
            bodyComboModel.removeAllElements();
        }
        else
        {
            LinqList<VehicleBody> bodies = new LinqList<>();
            for(String id : selectedClassIds)
            {
                bodies.addAll(MBConfigurator.getVehicleBodies(MARKET, null, id));
            }
            bodies.sort((b1, b2) -> b1.getBodyName().compareTo(b2.getBodyName()));
            bodyComboModel.setAll(bodies);
        }
    }//GEN-LAST:event_classComboActionPerformed

    private void bodyComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bodyComboActionPerformed
    {//GEN-HEADEREND:event_bodyComboActionPerformed
        List<String> selectedClassIds = getSelectedClassIds();

        VehicleBody selectedBody = bodyComboModel.getSelected();
        String selectedBodyId = selectedBody == null ? null : selectedBody.getBodyId();

        if(selectedClassIds.isEmpty()
           || selectedBodyId == null || selectedBodyId.trim().isEmpty())
        {
            modelComboModel.removeAllElements();
        }
        else
        {
            LinqList<Model> models = new LinqList<>();
            for(String id : selectedClassIds)
            {
                models.addAll(MBConfigurator.getModels(MARKET, null, id, selectedBodyId));
            }
            models.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
            modelComboModel.setAll(models);
        }
    }//GEN-LAST:event_bodyComboActionPerformed

    private List<String> getSelectedClassIds()
    {
        Object selectedName = classComboModel.getSelectedItem();
        if(selectedName == null)
        {
            return new LinqList<>();
        }

        LinqList<String> ids = new LinqList<>();
        for(VehicleClass cl : classes)
        {
            if(selectedName.equals(cl.getClassName()))
            {
                ids.add(cl.getClassId());
            }
        }
        return ids;
    }

    public static void main(String args[])
    {
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<CoolComboBoxModel.Item<VehicleBody>> bodyCombo;
    private javax.swing.JComboBox<String> classCombo;
    private javax.swing.JButton clearSearchBtn;
    private javax.swing.JLabel componentImageLabel;
    private javax.swing.JTable componentsTable;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<CoolComboBoxModel.Item<Model>> modelCombo;
    private javax.swing.JButton newConfigurationBtn;
    private javax.swing.JButton openBtn;
    private javax.swing.JButton saveAsBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JScrollPane tableScrollPane;
    // End of variables declaration//GEN-END:variables
}
