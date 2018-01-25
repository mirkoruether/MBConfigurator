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
package de.mirkoruether.util.gui;

import de.mirkoruether.util.LinqList;
import java.util.List;
import java.util.function.Function;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CoolTableModel<T> extends DefaultTableModel
{
    private static final long serialVersionUID = -8006873866028821162L;
    private final LinqList<Column<T>> columnBindings;

    public CoolTableModel()
    {
        this.columnBindings = new LinqList<Column<T>>();
    }

    public CoolTableModel(List<Column<T>> columnBindings)
    {
        this(new LinqList<Column<T>>(columnBindings));
    }

    private CoolTableModel(LinqList<Column<T>> columnBindings)
    {
        super(columnBindings.select((c) -> c.getTitle()).toArray(), 0);
        this.columnBindings = columnBindings;
    }

    public void applyTo(JTable table)
    {
        table.setModel(this);
        int totalWidth = 0;
        for(int i = 0; i < columnBindings.size(); i++)
        {
            int width = columnBindings.get(i).getWidth();
            table.getColumnModel().getColumn(i).setPreferredWidth(width);
            totalWidth += width;
        }
        table.setSize(totalWidth, table.getHeight());
    }

    public CoolTableModel<T> addColumn(String title, Function<T, ?> func, Class<?> culumnType, boolean editable, int width)
    {
        columnBindings.add(new Column<>(title, func, culumnType, editable, width));
        super.addColumn(title);
        return this;
    }

    public void addAll(List<T> objs)
    {
        for(T obj : objs)
        {
            add(obj);
        }
    }

    public void add(T obj)
    {
        super.addRow(columnBindings.select((c) -> c.getFunc().apply(obj)).toArray());
    }

    public void insert(int index, T obj)
    {
        super.insertRow(index, columnBindings.select((c) -> c.getFunc().apply(obj)).toArray());
    }

    public void clear()
    {
        while(super.getRowCount() > 0)
        {
            super.removeRow(0);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return columnBindings.get(column).isEditable();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnBindings.get(columnIndex).getColumnType();
    }

    public static class Column<T>
    {
        private String title;
        private Function<T, ?> func;
        private Class<?> columnType;
        private boolean editable;
        private int width;

        public Column(String title, Function<T, ?> func, Class<?> columnType, boolean editable, int width)
        {
            this.title = title;
            this.func = func;
            this.columnType = columnType;
            this.editable = editable;
            this.width = width;
        }

        public String getTitle()
        {
            return title;
        }

        public void setTitle(String title)
        {
            this.title = title;
        }

        public Function<T, ?> getFunc()
        {
            return func;
        }

        public void setFunc(Function<T, ?> func)
        {
            this.func = func;
        }

        public Class<?> getColumnType()
        {
            return columnType;
        }

        public void setColumnType(Class<?> columnType)
        {
            this.columnType = columnType;
        }

        public boolean isEditable()
        {
            return editable;
        }

        public void setEditable(boolean editable)
        {
            this.editable = editable;
        }

        public int getWidth()
        {
            return width;
        }

        public void setWidth(int width)
        {
            this.width = width;
        }
    }
}
