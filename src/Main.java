import data.FCKSPlayer;
import data.PlayerFilling;
import swing.ScreenSwing;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
//        data.ParsedInfo info = new data.ParsedInfo("D:\\Football\\UFA-KS.txt");
//        HashMap<Integer, String> allPlayersMap = info.allPlayers();
       // String player = allPlayersMap.get(360935);
//        System.out.println(allPlayersMap);
//        int[] squad = info.squad();
//        System.out.println();
//        System.out.println("Основной состав Крыльев Советов:");
//        for (int i=0; i<squad.length; i++) {
//            System.out.println(i+1 + ": " + allPlayersMap.get(squad[i]));

        HashMap<Integer, FCKSPlayer> data = PlayerFilling.fill();
        data.ParsedInfo info = new data.ParsedInfo("D:\\Football\\UFA-KS.txt");
        int[] squad = info.squad();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScreenSwing screen = new ScreenSwing(data, squad);
            }
        });

    }
}
