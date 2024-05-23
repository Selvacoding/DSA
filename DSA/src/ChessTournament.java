import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Define a Player class
class Player {
    private final String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score++;
    }
}

// Define a Match class to represent a single game between two players
class Match {
    private final Player player1;
    private final Player player2;
    private Player winner;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return player1.getName() + " vs " + player2.getName() + ": Winner - " +
                (winner != null ? winner.getName() : "Tie");
    }
}

// Define a Tournament class to manage the matches and players
class Tournament {
    private final List<Player> players;
    private final List<Match> matches;
    private final Map<Player, Integer> scores;

    public Tournament() {
        players = new ArrayList<>();
        matches = new ArrayList<>();
        scores = new HashMap<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
        scores.put(player, 0); // Initialize score for each player
    }

    public void generateMatches() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                matches.add(new Match(players.get(i), players.get(j)));
            }
        }
    }

    public void playMatch(Match match, Player winner) {
        match.setWinner(winner);
        if (winner != null) {
            winner.increaseScore();
            scores.put(winner, scores.get(winner) + 1); // Update player's score
        }
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void displayMatches() {
        for (Match match : matches) {
            System.out.println(match);
        }
    }

    public void displayScores() {
        System.out.println("Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
}

public class ChessTournament {
    public static void main(String[] args) {
        // Create players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");

        // Create a tournament
        Tournament tournament = new Tournament();

        // Add players to the tournament
        tournament.addPlayer(player1);
        tournament.addPlayer(player2);
        tournament.addPlayer(player3);

        // Generate matches
        tournament.generateMatches();

        // Simulate match results
        tournament.playMatch(tournament.getMatches().get(0), player1); // Simulating player 1 wins match 1
        tournament.playMatch(tournament.getMatches().get(1), player2); // Simulating player 2 wins match 2
        tournament.playMatch(tournament.getMatches().get(2), null); // Simulating a tie in match 3

        // Display match results
        tournament.displayMatches();

        // Display scores
        tournament.displayScores();
    }
}
