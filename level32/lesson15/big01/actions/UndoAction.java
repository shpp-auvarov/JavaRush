package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {
    private View view;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        view.undo();
    }

    public UndoAction(View view) {
        this.view = view;
    }
}