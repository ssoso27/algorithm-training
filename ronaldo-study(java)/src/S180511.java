//import java.util.ArrayList;
//
//public class S180511 {
//
//    public String[] solution(int n) {
//        ArrayList<String> list = new ArrayList<>();
//
//        int[][] array = getParenthesisArray(n);
//
//        for (int i = 0; i < array.length; i++) {
//            int sum = 0;
//
//            for (int j = 0; j < array[0].length; j++) {
//                sum += array[i][j];
//
//                if (sum < 0) break;
//            }
//
//            if (sum < 0) continue;
//
//            list.add(array.toString());
//        }
//
//        return (String[]) list.toArray();
//    }
//
//    private int[][] getParenthesisArray(int n) {
//        int plusCount = 0;
//        int minusCount = 0;
//
//
//    }
//}
