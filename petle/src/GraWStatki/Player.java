package GraWStatki;

public class Player {
    private String name;
    private int[][] ownBoard = new int[5][5];
    private int[][] enemyBoard = new int[5][5];

    public Player(String name) {
        this.name = name;
    }

    public void printOwnBoard(){
        printBoard(this.ownBoard);
    }

    public void printEnemyBoard(){
        printBoard(this.enemyBoard);
    }

    private void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if(i == 0){
                System.out.println("  1 2 3 4 5");
            }
            System.out.print((i + 1) + " ");

            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void setOwnBoard(int coordinateY, int coordinateX){
        this.ownBoard[coordinateY - 1][coordinateX - 1] = 1;
    }

    public void setEnemyBoard(int coordinateY, int coordinateX){
        this.enemyBoard[coordinateY - 1][coordinateX - 1] = 1;
    }

    public String getName() {
        return name;
    }

    public int[][] getOwnBoard() {
        return ownBoard;
    }

    public int[][] getEnemyBoard() {
        return enemyBoard;
    }
}
