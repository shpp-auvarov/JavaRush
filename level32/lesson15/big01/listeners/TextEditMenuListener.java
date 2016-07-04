package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {
    private View view;

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu jmenu = (JMenu) menuEvent.getSource();
        Component[] list = jmenu.getMenuComponents();
        for (Component element : list) {
            element.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    public TextEditMenuListener(View view) {
        this.view = view;
    }
}