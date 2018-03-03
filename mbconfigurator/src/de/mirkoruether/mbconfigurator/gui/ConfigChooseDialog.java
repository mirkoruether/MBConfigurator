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
import de.mirkoruether.util.gui.CoolAllroundWindowListener;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.util.function.Consumer;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class ConfigChooseDialog extends JFrame implements CoolAllroundWindowListener
{
    private static final long serialVersionUID = 3354431203168620662L;

    private final ConfigurationAlternative[] alternatives;
    private final Consumer<ConfigurationAlternative> callback;
    private final JTabbedPane tabs;

    public ConfigChooseDialog(ConfigurationAlternative[] alternatives, Consumer<ConfigurationAlternative> callback) throws HeadlessException
    {
        applyAllroundWindowListenerTo(this);

        this.alternatives = alternatives;
        this.callback = callback;

        this.tabs = new JTabbedPane();

        for(int i = 0; i < alternatives.length; i++)
        {
            ConfigurationAlternative alt = alternatives[i];
            final int number = i;
            tabs.add("Alternative" + (i + 1), new ChoicePanel(alt, () -> finish(number)));
        }

        this.add(tabs);

        pack();
    }

    private void finish(int index)
    {
        dispose();
        callback.accept(index < 0 ? null : alternatives[index]);
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        finish(-1);
    }
}
