package swing;

import data.FCKSPlayer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ChoiceComponent extends JComponent {
    public ChoiceComponent(HashMap<Integer, FCKSPlayer> data, int[] squad) {
        Font font = new Font("Verdana", Font.PLAIN, 24);
        Font font2 = new Font("Verdana", Font.PLAIN, 14);
        String[] names = new String[squad.length];
        for (int index=0; index<squad.length; index++) {
            names[index] = (data.get(squad[index]).getPos() + " : " + data.get(squad[index]).getName());
        }
        JComboBox comboBox;
        GridBagConstraints c = new GridBagConstraints();
        setSize(120, 100);
        setVisible(true);

        comboBox = new JComboBox(names);
        comboBox.setFont(font);
        add(comboBox);

        JRadioButton radio1 = new JRadioButton("Полная статистика");
        JRadioButton radio2 = new JRadioButton("Краткая статистика");
        radio1.setFont(font2);
        radio2.setFont(font2);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radio1);
        radioGroup.add(radio2);

        add(radio1);
        add(radio2);
    }
}
