import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L2022113454_19_Test {

    /**
     * @Test Purpose: 测试最小有效输入 - 1x1网格。
     * 输入为仅包含一个细胞的网格，活细胞或死细胞的情况。
     * 这测试了最小尺寸的有效输入。
     */
    @Test
    public void testSingleCell() {
        // 活细胞，周围没有其他细胞，应死亡
        int[][] board1 = {{1}};
        Solution19 game = new Solution19();
        game.gameOfLife(board1);
        assertArrayEquals(new int[][]{{0}}, board1);

        // 死细胞，周围没有其他细胞，应保持死亡
        int[][] board2 = {{0}};
        game.gameOfLife(board2);
        assertArrayEquals(new int[][]{{0}}, board2);
    }

    /**
     * @Test Purpose: 测试最小有效输入 - 2x2网格。
     * 输入为2x2网格，测试所有细胞都为活细胞或死细胞的情况。
     * 这测试了一个较小但比1x1复杂的情况。
     */
    @Test
    public void testSmallBoardAllLive() {
        // 所有细胞都是活的
        int[][] board = {{1, 1}, {1, 1}};
        Solution19 game = new Solution19();
        game.gameOfLife(board);
        // 由于每个细胞有3个邻居，所以应该全部存活
        assertArrayEquals(new int[][]{{1, 1}, {1, 1}}, board);
    }

    /**
     * @Test Purpose: 测试一般情况 - 3x3网格。
     * 输入为3x3网格，包含各种活细胞和死细胞的组合。
     * 这测试了标准的规则应用情况。
     */
    @Test
    public void test3x3Board() {
        int[][] board = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        Solution19 game = new Solution19();
        game.gameOfLife(board);
        // 中间的竖线应该变为横线
        assertArrayEquals(new int[][]{
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        }, board);
    }

    /**
     * @Test Purpose: 测试一般情况 - 4x4网格。
     * 输入为4x4网格，包含复杂的活细胞和死细胞的组合。
     * 这测试了更大规模的网格处理情况。
     */
    @Test
    public void test4x4Board() {
        int[][] board = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };
        Solution19 game = new Solution19();
        game.gameOfLife(board);
        // 预期的结果经过计算
        assertArrayEquals(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        }, board);
    }

    /**
     * @Test Purpose: 测试边界条件 - 活细胞数量接近规则的边界。
     * 输入为复杂的网格，其中一些活细胞数量接近规则的死亡或复活边界。
     * 这测试了算法在极端情况的稳定性。
     */
    @Test
    public void testEdgeCases() {
        int[][] board = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        Solution19 game = new Solution19();
        game.gameOfLife(board);
        // 中间的死细胞应该复活，因为周围有8个活细胞
        assertArrayEquals(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }, board);
    }
}