import java.util.ArrayList;

public class S180517 {

    public int[][] solution(int[][] problem) {
        int max = getMax(problem);
        int[] mark = new int[max+1];

        for (int i = 0; i < mark.length; i++) {
            mark[i] = 0;
        }

        for (int i = 0; i < problem.length; i++) {
            for (int j = 0; j < problem[0].length; j++) {
                mark[problem[i][j]] = 1;
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int flag = 0;

        for (int i = 0; i < mark.length; i++) {
            if (mark[i] != flag) {
                result.add(i);
                flag = mark[i];
            }
        }

        return listCut(result);
    }

    int getMax(int[][] array) {
        int max = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                max = Math.max(max, array[i][j]);
            }
        }

        return max;
    }

    int[][] listCut(ArrayList<Integer> list) {
        int[][] result = new int[list.size()/2][2];

        int index = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = list.get(index++);
            }
        }

        return result;
    }

}
