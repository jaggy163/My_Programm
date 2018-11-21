package swing;

import data.FCKSPlayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;

public class ScreenSwing extends JFrame {
    private int x = 0, y = 0, width = 1000, height = 1800;

    public ScreenSwing(HashMap<Integer, FCKSPlayer> data, int[] squad) {
        setTitle("Крылья Советов Самара");
        setBounds(x, y, width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents(this.getContentPane(), data, squad);
        setVisible(true);


//        comboBox = new JComboBox(names);
//        comboBox.setFont(font);
    }

    public void addComponents(Container pane, HashMap<Integer, FCKSPlayer> data, int[] squad) {
        Font font = new Font("Verdana", Font.PLAIN, 24);
        Font font2 = new Font("Verdana", Font.PLAIN, 14);
        String[] names = new String[squad.length];
        for (int index=0; index<squad.length; index++) {
            names[index] = (data.get(squad[index]).getPosition() + " : " + data.get(squad[index]).getName());
        }
        JComboBox comboBox;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        comboBox = new JComboBox(names);
        comboBox.setFont(font);
        c.fill = GridBagConstraints.NORTHEAST;
        c.ipady = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.insets = new Insets(10, 0, 0, 0);
        pane.add(comboBox, c);

        JRadioButton radio1 = new JRadioButton("Полная статистика");
        JRadioButton radio2 = new JRadioButton("Краткая статистика");
        radio1.setFont(font2);
        radio2.setFont(font2);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);


        c.fill = GridBagConstraints.LINE_END;
        c.ipady = 0;
        c.weightx = 0.0;
        c.gridy = 1;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.LINE_END;
        pane.add(radio1, c);
        pane.add(radio2, c);



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