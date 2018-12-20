import com.example.Football;
import data.FCKSPlayer;
import data.Marshal;
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
        Football football = new Football();
        HashMap<Integer, FCKSPlayer> data = PlayerFilling.fill();
        data.ParsedInfo info = new data.ParsedInfo("D:\\Football\\UFA-KS.txt");
        int[] squad = info.squad();
        for (int i=0; i<squad.length; i++) {
            football.add(data.get(squad[i]));
            PlayersReport.report(data.get(squad[i]));
        }

        Marshal.doMarshal(football);
    }
}
