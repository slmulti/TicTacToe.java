import java.util.Scanner;

public class TicTacToe {

    private Scanner scanner = new Scanner(System.in);
    private int[] board = {1,2,3,4,5,6,7,8,9};
    private int player = 10;
    private int nextPlayer(){
        return player == 10 ? 0:10;
    }
    private boolean checkPlay(int index){
        return (index > -1 && index <9) && (board[index] != 0 && board[index] !=10);
    }

    private boolean haveWinner(){
        boolean win = false;
        int [][] combos ={
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {2,4,6},
                {0,4,8}
        };
        for (int[] combo :combos){
            if (board[combo[0]] == 0 && board[combo[1]] == 0 && board[combo[2]] == 0){
                win = true;
            } else if (board[combo[0]] == 10 && board[combo[1]] == 10 && board[combo[2]] == 10) {
                win = true;
            }
        }
        return win;
    }

    private boolean haveDraw(){
        boolean draw = true;
        for (int sq : board) {
            if(sq > 0 && sq < 10){
                draw = false;
            }
        }
        return draw;
    }
    private void play(int index){
        if (checkPlay(index)){
            board[index] = player;
            if (haveWinner()){
                System.out.printf("Game Over! %s wins!!", player == 0 ? "O's" : "X's");
            } else if (haveDraw()) {
                System.out.println("Game Over, DRAW, No Winners!!");
            }else {
                player = nextPlayer();
                printBoard();
                getUserInput();
            }
        }else{
            System.out.println("invalid move - try again");
        }

    }
    private char displaySq(int sq){
        if(sq == 10){
            return 'X';
        }else if(sq == 0){
            return 'O';
        } else {
            return (char)  Character.forDigit(sq,10);
        }
    }
    private void printBoard(){
        System.out.printf("%c|%c|%c\n", displaySq(board[0]), displaySq(board[1]),displaySq(board[2]));
        System.out.printf("%c|%c|%c\n", displaySq(board[3]), displaySq(board[4]),displaySq(board[5]));
        System.out.printf("%c|%c|%c\n", displaySq(board[6]), displaySq(board[7]),displaySq(board[8]));
    }
    private void getUserInput(){
        int input = scanner.nextInt();
        play(input-1);
    }
    TicTacToe(){
        printBoard();
        getUserInput();
    }
    public static void main(String[] args) {
        new TicTacToe();
    }

}
