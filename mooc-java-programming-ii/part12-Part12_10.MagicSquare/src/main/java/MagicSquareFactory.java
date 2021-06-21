
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        int row = 0;
        int col = size / 2;
        int current = 1;
        
        while (current <= size * size) {
            square.placeValue(col, row, current);
            current++;                       
            
            row--;            
            if (row < 0) {
                row = size - 1;
            }
            
            col++;
            if (col == size) {
                col = 0;
            }
            
            if (square.readValue(col, row) != 0) {
                if (row + 2 >= size) {
                    row = 1;
                    col = size - 1;
                } else {
                    row += 2;
                    col--;
                }
            }
        }
        
        return square;
    }

}
