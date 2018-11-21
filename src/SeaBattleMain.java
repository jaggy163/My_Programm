import game_logic.SeaBattle;
import swing_logic.SeaBattleSwing;

import javax.swing.*;

public class SeaBattleMain {
    public static void main(String[] args) {
        final SeaBattle game = new SeaBattle();

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                SeaBattleSwing seaBattle = new SeaBattleSwing();
                seaBattle.addMenuBar();
                seaBattle.drawGameField(game.getPlayerField(), game.getComputerField());
                game.setSeaBattleSwing(seaBattle);

                // TODO по максимуму разделить игровую логику и Swing
            }
        });

        game.play();

    }
}
