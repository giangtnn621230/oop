// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
        int minRow = grid.length, maxRow = -1;
        int minCol = grid[0].length, maxCol = -1;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == ch) {
                    if (r < minRow) minRow = r;
                    if (r > maxRow) maxRow = r;
                    if (c < minCol) minCol = c;
                    if (c > maxCol) maxCol = c;
                }
            }
        }

        if (maxRow == -1) return 0;
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
    public int countPlus() {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                char ch = grid[r][c];
                if (isPlusCenter(r, c, ch)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPlusCenter(int r, int c, char ch) {
        int up = countDirection(r, c, -1, 0, ch);
        int down = countDirection(r, c, 1, 0, ch);
        int left = countDirection(r, c, 0, -1, ch);
        int right = countDirection(r, c, 0, 1, ch);
        return up >= 2 && up == down && up == left && up == right;
    }

    private int countDirection(int r, int c, int dr, int dc, char ch) {
        int len = 0;
        int row = r + dr, col = c + dc;
        while (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                && grid[row][col] == ch) {
            len++;
            row += dr;
            col += dc;
        }
        return len;
    }
}
