import java.util.Scanner;

public class Board {
    private char[] [] tabella = new char[5][5];
    Scanner keyboard = new Scanner(System.in);

    /**costruttore*/
    public Board(){
        for(int i=0;i<5;i++)                                                           //riempio tabella con spazi vuoti
            for(int j=0;j<5;j++)
                tabella[i] [j] = ' ';
        tabella[0] [1] = '|';                                                                          //disegno tabella
        tabella[0] [3] = '|';
        tabella[1] [0] = '-';
        tabella[1] [1] = '+';
        tabella[1] [2] = '-';
        tabella[1] [3] = '+';
        tabella[1] [4] = '-';
        tabella[2] [1] = '|';
        tabella[2] [3] = '|';
        tabella[3] [0] = '-';
        tabella[3] [1] = '+';
        tabella[3] [2] = '-';
        tabella[3] [3] = '+';
        tabella[3] [4] = '-';
        tabella[4] [1] = '|';
        tabella[4] [3] = '|';
    }

    /**stampa tabella*/
    public void printBoard(){
        for(int i=0;i<5;i++) {
            System.out.println();
            for (int j = 0; j < 5; j++)
                System.out.print(tabella[i][j]);
        }
        System.out.println();
    }

    /**leggi riga*/
    public int readRow(int pos){
        int row = -1;
        if(pos == 1 || pos == 2 || pos == 3)
            row = 0;
        else if(pos == 4 || pos == 5 || pos == 6)
            row = 2;
        else if(pos == 7 || pos == 8 || pos ==9)
            row = 4;
        return row;
    }

    /**leggi colonna*/
    public int readColumn(int pos){
        int column = -1;
        if(pos == 1 || pos == 4 || pos ==7)
            column = 0;
        else if(pos == 2 || pos == 5 || pos == 8)
            column = 2;
        else if(pos == 3 || pos == 6 || pos == 9)
            column = 4;
        return column;
    }

    /**controllo posto disponibile*/
    public boolean control(int pos){
        return (tabella[readRow(pos)] [readColumn(pos)] == ' ');
    }

    /**aggiungi simbolo*/
    public void addSymbol(char symbol){
        int pos;
        do {
            pos = getPos();
        }while(!control(pos));
        tabella[readRow(pos)]  [readColumn(pos)] = symbol;
    }

    public void addSymbolPC(char symbol){
        int pos;
        do {
            pos = getPosPC();
        }while(!control(pos));
        tabella[readRow(pos)]  [readColumn(pos)] = symbol;
    }

    /**controlla vincitore*/
    public boolean checkWinner(char symbol) {
        return (tabella[0][0] == symbol && tabella[0][2] == symbol && tabella[0][4] == symbol) ||           //prima riga
                (tabella[2][0] == symbol && tabella[2][2] == symbol && tabella[2][4] == symbol) ||        //seconda riga
                (tabella[4][0] == symbol && tabella[4][2] == symbol && tabella[4][4] == symbol) ||          //terza riga
                (tabella[0][0] == symbol && tabella[2][0] == symbol && tabella[4][0] == symbol) ||       //prima colonna
                (tabella[0][2] == symbol && tabella[2][2] == symbol && tabella[4][2] == symbol) ||     //seconda colonna
                (tabella[0][4] == symbol && tabella[2][4] == symbol && tabella[4][4] == symbol) ||       //terza colonna
                (tabella[0][0] == symbol && tabella[2][2] == symbol && tabella[4][4] == symbol) ||     //prima diagonale
                (tabella[0][4] == symbol && tabella[2][2] == symbol && tabella[4][0] == symbol);     //seconda diagonale
    }

    /**prendi posizione*/
    public int getPos(){
        int pos;
        do {
            pos = keyboard.nextInt();
        }while(pos<1 || pos >9);
        return pos;
    }

    public int getPosPC(){
        int pos;
        do {
            pos = (int) (Math.random()*10);
            //System.out.println(pos);
        }while(pos<1 || pos >9);

        return pos;
    }

}
