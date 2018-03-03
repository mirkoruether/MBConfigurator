package de.mirkoruether.mbconfigurator.gui;

import de.mirkoruether.mbconfigurator.api.ChangeSet;
import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.logic.AppConfig;
import de.mirkoruether.mbconfigurator.logic.AsyncApiCall;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.ConfigurationAlternative;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import de.mirkoruether.mbconfigurator.pojo.VehicleComponent;
import de.mirkoruether.util.LinqList;
import de.mirkoruether.util.gui.CoolAllroundWindowListener;
import de.mirkoruether.util.gui.CoolComboBoxModel;
import de.mirkoruether.util.gui.CoolTableModel;
import de.mirkoruether.util.gui.GeneralGuiUtils;
import de.mirkoruether.util.gui.ImageHolder;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;

public class Main extends javax.swing.JFrame implements CoolAllroundWindowListener
{
    public static final String MARKET = "de_DE";
    private static final long serialVersionUID = -2992150966224130100L;

    private final AsyncApiCall api = new AsyncApiCall(MARKET, (r) -> SwingUtilities.invokeLater(r));

    private final CoolComboBoxModel<VehicleClass> classComboModel
                                                  = new CoolComboBoxModel<>((c) -> c.getClassName() + " (BR " + c.getClassId() + ")", true);

    private final CoolComboBoxModel<VehicleBody> bodyComboModel
                                                 = new CoolComboBoxModel<>((b) -> b.getBodyName(), true);

    private final CoolComboBoxModel<Model> modelComboModel
                                           = new CoolComboBoxModel<>((m) -> m.getName() + " (Baumuster " + m.getBaumuster() + ")", true);

    private final CoolTableModel<VehicleComponent> componentsTableModel
                                                   = new CoolTableModel<VehicleComponent>()
                    .addColumn("?", c -> c.isSelected(), Boolean.class, true, 20)
                    .addColumn("Code", c -> c.getId(), String.class, false, 50)
                    .addColumn("Kategorie", c -> c.getCategory() == null ? "-" : c.getCategory().getCategoryName(), String.class, false, 100)
                    .addColumn("Bezeichnung", c -> c.getName(), String.class, false, 200);

    private final SaveManager saveManager = new SaveManager((f) -> saveConfiguration(f),
                                                            () -> saveConfigurationAs(),
                                                            () -> SaveManager.DialogResult.Discard);

    private Configuration currentConfig = null;
    private final LinqList<VehicleComponent> selectables = new LinqList<>();

    private final AppConfig cfg = AppConfig.loadOrCreate(new File("mbc.cfg"));

