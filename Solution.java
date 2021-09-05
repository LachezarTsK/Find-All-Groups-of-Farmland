import java.util.List;
import java.util.ArrayList;

public class Solution {

    public int[][] findFarmland(int[][] land) {

        List<int[]> farmlandCoordinates = new ArrayList<>();

        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {

                if (isUnmappedFarmland(r, c, land)) {

                    int row = r;
                    while (row < land.length && land[row][c] == 1) {
                        row++;
                    }

                    int column = c;
                    while (column < land[0].length && land[r][column] == 1) {
                        column++;
                    }

                    farmlandCoordinates.add(new int[]{r, c, --row, --column});

                }
            }
        }
        return turnListWithFarmlandIntoArray(farmlandCoordinates);
    }

    public boolean isUnmappedFarmland(int r, int c, int[][] land) {
        return land[r][c] == 1 && (r - 1 < 0 || land[r - 1][c] == 0) && (c - 1 < 0 || land[r][c - 1] == 0);
    }

    public int[][] turnListWithFarmlandIntoArray(List<int[]> farmlandCoordinates) {

        if (farmlandCoordinates.isEmpty()) {
            return new int[][]{};
        }

        int[][] coordinatesFarmland = new int[farmlandCoordinates.size()][4];
        for (int i = 0; i < farmlandCoordinates.size(); i++) {
            coordinatesFarmland[i] = farmlandCoordinates.get(i);
        }

        return coordinatesFarmland;
    }
}
