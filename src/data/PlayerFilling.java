package data;

import com.example.Statistics;
import data.FCKSPlayer;

import java.io.IOException;
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
            Statistics stats = new Statistics();
            player.setName(allPlayersMap.get(id));
            player.setAge(ParsedInfo.parsedAge(id));
            player.setHeight(ParsedInfo.parsedHeight(id));
            player.setNumber(ParsedInfo.parsedShirtNo(id));
            player.setWeight(ParsedInfo.parsedWeight(id));
            player.setPos(ParsedInfo.parsedPosition(id));
            stats.setRating(ParsedInfo.parsedRatings(id));
            stats.setTotalPasses(ParsedInfo.parsedPassesTotal(id));
            stats.setAccuratePasses(ParsedInfo.parsedPassesAccurate(id));
            stats.setPassAccuracy(ParsedInfo.parsedPassesAccurate(id) / ParsedInfo.parsedPassesTotal(id));
            stats.setKeyPasses(ParsedInfo.parsedPassesKey(id));
            stats.setShotsTotal(ParsedInfo.parsedShotsTotal(id));
            stats.setShotsOnTarget(ParsedInfo.parsedShotsOnTarget(id));
            stats.setShotsOffTarget(ParsedInfo.parsedShotsOffTarget(id));
            stats.setShotsBlocked(ParsedInfo.parsedShotsTotal(id) -
                    ParsedInfo.parsedShotsOnTarget(id) - ParsedInfo.parsedShotsOffTarget(id));
            stats.setShotsAccuracy(ParsedInfo.parsedShotsOnTarget(id) / ParsedInfo.parsedShotsTotal(id));
            stats.setClearances(ParsedInfo.parsedClearances(id));
            stats.setInterceptions(ParsedInfo.parsedInterseptions(id));
            stats.setArialsTotal(ParsedInfo.parsedArialsTotal(id));
            stats.setArialsWon(ParsedInfo.parsedArialsWon(id));
            stats.setArialsSuccesfullPersent(ParsedInfo.parsedArialsWon(id) / ParsedInfo.parsedArialsTotal(id));
            stats.setTacklesTry(ParsedInfo.parsedTacklesTotal(id));
            stats.setTacklesWon(ParsedInfo.parsedTacklesSuccessful(id));
            stats.setTacklesSuccesfullPersent(ParsedInfo.parsedTacklesSuccessful(id) / ParsedInfo.parsedTacklesTotal(id));
            stats.setDribblesTotal(ParsedInfo.parsedDribblesTotal(id));
            stats.setDribblesWon(ParsedInfo.parsedDribblesTotal(id) - ParsedInfo.parsedDribblesLost(id));
            stats.setDribblesSuccesfullPersent(stats.getDribblesWon() / ParsedInfo.parsedDribblesTotal(id));
            player.setStatistics(stats);
            data.put(squad[i], player);
        }
        return data;
    }
}
