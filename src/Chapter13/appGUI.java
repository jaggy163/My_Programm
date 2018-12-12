package Chapter13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class appGUI extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private Dot dot;

    appGUI() {
        dot = new Dot(0, 0);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(dot);
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent evnt) {
        int key = evnt.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            if (dot.y > 0) {
                dot.y -= 1;
            }
        } else if (key == KeyEvent.VK_DOWN) {
            dot.y += 1;
        } else if (key == KeyEvent.VK_RIGHT) {
            dot.x += 1;
        } else if (key == KeyEvent.VK_LEFT) {
            if (dot.x > 0) {
                dot.x -= 1;
            }
        }
        repaint();
        revalidate();
    }

    @Override
    public void keyReleased(KeyEvent evnt) {
    }

    @Override
    public void keyTyped(KeyEvent evnt) {
    }

    private class Dot extends JPanel {
        int x, y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(x, y, 10, 10);
        }
    }

    public static void main(String[] args) {
        new appGUI();
    }

}