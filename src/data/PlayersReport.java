package data;

import com.example.Statistics;
import data.FCKSPlayer;

public class PlayersReport {
    public static void report(FCKSPlayer player) {
        Statistics stats = player.getStatistics();
        System.out.println();
        System.out.println("Отчет по игроку " + player.getName() + ":");
        System.out.println("Возраст: " + player.getAge() + " лет");
        System.out.println("Рост: " + player.getHeight() + " см");
        System.out.println("Вес: " + player.getWeight() + " кг");
        System.out.println("Позиция: " + player.getPos() + "");
        System.out.println("Выступает под " + player.getNumber() + " номером");
        System.out.println("Статистика игрока в матче с Уфой, 5 ноября 2018 года:");
        System.out.println("Рейтинг согласно сайту www.data.Whoscored.com : " + stats.getRating());
        System.out.println("Всего передач : " + (int)stats.getTotalPasses());
        System.out.println("Точных передач : " + (int)stats.getAccuratePasses());
        System.out.println("Тосность передач : " + (int)(100*stats.getPassAccuracy()) + "%");
        System.out.println("Ключевых передач : " + (int)stats.getKeyPasses());
        System.out.println("Нанесено всего ударов : " + (int)stats.getShotsTotal());
        System.out.println("Ударов в створ : " + (int)stats.getShotsOnTarget());
        System.out.println("Ударов мимо ворот : " + (int)stats.getShotsOffTarget());
        System.out.println("Ударов заблокировано : " + (int)stats.getShotsBlocked());
        System.out.println("Точность ударов : " + (int) (100*stats.getShotsAccuracy()) + "%");
        System.out.println("Всего выносов : " + (int)stats.getClearances());
        System.out.println("Всего перехватов : " + (int)stats.getInterceptions());
        System.out.println("Всего верховых единоборств : " + (int)stats.getArialsTotal());
        System.out.println("Выиграно верховых единоборств : " + (int)stats.getArialsWon());
        System.out.println("Процент выигранных верховых единоорств : " + (int)(100*stats.getArialsSuccesfullPersent()) + "%");
        System.out.println("Попыток отбора : " + (int)stats.getTacklesTry());
        System.out.println("Успешных отборов : " + (int)stats.getTacklesWon());
        System.out.println("Процент успешных отборов : " + (int)(100*stats.getTacklesSuccesfullPersent()));
        System.out.println("Попыток обводок : " + (int)stats.getDribblesTotal());
        System.out.println("Успешных обводок : " + (int)stats.getDribblesWon());
        System.out.println("Процент успешных обводок : " + (int)(100*stats.getDribblesSuccesfullPersent()) + "%");

//        System.out.println();
    }
}
