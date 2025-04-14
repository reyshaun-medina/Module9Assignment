package FPSMultiplayer;

public class Match {
    public static void main(String[] args) {
        Team team1 = new Team();
        Team team2 = new Team();
        Player player = new Player();

        System.out.println("\n[Matchmaking team 1]");
        System.out.print("--------------------");

        Player[] team1Array = {
                new Sniper("MeowingKitten123"),
                new Sniper("SparkyDog212"),
                new Assault("ToyStory595"),
                new Heavy("PiggyBank345"),
                new Assault("DoritosFan234"),
                new Heavy("xDoubleStuffedOreosx")
        };

        team1.initTeam(team1Array);

        System.out.println("\n[Matchmaking team 2]");
        System.out.print("--------------------");

        Player[] team2Array = {
                new Sniper("DuckDuckGoose543"),
                new Assault("VeganVegoBears220"),
                new Sniper("WavyChips235"),
                new Assault("Lufthansa747Lover"),
                new Heavy("Max9PlugDoor"),
                new Assault("SpongebobSquarepants")
        };

        team2.initTeam(team2Array);
        player.closeScanner();

        System.out.println("\n[Team players]");
        System.out.println("--------------");

        System.out.println("[Team 1]");
        team1.printTeamMatchmaking();

        System.out.println("\n[Team 2]");
        team2.printTeamMatchmaking();

        System.out.println("\n[TEAM ELIMINATION MATCH BEGINS]");
        System.out.println("-------------------------------");

        System.out.printf("Moving %s forward: %s%n", team1.getPlayer(0).getUsername(),
                team1.getPlayer(0).moveForward());
        team1.getPlayer(0).attack(team2.getPlayer(0));
        System.out.println();
        team1.getPlayer(0).reload();
        System.out.println();
        team1.getPlayer(0).meleeAttack(team2.getPlayer(0));
        System.out.println();
        team2.getPlayer(3).attack(team1.getPlayer(0));
        System.out.println();
        team2.getPlayer(3).attack(team1.getPlayer(0));
        System.out.println();
        team2.getPlayer(3).attack(team1.getPlayer(0));
        System.out.println();
        team2.getPlayer(3).attack(team1.getPlayer(0));

        System.out.println("\n[MATCH ENDS]");
        System.out.println("------------");

        team1.calculateScore();
        System.out.println("Team 1 Total Score: " + team1.getTotalScore());
        
        team2.calculateScore();
        System.out.println("Team 2 Total Score: " + team2.getTotalScore());
    }
}
