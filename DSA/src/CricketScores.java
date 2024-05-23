public class CricketScores {

    public static void main(String[] args) {
        String[] inputScores = {"1", ".", "2", ".", "4", "3", "6", "W", "1", ".", "N", ".", "2", "1"};

        int[] scores = calculateScores(inputScores);

        System.out.println("P1 - " + scores[0]);
        System.out.println("P2 - " + scores[1]);
        System.out.println("Extras - " + scores[2]);
    }

    public static int[] calculateScores(String[] scores) {
        int p1Score = 0;
        int p2Score = 0;
        int extras = 0;
        boolean player1Turn = true;
        boolean player2Turn = true;
        

        for (String score : scores) {
            if (score.matches("\\d+")) { // Numeric score
                if (player1Turn) {
                    p1Score += Integer.parseInt(score);
                } else {
                    p2Score += Integer.parseInt(score);
                }
                if (Integer.parseInt(score) % 2 != 0 && player1Turn) {
                    // Switching player after each valid score
                    player1Turn = false;
                    player2Turn = true;
                }
                else if (Integer.parseInt(score) % 2 != 0 && player2Turn) {
                    player1Turn = true;
                    player2Turn = false;
                }
                
            } else if (score.equals("W") || score.equals("N")) { // Wide or No Ball
                extras++;
            }

        }

        return new int[]{p1Score, p2Score, extras};
    }
}
