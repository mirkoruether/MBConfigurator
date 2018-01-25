package de.mirkoruether.mbconfigurator.gui;

import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import de.mirkoruether.mbconfigurator.pojo.VehicleComponent;
import de.mirkoruether.util.LinqList;
import de.mirkoruether.util.gui.CoolComboBoxModel;
import de.mirkoruether.util.gui.CoolTableModel;
import java.awt.EventQueue;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main extends javax.swing.JFrame
{
    public static final String MARKET = "de_DE";

    private static final long serialVersionUID = 1L;

    private final DefaultComboBoxModel<String> classComboModel;
    private final CoolComboBoxModel<VehicleBody> bodyComboModel;
    private final CoolComboBoxModel<Model> modelComboModel;
    private final CoolTableModel<VehicleComponent> componentsTableModel;

    private final LinqList<VehicleClass> classes;

    private Configuration currentConfig = null;
    private final SaveManager saveManager;

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
        classCombo.setModel(classComboModel);

        bodyComboModel = new CoolComboBoxModel<>((b) -> b.getBodyName(), true);
        bodyCombo.setModel(bodyComboModel);

        modelComboModel = new CoolComboBoxModel<>((m) -> m.getName(), true);
        modelCombo.setModel(modelComboModel);

        componentsTableModel = new CoolTableModel<VehicleComponent>()
                .addColumn("?", c -> c.isSelected(), Boolean.class, true, 20)
                .addColumn("Code", c -> c.getCode(), String.class, false, 50)
                .addColumn("Bezeichnung", c -> c.getName(), String.class, false, 200);
        componentsTableModel.applyTo(componentsTable);

        classCombo.setSelectedItem(null);

        saveManager = new SaveManager((f) -> saveConfiguration(f),
                                      () ->
                              {
                                  JFileChooser fc = new JFileChooser();
                                  if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
                                  {
                                      File f = fc.getSelectedFile();
                                      if(saveConfiguration(f))
                                          return f;
                                  }
                                  return null;
                              },
                                      () -> SaveManager.DialogResult.Discard);
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
        hideDefaultCheckBox = new javax.swing.JCheckBox();

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
        newConfigurationBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newConfigurationBtnActionPerformed(evt);
            }
        });

        saveBtn.setText("Speichern");
        saveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveBtnActionPerformed(evt);
            }
        });

        saveAsBtn.setText("Speichern unter");
        saveAsBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveAsBtnActionPerformed(evt);
            }
        });

        openBtn.setText("Öffnen");
        openBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setText("Bild");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        clearSearchBtn.setText("X");

        tableScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        componentsTable.setAutoCreateRowSorter(true);
        componentsTable.setPreferredSize(new java.awt.Dimension(1000, 1000));
        tableScrollPane.setViewportView(componentsTable);

        componentImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        componentImageLabel.setText("Bild");

        hideDefaultCheckBox.setText("Standardaustattung ausblenden");
        hideDefaultCheckBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                hideDefaultCheckBoxActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(clearSearchBtn))
                                .addComponent(componentImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(hideDefaultCheckBox))
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
                        .addComponent(hideDefaultCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componentImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_classComboActionPerformed
    {//GEN-HEADEREND:event_classComboActionPerformed
        bodyComboModel.removeAllElements();
        List<String> selectedClassIds = getSelectedClassIds();
        if(!selectedClassIds.isEmpty())
        {
            new Thread(() ->
            {
                LinqList<VehicleBody> bodies = new LinqList<>();
                for(String id : selectedClassIds)
                {
                    bodies.addAll(MBConfigurator.getVehicleBodies(MARKET, null, id));
                }
                bodies.sort((b1, b2) -> b1.getBodyName().compareTo(b2.getBodyName()));
                EventQueue.invokeLater(() -> bodyComboModel.setAll(bodies));
            }).start();
        }
    }//GEN-LAST:event_classComboActionPerformed

    private void bodyComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bodyComboActionPerformed
    {//GEN-HEADEREND:event_bodyComboActionPerformed
        modelComboModel.removeAllElements();
        List<String> selectedClassIds = getSelectedClassIds();
        VehicleBody selectedBody = bodyComboModel.getSelected();
        String selectedBodyId = selectedBody == null ? null : selectedBody.getBodyId();

        if(!selectedClassIds.isEmpty()
           && selectedBodyId != null && !selectedBodyId.trim().isEmpty())
        {
            new Thread(() ->
            {
                LinqList<Model> models = new LinqList<>();
                for(String id : selectedClassIds)
                {
                    models.addAll(MBConfigurator.getModels(MARKET, null, id, selectedBodyId));
                }
                models.sort((m1, m2) -> m1.getName().compareTo(m2.getName()));
                EventQueue.invokeLater(() -> modelComboModel.setAll(models));
            }).start();
        }
    }//GEN-LAST:event_bodyComboActionPerformed

    private void newConfigurationBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newConfigurationBtnActionPerformed
    {//GEN-HEADEREND:event_newConfigurationBtnActionPerformed
        try
        {
            Model selectedModel = modelComboModel.getSelected();
            if(selectedModel == null || selectedModel.getModelId() == null || selectedModel.getModelId().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Bitte zuerst ein Modell und eine Motorisierung auswählen!");
                return;
            }
            if(!saveManager.newElement())
                return;

            setCurrentConfig(MBConfigurator.getInitialConfiguration(MARKET, selectedModel.getModelId()));
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Unerwarteter Fehler!");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_newConfigurationBtnActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openBtnActionPerformed
    {//GEN-HEADEREND:event_openBtnActionPerformed
        JOptionPane.showMessageDialog(this, "Feature ist in Arbeit, sorry Bruder");
    }//GEN-LAST:event_openBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveBtnActionPerformed
    {//GEN-HEADEREND:event_saveBtnActionPerformed
        componentsTable.setSize(500, componentsTable.getHeight());
        saveManager.save();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void saveAsBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAsBtnActionPerformed
    {//GEN-HEADEREND:event_saveAsBtnActionPerformed
        saveManager.saveAs();
    }//GEN-LAST:event_saveAsBtnActionPerformed

    private void hideDefaultCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_hideDefaultCheckBoxActionPerformed
    {//GEN-HEADEREND:event_hideDefaultCheckBoxActionPerformed
        updateSeletables(currentConfig);
    }//GEN-LAST:event_hideDefaultCheckBoxActionPerformed

    public void setCurrentConfig(Configuration config)
    {
        updateSeletables(config);
        currentConfig = config;
    }

    private void updateSeletables(Configuration config)
    {
        componentsTableModel.clear();
        List<VehicleComponent> comps = MBConfigurator.getSelectibles(MARKET, config.getModelId(), config.getConfigurationId()).getVehicleComponents();
        if(hideDefaultCheckBox.isSelected())
        {
            comps = new LinqList<>(comps).where(c -> !c.isStandard());
        }
        comps.sort((c1, c2) -> c1.getComponentSortId() - c2.getComponentSortId());
        componentsTableModel.addAll(comps);
    }

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

    private boolean saveConfiguration(File f)
    {
        //TODO implement
        return true;
    }

    public static void main(String args[]) throws Exception
    {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<CoolComboBoxModel.Item<VehicleBody>> bodyCombo;
    private javax.swing.JComboBox<String> classCombo;
    private javax.swing.JButton clearSearchBtn;
    private javax.swing.JLabel componentImageLabel;
    private javax.swing.JTable componentsTable;
    private javax.swing.JCheckBox hideDefaultCheckBox;
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
