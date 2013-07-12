public class gameArea {
    public enum State{ Blank, X, O };

    private final int minSize = 3;
    private final int maxSize = 20;
    private int boardSize;
    public void setBoardSize(int size) {
        if (size >= minSize && size <= maxSize ){
            boardSize = size;

            board = new State[boardSize][boardSize];
            for (int i = 0; i < boardSize; i++)
                for (int j = 0; j < boardSize; j++)
                    board[i][j] = State.Blank;
        }
    }
    private int moveCount = 0;

    State[][] board;

    public String toString() {
        String temp = "";
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    if (board[i][j] == State.Blank) {
                        temp = temp + "_ ";
                    } else {
                        temp = temp + board[i][j] + " ";
                    }
                }
                temp += "\n";
            }

        return temp;
    }

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
