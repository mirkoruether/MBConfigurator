package de.mirkoruether.util.gui;

import de.mirkoruether.util.LinqList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.swing.DefaultComboBoxModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CoolComboBoxModel<T> extends DefaultComboBoxModel<CoolComboBoxModel.Item<T>>
{
    private static final long serialVersionUID = -359288104563230398L;
    private Function<T, String> func;

    public CoolComboBoxModel(Function<T, String> func, boolean autoValueForNulls)
    {
        if(func == null)
        {
            throw new IllegalArgumentException("Func is null");
        }

        this.func = autoValueForNulls ? ((obj) -> obj == null ? "null" : func.apply(obj)) : func;
    }

    @SuppressWarnings("unchecked")
    public T getSelected()
    {
        Object selected = getSelectedItem();
        return selected == null ? null : ((Item<T>)selected).getObj();
    }

    public T get(int index)
    {
        return getElementAt(index).getObj();
    }

    public int indexOf(T obj)
    {
        for(int i = 0; i < getSize(); i++)
        {
            T o = getElementAt(i).getObj();
            if(Objects.equals(o, obj))
            {
                return i;
            }
        }
        return -1;
    }

    public void add(T obj)
    {
        addElement(new Item<>(obj, func));
    }

    public void insertAt(T obj, int index)
    {
        insertElementAt(new Item<>(obj, func), index);
    }

    public void remove(T obj)
    {
        removeElementAt(indexOf(obj));
    }

    public LinqList<T> list()
    {
        LinqList<T> result = new LinqList<>();
        for(int i = 0; i < getSize(); i++)
        {
            result.add(getElementAt(i).getObj());
        }
        return result;
    }

    public void setAll(List<T> list)
    {
        removeAllElements();
        for(T obj : list)
        {
            add(obj);
        }
    }

    public Function<T, String> getFunc()
    {
        return func;
    }

    public void setFunc(Function<T, String> func)
    {
        this.func = func;
        for(int i = 0; i < getSize(); i++)
        {
            getElementAt(i).setFunc(func);
        }
        fireContentsChanged(this, 0, getSize() - 1);
    }

    public static class Item<T>
    {
        private T obj;
        private Function<T, String> func;

        public Item(T obj, Function<T, String> func)
        {
            if(func == null)
            {
                throw new IllegalArgumentException("Func is null");
            }

            this.obj = obj;
            this.func = func;
        }

        public T getObj()
        {
            return obj;
        }

        public void setObj(T obj)
        {
            this.obj = obj;
        }

        public Function<T, String> getFunc()
        {
            return func;
        }

        public void setFunc(Function<T, String> func)
        {
            this.func = func;
        }

        @Override
        public String toString()
        {
            return func.apply(obj);
        }

        @Override
        public int hashCode()
        {
            return new HashCodeBuilder()
                    .append(obj)
                    .toHashCode();
        }

        @Override
        public boolean equals(Object other)
        {
            if(other == this)
            {
                return true;
            }
            if((other instanceof Item) == false)
            {
                return false;
            }
            Item<?> rhs = ((Item)other);
            return new EqualsBuilder()
                    .append(obj, rhs.obj)
                    .isEquals();
        }
    }
}