    public Main()
    {
        initComponents();

        applyAllroundWindowListenerTo(this);

        GeneralGuiUtils.addChangeListener(searchTxt, evt -> searchTxtTextChanged(evt));

        classCombo.setModel(classComboModel);
        bodyCombo.setModel(bodyComboModel);
        modelCombo.setModel(modelComboModel);

        componentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        componentsTableModel.applyTo(componentsTable);
        componentsTableModel.addTableModelListener(evt -> tableChanged(evt));
        componentsTable.getSelectionModel().addListSelectionListener((evt) -> selectionChanged(evt));

        classCombo.setSelectedItem(null);

        pack();

        api.getClasses(c -> classComboModel.setAll(c, true));
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        MBConfigurator.getCache().saveMaps();
        System.exit(0);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        dialogBehaviourGroup = new javax.swing.ButtonGroup();
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
        jLabel1 = new javax.swing.JLabel();
        dialogAlwaysRadio = new javax.swing.JRadioButton();
        dialogIfChangesRadio = new javax.swing.JRadioButton();
        dialogNeverRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

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
        clearSearchBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearSearchBtnActionPerformed(evt);
            }
        });

        hideDefaultCheckBox.setSelected(true);
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

        jLabel1.setText("Änderungsinfo zeigen:");

        dialogBehaviourGroup.add(dialogAlwaysRadio);
        dialogAlwaysRadio.setSelected(true);
        dialogAlwaysRadio.setText("Immer");

        dialogBehaviourGroup.add(dialogIfChangesRadio);
        dialogIfChangesRadio.setText("Bei Auswahl");

        dialogBehaviourGroup.add(dialogNeverRadio);
        dialogNeverRadio.setText("Nie");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dialogAlwaysRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dialogIfChangesRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dialogNeverRadio)
                        .addGap(0, 282, Short.MAX_VALUE)))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshBtn)
                    .addComponent(jLabel1)
                    .addComponent(dialogAlwaysRadio)
                    .addComponent(dialogIfChangesRadio)
                    .addComponent(dialogNeverRadio))
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
                        .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bodyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        api.getBodies(classComboModel.getSelected(),
                      x -> bodyComboModel.setAll(x, true));
    }//GEN-LAST:event_classComboActionPerformed

    private void bodyComboActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_bodyComboActionPerformed
    {//GEN-HEADEREND:event_bodyComboActionPerformed
        modelComboModel.removeAllElements();
        api.getModels(classComboModel.getSelected(), bodyComboModel.getSelected(),
                      m -> modelComboModel.setAll(m, true));
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
        ChangeSet cs = ChangeSet.build(new LinqList<>(currentConfig.getVehicleComponents()).select(c -> c.getId()),
                                       selectables.where(c -> c.isSelected()).select(c -> c.getId()));

        api.getAlternatives(currentConfig, cs, alts -> chooseAlternative(alts));
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void clearSearchBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearSearchBtnActionPerformed
    {//GEN-HEADEREND:event_clearSearchBtnActionPerformed
        searchTxt.setText("");
    }//GEN-LAST:event_clearSearchBtnActionPerformed

    private void searchTxtTextChanged(ChangeEvent evt)
    {
        updateSeletables();
    }

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

        if(comp != null)
        {
            final String id = comp.getId();

            downloadAndSetImage(componentImageLabel,
                                ()
                                ->
                        {
                            Map<String, String> links = MBConfigurator.getComponentImageLinks(MARKET, currentConfig.getModelId(), currentConfig.getConfigurationId(), comp);
                            return links.isEmpty() ? null : MBConfigurator.downloadImage(links.values().iterator().next());
                        },
                                () -> componentsTable.getSelectedRow() > 0
                                      && id.equals(componentsTableModel.getValueAt(componentsTable.getSelectedRow(), 1).toString()), 1);
        }
    }

    private void chooseAlternative(ConfigurationAlternative[] alts)
    {
        final Consumer<ConfigurationAlternative> callback = a
                -> api.getConfig(a, c -> setCurrentConfig(c));

        if(dialogNeverRadio.isSelected() || (dialogIfChangesRadio.isSelected() && alts.length == 1)
           || (alts[0].getAddedComponents().isEmpty() && alts[0].getUpdatedComponents().isEmpty() && alts[0].getRemovedComponents().isEmpty()))
        {
            callback.accept(alts[0]);
        }
        else
        {
            ConfigChooseDialog dialog = new ConfigChooseDialog(alts, callback);
            dialog.setVisible(true);
        }
    }

    public void setCurrentConfig(Configuration config)
    {
        selectables.clear();
        Selectables select = MBConfigurator.getSelectibles(MARKET, config.getModelId(), config.getConfigurationId());
        selectables.addAllWhere(select.getVehicleComponents(),
                                c -> !cfg.getIgnoredCodeTypes().contains(c.getCodeType()));
        selectables.sort(null);
        updateSeletables();
        currentConfig = config;

        final String id = config.getConfigurationId();
        downloadAndSetImage(imageLabel,
                            ()
                            ->
                    {
                        Map<String, String> links = MBConfigurator.getVehicleImageLinks(MARKET, currentConfig.getModelId(), currentConfig.getConfigurationId());
                        return links.isEmpty() ? null : MBConfigurator.downloadImage(links.values().iterator().next());
                    },
                            () -> currentConfig != null && id.equals(currentConfig.getConfigurationId()), 5);
    }

    private static void downloadAndSetImage(JLabel label, Supplier<BufferedImage> supplier, Supplier<Boolean> checkAfterDownload, int retrys)
    {
        label.setIcon(null);
        label.setText("Lade Bild...");
        new Thread(()
                ->
        {
            BufferedImage image = null;
            boolean error = true;
            int count = 0;
            while(error && count++ < retrys)
            {
                try
                {
                    image = supplier.get();
                    error = false;
                }
                catch(Exception ex)
                {
                    GeneralGuiUtils.sleep(500);
                }
            }

            final BufferedImage finalImage = image;
            final boolean finalError = error;
            EventQueue.invokeLater(()
                    ->
            {
                if(checkAfterDownload.get())
                {
                    label.setIcon(finalImage == null ? null : new ImageIcon(finalImage));
                    if(finalError)
                    {
                        label.setText("Fehler beim Laden des Bilds");
                    }
                }
            });
        }).start();
    }

    private void updateSeletables()
    {
        final LinqList<String> searchWords = new LinqList<>(searchTxt.getText().split(" "))
                .where(s -> !s.isEmpty()).select(s -> s.toUpperCase());

        Predicate<VehicleComponent> pred = (c)
                ->
        {
            if(c == null)
                return false;
            if(hideDefaultCheckBox.isSelected() && c.isStandard())
                return false;

            String name = c.getName() == null ? "" : c.getName().toUpperCase();
            String code = c.getId() == null ? "" : c.getId().toUpperCase();
            for(String word : searchWords)
            {
                if(!(name.contains(word) || code.contains(word)))
                {
                    return false;
                }
            }

            return true;
        };

        componentsTableModel.clear();
        componentsTableModel.addAll(selectables.where(pred));
    }

    private File saveConfigurationAs()
    {
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File f = fc.getSelectedFile();
            if(saveConfiguration(f))
                return f;
        }
        return null;
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
    private javax.swing.JComboBox<CoolComboBoxModel.Item<VehicleClass>> classCombo;
    private javax.swing.JButton clearSearchBtn;
    private javax.swing.JLabel componentImageLabel;
    private javax.swing.JTable componentsTable;
    private javax.swing.JRadioButton dialogAlwaysRadio;
    private javax.swing.ButtonGroup dialogBehaviourGroup;
    private javax.swing.JRadioButton dialogIfChangesRadio;
    private javax.swing.JRadioButton dialogNeverRadio;
    private javax.swing.JCheckBox hideDefaultCheckBox;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
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
