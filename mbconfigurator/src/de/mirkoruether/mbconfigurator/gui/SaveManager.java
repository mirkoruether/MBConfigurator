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

import java.io.File;
import java.util.function.Function;
import java.util.function.Supplier;

public class SaveManager
{
    private boolean changesMade = false;
    private File file = null;
    private final Function<File, Boolean> saveAction;
    private final Supplier<File> saveAsAction;
    private final Supplier<DialogResult> dialog;

    public SaveManager(Function<File, Boolean> saveAction, Supplier<File> saveAsAction, Supplier<DialogResult> dialog)
    {
        this.saveAction = saveAction;
        this.saveAsAction = saveAsAction;
        this.dialog = dialog;
    }

    public void changeMade()
    {
        changesMade = true;
    }

    public boolean newElement()
    {
        if(!changesMade)
            return true;

        DialogResult result = dialog.get();
        switch(result)
        {
            case Abort:
                return false;
            case Discard:
                file = null;
                changesMade = false;
                return true;
            case Save:
                if(save())
                {
                    file = null;
                    changesMade = false;
                    return true;
                }
                else
                {
                    return false;
                }
            default:
                throw new RuntimeException("Unexcpected DialogResult");
        }
    }

    public boolean save()
    {
        if(file == null)
        {
            return saveAs();
        }
        else
        {
            return saveAction.apply(file);
        }
    }

    public boolean saveAs()
    {
        File f = saveAsAction.get();
        if(f == null)
        {
            return false;
        }
        else
        {
            file = f;
            return true;
        }
    }

    public static enum DialogResult
    {
        Save,
        Discard,
        Abort
    }
}
