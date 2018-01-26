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

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageHolder extends JLabel
{
    private static final long serialVersionUID = 160017084189608873L;

    private ImageIcon currentIcon = null;

    public ImageHolder()
    {
        addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                refreshImage();
            }
        });
    }

    public void refreshImage()
    {
        ImageIcon ic = currentIcon;
        setIcon(null);
        setMinimumSize(new Dimension(0, 0));
        setIcon(ic);
    }

    @Override
    public void setIcon(Icon icon)
    {
        if(icon == null || !(icon instanceof ImageIcon))
        {
            currentIcon = null;
            super.setIcon(icon);
            return;
        }
        currentIcon = (ImageIcon)icon;

        if(icon == null)
        {
            super.setIcon(null);
            super.setText("Kein Bild");
            return;
        }
        super.setText("");

        double scaleFactor = Math.min((double)getWidth() / icon.getIconWidth(),
                                      (double)getHeight() / icon.getIconHeight());
        int newWidth = (int)(scaleFactor * icon.getIconWidth());
        int newHeight = (int)(scaleFactor * icon.getIconHeight());

        Image newimg = ((ImageIcon)icon).getImage().getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(newimg));
    }

    public ImageIcon getCurrentIcon()
    {
        return currentIcon;
    }
}
