import java.io.*;


public class xvsoGame {
    public static void main(String[] args) {
        System.out.println("X vs. O console game.");

        gameArea game = new gameArea();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Enter board size: ");
                if (game.setBoardSize(Integer.parseInt(br.readLine()))) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Error input.");
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(game.toString());

        do {
            // Change player
            gameArea.firstPlayer = !gameArea.firstPlayer;
            int x, y;
            if (gameArea.firstPlayer) {
                System.out.println("First player move");
            } else {
                System.out.println("Second player move");
            }

            while (true) {
                try {
                    System.out.print(" enter col number:");
                    x = Integer.parseInt(br.readLine());
                    System.out.print(" enter raw number:");
                    y = Integer.parseInt(br.readLine());

                    if (gameArea.firstPlayer) {
                        game.move(x, y, gameArea.State.X);
                    } else {
                        game.move(x, y, gameArea.State.O);
                    }

                    if (game.getResult() == gameArea.FAILED_MOVE) {
                        System.out.println("Not valid move.");
                        continue;
                    } else
                        break;
                } catch (Exception ex) {
                    System.out.println("Error input. Try again.");
                    continue;
                }
            }
            System.out.println(game.toString());
        } while (game.getResult() == gameArea.GAME_RUN);

        if (game.getResult() == gameArea.GAME_DRAW) {
            System.out.println("Game over. Draw.");
        } else if (game.getResult() == gameArea.GAME_WIN) {
            String state = (gameArea.firstPlayer) ? "X." : "O.";
            System.out.println("Game over. Win " + state);
        }
    }
}
