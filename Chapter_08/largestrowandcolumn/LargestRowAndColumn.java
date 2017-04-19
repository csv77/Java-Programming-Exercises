package largestrowandcolumn;

public class LargestRowAndColumn {

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        initMatrix(matrix);
        displayMatrix(matrix);
        System.out.println("The largest row index: " + largestRow(matrix));
        System.out.println("The largest column index: " + largestColumn(matrix));
    }
    
    public static int largestRow(int[][] m){
        int largestRow = 0;
        int largestRowIndex = 0;
        for(int i = 0; i < m.length; i++){
            int row = 0;
            for(int j = 0; j < m[i].length; j++){
                if(m[i][j] == 1){
                    row++;
                }
            }
            if(row > largestRow){
                largestRow = row;
                largestRowIndex = i;
            }
        }
        return largestRowIndex;
    }
    
    public static int largestColumn(int[][] m){
        int largestColumn = 0;
        int largestColumnIndex = 0;
        for(int i = 0; i < m[0].length; i++){
            int column = 0;
            for(int j = 0; j < m.length; j++){
                if(m[j][i] == 1){
                    column++;
                }
            }
            if(column > largestColumn){
                largestColumn = column;
                largestColumnIndex = i;
            }
        }
        return largestColumnIndex;
    }
    
    public static void initMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                m[i][j] = (int)(Math.random() * 2);
            }
        }
    }
    
    public static void displayMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
    
}
