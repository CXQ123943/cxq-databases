package com.cxq.datastructures.recursion;

/**
 * @author CXQ
 * @version 1.0
 */
public class Labyrinth {
    public static boolean setWay(int[][] map, int i, int j) {
        if(map[6][5] == 2) { // 通路已经找到ok
            return true;
        } else {
            if(map[i][j] == 0) {//如果当前这个点还没有走过
                //按照策略 下->右->上->左  走
                map[i][j] = 2; // 假定该点是可以走通.
                if(setWay(map, i+1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j+1)) { //向右走
                    return true;
                } else if (setWay(map, i-1, j)) { //向上
                    return true;
                } else if (setWay(map, i, j-1)){ // 向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                    return false;
            }
        }
    }
}
