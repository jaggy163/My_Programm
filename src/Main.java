import com.example.Football;
import data.FCKSPlayer;
import data.PlayerFilling;
import data.PlayersReport;
import swing.ScreenSwing;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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
        for (int i=0; i<squad.length; i++) {
            PlayersReport.report(data.get(squad[i]));
        }


        try {
            JAXBContext context = JAXBContext.newInstance(Football.class);
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
