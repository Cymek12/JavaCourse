package GraWStatki;


public class Main {
    public static void main(String[] args) {

        Engine engine = new Engine();
        engine.setShips();

        while (true){
            engine.attackPlayer1();
            if(engine.isGameOver()){
                break;
            }

            engine.attackPlayer2();
            if(engine.isGameOver()){
                break;
            }
        }
    }
}
