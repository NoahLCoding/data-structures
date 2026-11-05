import java.util.Stack;

public class Grid {
    private static final int SIZE = 10;
    private int[][] pixels;

    public Grid() {
        pixels = new int[SIZE][SIZE];
    }

    public void floodfill(int startRow, int startCol) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(startRow, startCol));

        int count = 1;

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            int r = p.getRow();
            int c = p.getCol();

            if (pixels[r][c] == 0) {
                pixels[r][c] = count++;

               
                if (r > 0 && pixels[r - 1][c] == 0) {
                    stack.push(new Pair(r - 1, c)); // North
                }
                if (c < SIZE - 1 && pixels[r][c + 1] == 0) {
                    stack.push(new Pair(r, c + 1)); // East
                }
                if (r < SIZE - 1 && pixels[r + 1][c] == 0) {
                    stack.push(new Pair(r + 1, c)); // South
                }
                if (c > 0 && pixels[r][c - 1] == 0) {
                    stack.push(new Pair(r, c - 1)); // West
                }
            }
        }
    }
    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
