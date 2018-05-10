import java.util.ArrayList;

public class S180510 {

    int solution(int N) {
        int result = 0;

        ArrayList<Integer> fibonach = getFibonach(N);

        for (int i = 0; i < fibonach.size(); i++) {
            if (fibonach.get(i)%2 == 0) {
                result += fibonach.get(i);
            }
        }

        return result;
    }

    ArrayList<Integer> getFibonach(int n) {
        ArrayList<Integer> fibonach = new ArrayList();
        fibonach.add(0);
        fibonach.add(1);

        int index = 2;
        while(true) {
            int sum = fibonach.get(index-1) + fibonach.get(index-2);

            if (sum < n) {
                fibonach.add(sum);
            } else {
                break;
            }

            index++;
        }

        return fibonach;
    }

    public static void main(String[] args){
        S180510 test = new S180510();

        System.out.println(test.solution(-1));
    }
}
