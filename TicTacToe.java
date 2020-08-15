import java.util.*;

public class ArrayLab2a
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        char ttt[][]= new char[3][3];
        int numOfTurns = 0;
        int num1 = 0;
        int num2 = 0;
        
        initBoard(ttt, '?');
        printBoard(ttt);
        System.out.println("Player 1 is O and Player 2 is X");
        getO(ttt);
        printBoard(ttt);
        while(numOfTurns < 8)
        {
           getX(ttt);
           printBoard(ttt);
           if(checkWinner(ttt) == true)
           {
            System.out.println("Player 2 Wins!");
            break;
           }
           numOfTurns++;
           getO(ttt);
           printBoard(ttt);
           if(checkWinner(ttt) == true)
            {
            System.out.println("Player 1 Wins!");
            break;
            }
           numOfTurns++;
        }
    }

    public static void initBoard(char[][] board, char symbol)
    {
        for(int row= 0; row < board.length; row++)
            for(int col = 0; col < board[row].length; col++)
            board[row][col] = symbol;
    }

    public static void printBoard(char[][] board)
    {
        for(int row= 0; row < board.length; row++)
        {
            for(int col = 0; col < board[row].length; col++)
                System.out.print(board[row][col] + " ");
            System.out.println();
        }
    }

    public static void getO(char[][] board)
    {
        Scanner input = new Scanner(System.in);
        int num1;
        int num2;
        
        System.out.println("Which row and column would you like to place your marker?");
        num1 = input.nextInt();
        num2 = input.nextInt();

        boolean spotAvailability = checkSpot(board, num1, num2);
        
        if(spotAvailability == true)
            board[num1][num2]='O';
        else 
        {
            System.out.println("Spot is taken");
            printBoard(board);
            getO(board);
        }
    }

    public static void getX(char[][]board)
    {
        Scanner input = new Scanner(System.in);
        int num1;
        int num2;
        
        System.out.println("Which row and column would you like to place your marker?");
        num1 = input.nextInt();
        num2 = input.nextInt();

        boolean spotAvailability = checkSpot(board, num1, num2);
        
        if(spotAvailability == true)
            board[num1][num2]='X';
        else 
        {
            System.out.println("Spot is taken");
            printBoard(board);
            getX(board);
        }
    }

    public static boolean checkSpot(char[][] board, int num1, int num2)
    {
        if(board[num1][num2] == '?')
            return true;
        else
            return false;
            
    }

    public static boolean checkWinner(char[][] board)
    {
        //First row
        if((board[0][0] == 'X') && (board[0][1] == 'X') && (board[0][2] == 'X') || (board[0][0] == 'O') && (board[0][1] == 'O') && (board[0][2] == 'O'))
            return true;
        //Second row
        else if((board[1][0] == 'X') && (board[1][1] == 'X') && (board[1][2] == 'X') || (board[1][0] == 'O') && (board[1][1] == 'O') && (board[1][2] == 'O')) 
            return true;
        //Third row
        else if((board[2][0] == 'X') && (board[2][1] == 'X') && (board[2][2] == 'X') || (board[2][0] == 'O') && (board[2][1] == 'O') && (board[2][2] == 'O'))
            return true;
        //First column
        else if((board[0][0] == 'X') && (board[1][0] == 'X') && (board[2][0] == 'X') || (board[0][0] == 'O') && (board[1][0] == 'O') && (board[2][0] == 'O'))
            return true;
        //Second column
        else if((board[0][1] == 'X') && (board[1][1] == 'X') && (board[2][1] == 'X') || (board[0][1] == 'O') && (board[1][1] == 'O') && (board[2][1] == 'O'))
            return true;
        //Third column
        else if((board[2][0] == 'X') && (board[2][1] == 'X') && (board[2][2] == 'X') || (board[2][0] == 'O') && (board[2][1] == 'O') && (board[2][2] == 'O'))
            return true;
        //First slant
        else if((board[0][0] == 'X') && (board[1][1] == 'X') && (board[2][2] == 'X') || (board[0][0] == 'O') && (board[1][1] == 'O') && (board[2][2] == 'O'))
            return true;
        //Second slant
        else if((board[2][0] == 'X') && (board[1][1] == 'X') && (board[0][2] == 'X') || (board[2][0] == 'O') && (board[1][1] == 'O') && (board[0][2] == 'O'))
            return true;
        else
            return false;
    }
}
