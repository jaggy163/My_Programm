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
//        System.out.println();
    }
}
