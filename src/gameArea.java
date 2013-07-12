public class gameArea {
    public enum State{ Blank, X, O };

    private final int minSize = 3;
    private final int maxSize = 20;
    private int boardSize;
    public boolean setBoardSize(int size) {
        if (size >= minSize && size <= maxSize ){
            boardSize = size;
            return true;
        } else {
            return false;
        }
    }
    private int moveCount = 0;

    State[][] board = new State[boardSize][boardSize];

    public void Move(int x, int y, State state) {
        if (board[x][y] == State.Blank) {
            board[x][y] = state;
        } else {
            System.out.println("Not valid move");
            return;
        }
        moveCount++;

    }
}
