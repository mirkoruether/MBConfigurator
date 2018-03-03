/*
MIT License

Copyright (c) 2018 Mirko RÃ¼ther

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package de.mirkoruether.mbconfigurator.gui;

import de.mirkoruether.mbconfigurator.pojo.ConfigurationAlternative;
import de.mirkoruether.mbconfigurator.pojo.VehicleComponent;
import de.mirkoruether.util.gui.CoolTableModel;
import java.util.List;

public class ChoicePanel extends javax.swing.JPanel
{
    private static final long serialVersionUID = -6570044065922466815L;

    private final CoolTableModel<Entry> tableModel = new CoolTableModel<Entry>()
            .addColumn("Aktion", x -> x.getType(), String.class, false, 70)
            .addColumn("Code", x -> x.getCode(), String.class, false, 50)
            .addColumn("Name", x -> x.getName(), String.class, false, 300);

    private final Runnable callback;

    public ChoicePanel(ConfigurationAlternative alt, Runnable callback)
    {
        this.callback = callback;
        initComponents();

        tableModel.applyTo(changeTable);

        addToTable(alt.getAddedComponents(), "Hinzugefügt");
        addToTable(alt.getRemovedComponents(), "Entfernt");
        addToTable(alt.getUpdatedComponents(), "Verändert");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        confirmButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        changeTable = new javax.swing.JTable();

        confirmButton.setText("Diese Alternative akzeptieren");
        confirmButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                confirmButtonActionPerformed(evt);
            }
        });

        changeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(changeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_confirmButtonActionPerformed
    {//GEN-HEADEREND:event_confirmButtonActionPerformed
        callback.run();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void addToTable(List<VehicleComponent> list, String type)
    {
        if(list != null)
        {
            for(VehicleComponent c : list)
            {
                tableModel.add(new Entry(type, c));
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable changeTable;
    private javax.swing.JButton confirmButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private static class Entry
    {
        private final String type;
        private final VehicleComponent comp;

        Entry(String type, VehicleComponent comp)
        {
            this.type = type;
            this.comp = comp;
        }

        public String getType()
        {
            return type;
        }

        public String getCode()
        {
            return comp == null ? null : comp.getId();
        }

        public String getName()
        {
            return comp == null ? null : comp.getName();
        }
    }
}
