package de.mirkoruether.util;

import java.io.File;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.function.Function;

public class CsvSerializer<T>
{
    private static final char SEPERATION_CHAR = ';';
    private static final int MAXIMUM_FRACTION_DIGITS = 5;

    private final ArrayList<Field<T>> fields;

    public CsvSerializer()
    {
        this.fields = new ArrayList<>();
    }

    public CsvSerializer(Collection<? extends Field<T>> fields)
    {
        this.fields = new ArrayList<>(fields);
    }

    public CsvSerializer<T> addField(String name, Function<T, ? extends Object> func)
    {
        fields.add(new Field<>(name, func));
        return this;
    }

    @SafeVarargs
    public final void serializeToFile(String filename, T... entrys)
    {
        serializeToFile(filename, Arrays.asList(entrys));
    }

    public void serializeToFile(String filename, Collection<T> entrys)
    {
        File f = new File(filename);

        try(PrintWriter writer = new PrintWriter(f))
        {
            writer.println(buildHeadLine());
            for(T entry : entrys)
            {
                writer.println(buildEntryLine(entry));
            }
            writer.flush();
            writer.close();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Exception while serializing entrys to file", ex);
        }
    }

    private String buildHeadLine()
    {
        return buildCsvLine(Field :: getName);
    }

    private String buildEntryLine(T entry)
    {
        return buildCsvLine((f) -> stringValueOf(f.applyFunc(entry)));
    }

    private String buildCsvLine(Function<Field<T>, String> func)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < fields.size(); i++)
        {
            if(i > 0)
            {
                sb.append(SEPERATION_CHAR);
            }

            sb.append(func.apply(fields.get(i)));
        }
        return sb.toString();
    }

    private String stringValueOf(Object obj)
    {
        if(obj instanceof Number)
        {
            final NumberFormat formatter = NumberFormat.getInstance(Locale.GERMANY);
            formatter.setMaximumFractionDigits(MAXIMUM_FRACTION_DIGITS);
            return formatter.format(obj);
        }

        return String.valueOf(obj);
    }

    public ArrayList<Field<T>> getFields()
    {
        return fields;
    }

    public static class Field<T>
    {
        private String name;
        private Function<T, ? extends Object> func;

        public Field(String name, Function<T, ? extends Object> func)
        {
            this.name = name;
            this.func = func;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public Object applyFunc(T entry)
        {
            return func.apply(entry);
        }

        public Function<T, ? extends Object> getFunc()
        {
            return func;
        }

        public void setFunc(Function<T, ? extends Object> func)
        {
            this.func = func;
        }
    }
}
