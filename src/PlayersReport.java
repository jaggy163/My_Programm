public class PlayersReport {
    public static void report(FCKSPlayer player) {
        System.out.println();
        System.out.println("Отчет по игроку " + player.getName() + ":");
        System.out.println("Возраст: " + player.getAge() + " лет");
        System.out.println("Рост: " + player.getHeight() + " см");
        System.out.println("Вес: " + player.getWeight() + " кг");
        System.out.println("Позиция: " + player.getPosition() + "");
        System.out.println("Выступает под " + player.getShirtNo() + " номером");
        System.out.println("Статистика игрока в матче с Уфой, 5 ноября 2018 года:");
        System.out.println("Рейтинг согласно сайту www.Whoscored.com : " + player.getRatings());
        System.out.println("Всего передач : " + (int)player.getPassesTotal());
        System.out.println("Точных передач : " + (int)player.getPassesAccurate());
        System.out.println("Тосность передач : " + (int)(100*(player.getPassesAccurate()/player.getPassesTotal())) + "%");
        System.out.println("Ключевых передач : " + (int)player.getPassesKey());
        System.out.println("Нанесено всего ударов : " + (int)player.getShotsTotal());
        System.out.println("Ударов в створ : " + (int)player.getShotsOnTarget());
        System.out.println("Ударов мимо ворот : " + (int)player.getShotsOffTarget());
        System.out.println("Ударов заблокировано : " + (int)(player.getShotsTotal()-player.getShotsOffTarget()-player.getShotsOnTarget()));
        System.out.println("Точность ударов : " + (int) (100*(player.getShotsOnTarget()/player.getShotsTotal())) + "%");
        System.out.println("Всего выносов : " + (int)player.getClearances());
        System.out.println("Всего перехватов : " + (int)player.getInterseptions());
        System.out.println("Всего верховых единоборств : " + (int)player.getArialsTotal());
        System.out.println("Выиграно верховых единоборств : " + (int)player.getArialsWon());
        System.out.println("Процент выигранных верховых единоорств : " + (int)(100*(player.getArialsWon()/player.getArialsTotal())) + "%");
        System.out.println("Попыток отбора : " + (int)player.getTacklesTotal());
        System.out.println("Успешных отборов : " + (int)player.getTacklesSuccessful());
        System.out.println("Процент успешных отборов : " + (int)(100*(player.getTacklesSuccessful()/player.getTacklesTotal())));
        System.out.println("Попыток обводок : " + (int)player.getDribblesTotal());
        System.out.println("Успешных обводок : " + (int)(player.getDribblesTotal() - player.getDribblesLost()));
        System.out.println("Процент успешных обводок : " + (int)(100 - 100*(player.getDribblesLost()/player.getDribblesTotal())) + "%");

//        System.out.println();
    }
}
