public class gameArea {
    public static final int GAME_WIN = 1;
    public static final int GAME_DRAW = 0;
    public static final int GAME_RUN = -1;
    public static final int FAILED_MOVE = -2;
    private final int minBoardSize = 3;
    private final int maxBoardSize = 20;

    public static boolean firstPlayer = false;
    private State[][] board;
    private int moveCount = 0;
    private int boardSize;
    private int result;
    public enum State{ Blank, X, O }
    public int getResult() {
        return result;
    }
    public boolean setBoardSize(int size) {
        if (size >= minBoardSize && size <= maxBoardSize){
            boardSize = size;

            board = new State[boardSize][boardSize];
            for (int i = 0; i < boardSize; i++)
                for (int j = 0; j < boardSize; j++)
                    board[i][j] = State.Blank;

            return true;
        } else {
            return false;
        }

    }
    public void move(int x, int y, State state) {
        if (board[x][y] == State.Blank) {
            board[x][y] = state;
        } else {
            result = FAILED_MOVE;
            return;
        }
        moveCount++;

        // check col
        for (int i = 0; i < boardSize; i++) {
            if (board[x][i] != state) {
                break;
            } else {
                if (i == (boardSize - 1)) {
                    result = GAME_WIN;
                    return;
                }
            }
        }

        // check raw
        for (int i = 0; i < boardSize; i++) {
            if (board[i][y] != state) {
                break;
            } else {
                if (i == (boardSize - 1)) {
                    result = GAME_WIN;
                    return;
                }
            }
        }

        // check diagonal  - >
        if (x == y) {
            for (int i = 0; i < boardSize; i++) {
                if (board[i][i] != state) {
                    break;
                } else if (i == (boardSize - 1)) {
                    result = GAME_WIN;
                    return;
                }
            }
        }
        // Check diagonal -<
        for (int i = 0; i < boardSize; i++) {
            if (board[boardSize - 1 - i][i] != state) {
                break;
            } else if (i == (boardSize - 1)) {
                result = GAME_WIN;
                return;
            }
        }

        // draw result
        if (moveCount < (boardSize * boardSize)) {
            result = GAME_RUN;
        } else {
            result = GAME_DRAW;
        }
    }
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
}
