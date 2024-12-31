package GraWStatki;

import java.util.Arrays;
import java.util.Scanner;

public class Engine {
    Scanner scanner = new Scanner(System.in);
    Player player1 = new Player("Gracz 1");
    Player player2 = new Player("Gracz 2");

    public void setShips(){
        setShips(player1);
        setShips(player2);
    }

    private void setShips(Player player){
        System.out.println(player.getName() + " ustawia statki");
        for (int i = 0; i < 5; i++) {
            player.printOwnBoard();
            System.out.println("Podaj współrzędne statku " + (i + 1) + " z 5:");
            System.out.print("X: ");
            int coordinateX = scanner.nextInt();
            System.out.print("Y: ");
            int coordinateY = scanner.nextInt();
            player.setOwnBoard(coordinateY, coordinateX);
        }
        player.printOwnBoard();
    }

    public void attackPlayer1(){
        attack(player1, player2);
    }

    public void attackPlayer2(){
        attack(player2, player1);
    }

    private void attack(Player attacker, Player defender) {
        System.out.println(attacker.getName() + " atakuje");
        attacker.printEnemyBoard();
        System.out.println("Podaj współrzędne ataku:");
        System.out.print("X: ");
        int coordinateX = scanner.nextInt();
        System.out.print("Y: ");
        int coordinateY = scanner.nextInt();
        attacker.setEnemyBoard(coordinateY, coordinateX);
        isHit(attacker, defender, coordinateX, coordinateY);
    }

    private void isHit(Player attacker, Player defender, int coordinateX, int coordinateY){
        if(attacker.getEnemyBoard()[coordinateY - 1][coordinateX - 1] == defender.getOwnBoard()[coordinateY - 1][coordinateX - 1]){
            System.out.println("Trafiony!");
            return;
        }
        System.out.println("Pudło!");
    }

    public boolean isGameOver(){
        if(Arrays.deepEquals(player1.getEnemyBoard(), player2.getOwnBoard())){
            System.out.println(player1.getName() + " wygrał!");
            return true;
        }
        if(Arrays.deepEquals(player2.getEnemyBoard(), player1.getOwnBoard())){
            System.out.println(player2.getName() + " wygrał!");
            return true;
        }
        return false;
    }


}
