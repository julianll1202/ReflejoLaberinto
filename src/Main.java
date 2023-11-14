import javax.swing.text.AbstractDocument;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        char [][] laberinto = {
                {'*','*','*','*','*','*','*'},
                {'*',' ',' ',' ',' ',' ','*'},
                {'*',' ','*',' ','*',' ','*'},
                {'*',' ','*','*','*',' ','*'},
                {'*',' ',' ',' ',' ',' ','*'},
                {'*','*','*','*','*','*','*'}
        };
        int [] ganar = {5,4};
        int [] inicio = {1,1};
        Laberinto maze = new Laberinto(laberinto,ganar,inicio, 7, 6);
        maze.verLaberinto();
        maze.solucionar();
//        Laberinto
/*
* [
* *,*,*,*,*,*,*
* *, , , , , ,
* *, ,*, ,*, ,*
* *, ,*,*,*, ,*
* *, , , , , ,*
* *,*,*,*,*,*,*
*
* Jugador: ↓↑→←
* */
    }
}