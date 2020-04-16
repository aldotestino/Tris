import java.util.Scanner;

public class Tris {
    
    /**stampa messaggio di benvenuto*/
    public static void welcome(){
        System.out.println("========================");
        System.out.println("|| Benvenuto in TRIS! ||");
        System.out.println("========================");
        System.out.println("\nInserire PC come giocatore 2 per giocare contro il computer.");
    }
    
    /**main*/
    public static void main(String[] args) {
        boolean win=false;
        int i=1;
        Scanner keyboard = new Scanner(System.in);
        Board b = new Board();
        welcome();
        System.out.println("\nGiocatore 1: ");
        String player1 = keyboard.nextLine();
        System.out.println("\nGiocatore 2: ");
        String player2 = keyboard.nextLine();
        b.printBoard();
        while(i<10 && !win){
            if(i%2==0) {                                                                                   //giocatore 1
                System.out.println();
                if(player2.equals("PC")){
                    System.out.println("\n" + player2 + " inserisce poszione: ");
                    b.addSymbolPC('O');
                    b.printBoard();
                }else {
                    System.out.println("\n" + player2 + ", inserisci poszione: ");
                    b.addSymbol('O');
                    b.printBoard();
                }
                win = b.checkWinner('O');
                if (win)
                    System.out.println("\n" + player2 + " ha vinto la partita!");
            }
            else {                                                                                         //giocatore 2
                System.out.println("\n" + player1 + ", inserisci poszione: ");
                b.addSymbol('X');
                b.printBoard();
                win = b.checkWinner('X');
                if (win)
                    System.out.println("\n" + player1 + " ha vinto la partita!");
            }
            i++;
            }
        if(!win)                                                                                //condizione di pareggio
            System.out.println("\nPareggio!");
        }
}
