//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
    public void clearRows() {
        int width = grid.length;
        int height = grid[0].length;
        boolean[][] newGrid = new boolean[width][height];
        int newY = 0;
        for (int y = 0; y < height; y++) {
            if (!isFullRow(y)) {
                for (int x = 0; x < width; x++) {
                    newGrid[x][newY] = grid[x][y];
                }
                newY++;
            }
        }
        grid = newGrid;
    }
    private boolean isFullRow(int y) {
        for (int x = 0; x < grid.length; x++) {
            if (!grid[x][y]) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
        return grid;
	}
}
