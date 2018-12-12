package swing;

import data.FCKSPlayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class ScreenSwing extends JFrame {
    private int x = 0, y = 0, width = 600, height = 800;

    public ScreenSwing(HashMap<Integer, FCKSPlayer> data, int[] squad) {
        setTitle("Крылья Советов Самара");
        setBounds(x, y, width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ChoiceComponent choice = new ChoiceComponent(data, squad);
        add(choice);
        choice.setLocation((width-choice.getWidth()), (height-choice.getHeight()));
        setVisible(true);


//        comboBox = new JComboBox(names);
//        comboBox.setFont(font);
    }



    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}