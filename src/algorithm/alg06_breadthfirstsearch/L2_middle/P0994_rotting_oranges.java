package algorithm.alg06_breadthfirstsearch.L2_middle;

import java.util.LinkedList;
import java.util.Queue;

public class P0994_rotting_oranges {

    class Position{
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;
    }


    //使用队列实现广度优先搜索
    public int orangesRotting(int[][] grid) {

        //坐标移动辅助数组
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        //腐烂时间记录数组
        int[][] grid_count = new int[grid.length][grid[0].length];

        //新鲜橘子个数
        int fresh_count = 0;

        //使用的时间
        int res = 0;

        Queue<Position> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                    queue.add(new Position(i,j));
                else if(grid[i][j] == 1)
                    fresh_count++;
            }
        }


        while(!queue.isEmpty()){

            Position position = queue.poll();

            for(int k = 0; k < 4; k++){

                //坐标合法性检查
                //新鲜橘子检查
                if(position.x + row[k] >= 0 && position.x + row[k] <= grid.length -1
                        && position.y + col[k] >=0 && position.y + col[k] <= grid[0].length -1
                        && grid[position.x + row[k]][position.y + col[k]] == 1){

                    //加上一分钟，腐烂当前的橘子
                    res = grid_count[position.x][position.y] + 1;
                    grid_count[position.x + row[k]][position.y + col[k]] = res;
                    grid[position.x + row[k]][position.y + col[k]] = 2;

                    queue.add(new Position(position.x + row[k], position.y + col[k]));

                    fresh_count--;
                }
            }
        }

        return fresh_count > 0 ? -1 : res;
    }
}
