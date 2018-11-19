import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
//        ParsedInfo info = new ParsedInfo("D:\\Football\\UFA-KS.txt");
//        HashMap<Integer, String> allPlayersMap = info.allPlayers();
       // String player = allPlayersMap.get(360935);
//        System.out.println(allPlayersMap);
//        int[] squad = info.squad();
//        System.out.println();
//        System.out.println("Основной состав Крыльев Советов:");
//        for (int i=0; i<squad.length; i++) {
//            System.out.println(i+1 + ": " + allPlayersMap.get(squad[i]));

        HashMap<Integer, FCKSPlayer> data = PlayerFilling.fill();
        ParsedInfo info = new ParsedInfo("D:\\Football\\UFA-KS.txt");
        int[] squad = info.squad();
        for (int i=0; i<squad.length; i++) {
            FCKSPlayer player = data.get(squad[i]);
            PlayersReport.report(player);
        }
    }
}
