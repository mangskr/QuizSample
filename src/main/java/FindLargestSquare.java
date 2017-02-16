/**
 * Created by mangs on 17. 2. 16.

 [가장큰 정사각형 찾기]

 O와 X로 채워진 표가 있습니다.
 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
 표에서 O로 이루어진 가장 큰 정사각형을 찾아 넓이를 반환하는 findLargestSquare 함수를 완성하세요.

 예를 들어 가 있다면
 1 2 3 4 5
 X O O O X
 X O O O O
 X X O O O
 X X O O O
 X X X X X

 정답은 a로 둘러싸인 정사각형이 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.
 1 2 3 4 5
 X O O O X
 X O a a a
 X X a a a
 X X a a a
 X X X X X
 */
public class FindLargestSquare {
    public int findLargestSquare(char [][]board) {

        int maxSquareSize = 0;
        int maxSquareStartRowPoint = 0;
        int maxSquareStartColumnPoint = 0;

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {

                int squareSize = 1;

                while (isSquare(row, column, squareSize, board)) {
                    squareSize++;
                }

                if (squareSize > maxSquareSize) {
                    maxSquareStartRowPoint = row;
                    maxSquareStartColumnPoint = column;
                    maxSquareSize = squareSize;
                }
            }
        }

        System.out.println("The first largest sub-square is located at (" + maxSquareStartRowPoint
                + ", " + maxSquareStartColumnPoint + ") and is of size " + maxSquareSize);

        if(maxSquareStartRowPoint == 0 && maxSquareStartColumnPoint == 0 && maxSquareSize <= 1) {
            return 0;
        }
        else {
            return (maxSquareSize) * (maxSquareSize);
        }
    }

    //사격형인지 체크
    public static boolean isSquare(int row, int column, int squareSize, char[][] board) {
        int size = squareSize + 1;

        if (row + size - 1 >= board.length || column + size - 1 >= board.length)
            return false;

        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (board[i][j] != 'O')
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        FindLargestSquare largestSquare = new FindLargestSquare();

        char [][]board ={
                {'O','O','X','X','X'},
                {'O','O','X','X','X'},
                {'X','X','O','O','O'},
                {'X','X','O','O','O'},
                {'X','X','O','O','O'}
        };

        System.out.println("가장큰 사가경의 넓이 : "
                + largestSquare.findLargestSquare(board));
    }
}
