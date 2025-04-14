package FPSMultiplayer;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private List<Player> players = new ArrayList<>(6);
    private int totalScore = 0;

    public void initTeam(Player[] players) {
        this.players = Arrays.asList(players);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public void printTeamMatchmaking() {
        int counter = 1;

        for (Player teamMember : players) {
            System.out.println(counter + ": " + teamMember.getUsername());
            counter++;
        }
    }

    public void calculateScore() {
        for (Player player : players) {
            totalScore += player.score;
        }
    }

    public int getTotalScore() {
        return totalScore;
    }
}
