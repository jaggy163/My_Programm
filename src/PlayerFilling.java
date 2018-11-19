import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerFilling {
    public static HashMap<Integer, FCKSPlayer> fill() throws IOException {
        ParsedInfo info = new ParsedInfo("D:\\Football\\UFA-KS.txt");
        HashMap<Integer, String> allPlayersMap = info.allPlayers();
        int[] squad = info.squad();
        HashMap<Integer, FCKSPlayer> data = new HashMap<>();

        for (int i=0; i<squad.length; i++) {
            FCKSPlayer player = new FCKSPlayer();
            int id = squad[i];
            player.setName(allPlayersMap.get(id));
            player.setAge(ParsedInfo.parsedAge(id));
            player.setHeight(ParsedInfo.parsedHeight(id));
            player.setShirtNo(ParsedInfo.parsedShirtNo(id));
            player.setWeight(ParsedInfo.parsedWeight(id));
            player.setPosition(ParsedInfo.parsedPosition(id));
            player.setRatings(ParsedInfo.parsedRatings(id));
            player.setPassesTotal(ParsedInfo.parsedPassesTotal(id));
            player.setPassesAccurate(ParsedInfo.parsedPassesAccurate(id));
            player.setPassesKey(ParsedInfo.parsedPassesKey(id));
            data.put(squad[i], player);
        }
        return data;
    }
}
