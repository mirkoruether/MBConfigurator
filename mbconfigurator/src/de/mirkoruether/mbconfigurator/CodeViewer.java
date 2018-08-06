package de.mirkoruether.mbconfigurator;

import de.mirkoruether.mbconfigurator.api.MBConfigurator;
import de.mirkoruether.mbconfigurator.logic.AsyncApiCall;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import de.mirkoruether.mbconfigurator.pojo.VehicleComponent;
import de.mirkoruether.util.LinqList;
import de.mirkoruether.util.gui.CoolAllroundWindowListener;
import de.mirkoruether.util.gui.CoolComboBoxModel;
import de.mirkoruether.util.gui.GeneralGuiUtils;
import java.util.List;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.apache.commons.text.WordUtils;
import static de.mirkoruether.mbconfigurator.gui.Main.MARKET;

public class CodeViewer extends javax.swing.JFrame implements CoolAllroundWindowListener
{
    private static final long serialVersionUID = -5415925682414612949L;

    private final AsyncApiCall api = new AsyncApiCall(MARKET, (r) -> SwingUtilities.invokeLater(r), t -> handleError(t));

    private final CoolComboBoxModel<VehicleClass> classComboModel
                                                  = new CoolComboBoxModel<>((c) -> c.getClassName() + " (BR " + c.getClassId() + ")", true);

    private final CoolComboBoxModel<VehicleBody> bodyComboModel
                                                 = new CoolComboBoxModel<>((b) -> b.getBodyName(), true);

    private final CoolComboBoxModel<Model> modelComboModel
                                           = new CoolComboBoxModel<>((m) -> m.getName() + " (Baumuster " + m.getBaumuster() + ")", true);

    private final DefaultTreeModel treeModel = new DefaultTreeModel(null);

    private List<VehicleComponent> comps;
    private String rootName;

    public CodeViewer()
    {
        initComponents();

        applyAllroundWindowListenerTo(this);

        GeneralGuiUtils.addChangeListener(searchTxt, evt -> searchTxtTextChanged(evt));

        classCombo.setModel(classComboModel);
        bodyCombo.setModel(bodyComboModel);
        modelCombo.setModel(modelComboModel);

        tree.setModel(treeModel);

        classCombo.setSelectedItem(null);

        pack();

        api.getClasses(c -> classComboModel.setAll(c, true));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        classCombo = new javax.swing.JComboBox<>();
        bodyCombo = new javax.swing.JComboBox<>();
        modelCombo = new javax.swing.JComboBox<>();
        startBtn = new javax.swing.JButton();
        treeScrollPane = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        searchTxt = new javax.swing.JTextField();
        clearSearch = new javax.swing.JButton();

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

        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                startBtnActionPerformed(evt);
            }
        });

        treeScrollPane.setViewportView(tree);

        clearSearch.setText("x");
        clearSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(treeScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bodyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modelCombo, 0, 168, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bodyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
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

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_startBtnActionPerformed
    {//GEN-HEADEREND:event_startBtnActionPerformed
        try
        {
            Model selectedModel = modelComboModel.getSelected();
            if(selectedModel == null || selectedModel.getModelId() == null || selectedModel.getModelId().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Bitte zuerst ein Modell und eine Motorisierung auswählen!");
                return;
            }

            setModel(selectedModel);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Unerwarteter Fehler!");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_startBtnActionPerformed

    private void clearSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearSearchActionPerformed
    {//GEN-HEADEREND:event_clearSearchActionPerformed
        searchTxt.setText("");
    }//GEN-LAST:event_clearSearchActionPerformed

    private void handleError(Throwable t)
    {
        String message = "Unerwarteter Fehler!\n"
                         + t.getClass().getName() + "\n"
                         + WordUtils.wrap(t.getMessage(), 100, "\n", true);
        JOptionPane.showMessageDialog(this, message, "Fehler!", JOptionPane.ERROR_MESSAGE);
        t.printStackTrace();
    }

    public void setModel(Model model)
    {
        Configuration conf = MBConfigurator.getInitialConfiguration(model, MARKET);
        Selectables select = MBConfigurator.getSelectibles(conf);
        setComponets(model.getName(), select.getVehicleComponents());
    }

    private void searchTxtTextChanged(ChangeEvent evt)
    {
        refreshTree();
    }

    private boolean isValid(VehicleComponent comp, String search)
    {
        final LinqList<String> searchWords = new LinqList<>(search.split(" "))
                .where(s -> !s.isEmpty()).select(s -> s.toUpperCase());

        Predicate<VehicleComponent> pred = (c)
                ->
        {
            if(c == null)
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

        if(pred.test(comp))
            return true;

        if(comp.getIncludedComponents() == null || comp.getIncludedComponents().getVehicleComponents() == null)
            return false;

        return new LinqList<>(comp.getIncludedComponents().getVehicleComponents()).one(x -> isValid(x, search));
    }

    public void setComponets(String rootName, List<VehicleComponent> comps)
    {
        this.rootName = rootName;
        this.comps = comps;
        refreshTree();
    }

    private void refreshTree()
    {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootName);
        appendTo(root, new LinqList<>(comps).where(x -> isValid(x, searchTxt.getText())));
        treeModel.setRoot(root);
    }

    private void appendTo(DefaultMutableTreeNode node, List<VehicleComponent> comps)
    {
        comps.sort(null);
        for(VehicleComponent comp : comps)
        {
            String name = comp.getId() + " " + comp.getName();
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(name);
            if(comp.getIncludedComponents() != null && comp.getIncludedComponents().getVehicleComponents() != null)
            {
                appendTo(child, comp.getIncludedComponents().getVehicleComponents());
            }
            node.add(child);
        }
    }

    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> new CodeViewer().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<CoolComboBoxModel.Item<VehicleBody>> bodyCombo;
    private javax.swing.JComboBox<CoolComboBoxModel.Item<VehicleClass>> classCombo;
    private javax.swing.JButton clearSearch;
    private javax.swing.JComboBox<CoolComboBoxModel.Item<Model>> modelCombo;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton startBtn;
    private javax.swing.JTree tree;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables
}
