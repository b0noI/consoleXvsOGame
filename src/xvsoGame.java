import java.io.*;


public class xvsoGame {
    public static void main(String[] args) {
        System.out.println("X vs. O console game");

        Player player1 = new Player();
        Player player2 = new Player();
        gameArea game = new gameArea();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter board size: ");
            game.setBoardSize(Integer.parseInt(br.readLine()));
        } catch (Exception ex) {
            System.out.println("Error input");
            System.out.println(ex.getMessage());
        }

        System.out.println(game.toString());

        do {
            // Change player
            gameArea.firstPlayer = !gameArea.firstPlayer;
            int x, y;
            if (gameArea.firstPlayer) {
                System.out.println("First player move:");
            } else {
                System.out.println("Second player move:");
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
                        continue;
                    } else
                        break;
                } catch (Exception ex) {
                    System.out.println("Error input. Try again.");
                    continue;
                }
            }
            System.out.println(game.toString());
        } while (game.getResult() != gameArea.GAME_RUN);



//        try {
//            System.out.print("First player name: ");
//            player1.setName(br.readLine());
//            System.out.println(player1.toString());
//        } catch (Exception ex) {
//            System.out.println("Error input");
//        }
//
//        try {
//            System.out.print("Second player name: ");
//            player2.setName(br.readLine());
//            System.out.println(player2.toString());
//        } catch (Exception ex) {
//            System.out.println("Error input");
//        }
//
//
//        player1.Move();

    }
}
