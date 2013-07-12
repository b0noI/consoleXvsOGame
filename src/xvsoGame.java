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
