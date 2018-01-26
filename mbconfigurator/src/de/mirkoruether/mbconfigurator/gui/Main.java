package de.mirkoruether.mbconfigurator.gui;

import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import de.mirkoruether.mbconfigurator.pojo.VehicleComponent;
import de.mirkoruether.util.LinqList;
import de.mirkoruether.util.gui.CoolComboBoxModel;
import de.mirkoruether.util.gui.CoolTableModel;
import de.mirkoruether.util.gui.ImageHolder;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;

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
    private LinqList<VehicleComponent> selectables = new LinqList<>();
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

        componentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        componentsTableModel = new CoolTableModel<VehicleComponent>()
                .addColumn("?", c -> c.isSelected(), Boolean.class, true, 20)
                .addColumn("Code", c -> c.getId(), String.class, false, 50)
                .addColumn("Kategorie", c -> c.getCategory() == null ? "-" : c.getCategory().getCategoryName(), String.class, false, 100)
                .addColumn("Bezeichnung", c -> c.getName(), String.class, false, 200);
        componentsTableModel.applyTo(componentsTable);
        componentsTableModel.addTableModelListener(evt -> tableChanged(evt));
        componentsTable.getSelectionModel().addListSelectionListener((evt) -> selectionChanged(evt));

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
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        clearSearchBtn = new javax.swing.JButton();
        hideDefaultCheckBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        componentsTable = new javax.swing.JTable();
        componentImageLabel = new ImageHolder();
        jPanel4 = new javax.swing.JPanel();
        imageLabel = new ImageHolder();
        jSeparator3 = new javax.swing.JSeparator();
        refreshBtn = new javax.swing.JButton();

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

        clearSearchBtn.setText("X");

        hideDefaultCheckBox.setText("Standardaustattung ausblenden");
        hideDefaultCheckBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                hideDefaultCheckBoxActionPerformed(evt);
            }
        });

        componentsTable.setAutoCreateRowSorter(true);
        componentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(componentsTable);

        componentImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        componentImageLabel.setText("Bild");
        componentImageLabel.setMaximumSize(new java.awt.Dimension(320, 180));
        componentImageLabel.setMinimumSize(new java.awt.Dimension(320, 180));
        componentImageLabel.setPreferredSize(new java.awt.Dimension(320, 180));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(componentImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hideDefaultCheckBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(searchTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearSearchBtn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearSearchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hideDefaultCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(componentImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setText("Bild");

        refreshBtn.setText("Aktualisieren");
        refreshBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(refreshBtn)
                        .addGap(0, 589, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refreshBtn)
                .addGap(5, 5, 5))
        );

        jSplitPane1.setRightComponent(jPanel4);

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
                        .addComponent(modelCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newConfigurationBtn))
                    .addComponent(jSplitPane1))
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
                .addComponent(jSplitPane1)
                .addContainerGap())
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
        updateSeletables();
    }//GEN-LAST:event_hideDefaultCheckBoxActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_refreshBtnActionPerformed
    {//GEN-HEADEREND:event_refreshBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void tableChanged(TableModelEvent evt)
    {
        if(evt.getType() != TableModelEvent.UPDATE)
        {
            return;
        }

        for(int i = evt.getFirstRow(); i <= evt.getLastRow(); i++)
        {
            boolean selected = Boolean.TRUE.equals(componentsTableModel.getValueAt(i, 0));
            String code = componentsTableModel.getValueAt(i, 1).toString();

            for(VehicleComponent comp : selectables)
            {
                if(code.equals(comp.getId()))
                {
                    comp.setSelected(selected);
                    break;
                }
            }
        }
    }

    private void selectionChanged(ListSelectionEvent evt)
    {
        if(evt.getValueIsAdjusting() || componentsTable.getSelectedRow() < 0)
            return;

        String selectedCode = componentsTableModel.getValueAt(componentsTable.getSelectedRow(), 1).toString();
        VehicleComponent comp = selectables.firstWhere((c) -> selectedCode.equals(c.getId()));
        String id = comp.getId();
        componentImageLabel.setIcon(null);
        componentImageLabel.setText("Lade Bild...");

        new Thread(() ->
        {
            Map<String, String> links = MBConfigurator.getComponentImageLinks(MARKET, currentConfig.getModelId(), currentConfig.getConfigurationId(), comp);
            final BufferedImage image = links.isEmpty() ? null : download(links.values().iterator().next());

            EventQueue.invokeLater(() ->
            {
                if(componentsTable.getSelectedRow() > 0
                   && id.equals(componentsTableModel.getValueAt(componentsTable.getSelectedRow(), 1).toString()))
                {
                    componentImageLabel.setIcon(image == null ? null : new ImageIcon(image));
                }
            });
        }).start();
    }

    public void setCurrentConfig(Configuration config)
    {
        selectables.clear();
        Selectables select = MBConfigurator.getSelectibles(MARKET, config.getModelId(), config.getConfigurationId());
        selectables.addAll(select.getVehicleComponents());
        selectables.sort(null);
        updateSeletables();
        currentConfig = config;

        final String id = config.getConfigurationId();
        imageLabel.setIcon(null);
        imageLabel.setText("Lade Bild...");
        new Thread(() ->
        {
            Map<String, String> links = MBConfigurator.getVehicleImageLinks(MARKET, currentConfig.getModelId(), currentConfig.getConfigurationId());
            final BufferedImage image = links.isEmpty() ? null : download(links.values().iterator().next());

            EventQueue.invokeLater(() ->
            {
                if(currentConfig != null
                   && id.equals(currentConfig.getConfigurationId()))
                {
                    imageLabel.setIcon(image == null ? null : new ImageIcon(image));
                }
            });
        }).start();
    }

    private static BufferedImage download(String url)
    {
        try
        {
            return ImageIO.read(new URL(url));
        }
        catch(IOException ex)
        {
            return null;
        }
    }

    private void updateSeletables()
    {
        componentsTableModel.clear();
        if(hideDefaultCheckBox.isSelected())
        {
            componentsTableModel.addAll(selectables.where(c -> !c.isStandard()));
        }
        else
        {
            componentsTableModel.addAll(selectables);
        }
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox<CoolComboBoxModel.Item<Model>> modelCombo;
    private javax.swing.JButton newConfigurationBtn;
    private javax.swing.JButton openBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveAsBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
