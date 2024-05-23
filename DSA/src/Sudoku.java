import java.util.Scanner;

public class Sudoku {
    private final int[][] board;
    private static final int SIZE = 9;
    private static final int SUBGRID_SIZE = 3;
    private static final int EMPTY = 0;

    public Sudoku() {
        board = new int[SIZE][SIZE];
        initializeBoard();
        generateBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private void generateBoard() {
        solve(0, 0);
        removeCells();
    }

    private boolean solve(int row, int col) {
        if (row == SIZE) {
            row = 0;
            if (++col == SIZE) {
                return true;
            }
        }

        if (board[row][col] != EMPTY) {
            return solve(row + 1, col);
        }

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < SIZE; i++) {
            int temp = nums[i];
            nums[i] = nums[row];
            nums[row] = temp;

            if (isValid(row, col, nums[row])) {
                board[row][col] = nums[row];
                if (solve(row + 1, col)) {
                    return true;
                }
                board[row][col] = EMPTY;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                    board[row - row % SUBGRID_SIZE + i / SUBGRID_SIZE][col - col % SUBGRID_SIZE + i % SUBGRID_SIZE] == num) {
                return false;
            }
        }
        return true;
    }

    private void removeCells() {
        final int NUM_EMPTY_CELLS = 40;
        for (int i = 0; i < NUM_EMPTY_CELLS; i++) {
            int row = (int) (Math.random() * SIZE);
            int col = (int) (Math.random() * SIZE);
            if (board[row][col] != EMPTY) {
                board[row][col] = EMPTY;
            } else {
                i--;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            if (i % SUBGRID_SIZE == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < SIZE; j++) {
                if (j % SUBGRID_SIZE == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] == EMPTY ? " " : board[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidMove(int row, int col, int num) {
        return board[row][col] == EMPTY && isValid(row, col, num);
    }

    public void makeMove(int row, int col, int num) {
        board[row][col] = num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sudoku sudoku = new Sudoku();

        while (!sudoku.isBoardFull()) {
            System.out.println("Current Sudoku Board:");
            sudoku.printBoard();
            System.out.println("Enter row, column, and number (1-9) separated by space (e.g., '3 5 7'): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            int num = scanner.nextInt();

            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || num < 1 || num > 9) {
                System.out.println("Invalid input! Please enter row, column, and number within the range.");
                continue;
            }

            if (!sudoku.isValidMove(row, col, num)) {
                System.out.println("Invalid move! Please enter a valid move.");
                continue;
            }

            sudoku.makeMove(row, col, num);
        }

        System.out.println("Congratulations! You solved the Sudoku!");
        sudoku.printBoard();
        scanner.close();
    }
}
