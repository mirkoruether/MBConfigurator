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

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

public interface CoolAllroundWindowListener extends WindowListener, WindowFocusListener, WindowStateListener,
                                                    MouseListener, MouseMotionListener, MouseWheelListener, KeyListener
{
    @Override
    default public void windowActivated(WindowEvent e)
    {
    }

    @Override
    default public void windowClosed(WindowEvent e)
    {
    }

    @Override
    default public void windowClosing(WindowEvent e)
    {
    }

    @Override
    default public void windowDeactivated(WindowEvent e)
    {
    }

    @Override
    default public void windowDeiconified(WindowEvent e)
    {
    }

    @Override
    default public void windowIconified(WindowEvent e)
    {
    }

    @Override
    default public void windowOpened(WindowEvent e)
    {
    }

    @Override
    default public void windowGainedFocus(WindowEvent e)
    {
    }

    @Override
    default public void windowLostFocus(WindowEvent e)
    {
    }

    @Override
    default public void windowStateChanged(WindowEvent e)
    {
    }

    @Override
    default public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    default public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    default public void mouseExited(MouseEvent e)
    {
    }

    @Override
    default public void mousePressed(MouseEvent e)
    {
    }

    @Override
    default public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    default public void mouseDragged(MouseEvent e)
    {
    }

    @Override
    default public void mouseMoved(MouseEvent e)
    {
    }

    @Override
    default public void mouseWheelMoved(MouseWheelEvent e)
    {
    }

    @Override
    default public void keyPressed(KeyEvent e)
    {
    }

    @Override
    default public void keyReleased(KeyEvent e)
    {
    }

    @Override
    default public void keyTyped(KeyEvent e)
    {
    }

    default public void applyAllroundWindowListenerTo(Window w)
    {
        w.addWindowListener(this);
        w.addWindowFocusListener(this);
        w.addWindowStateListener(this);
        w.addMouseListener(this);
        w.addMouseMotionListener(this);
        w.addMouseWheelListener(this);
        w.addKeyListener(this);
    }
}
