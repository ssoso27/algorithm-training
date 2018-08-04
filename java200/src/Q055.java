/*
중급 055) vararas(variable arguments)를 이용하여 배열 출력하기
- 학습 내용 : varargs(가변인자 : 임의의 개수로 사용할 수 있는 인자)를 이용해 배열을 출력해 보자.
- 힌트 내용 : varargs는 인자의 개수가 1개, 2개 이상, 심지어 배열로도 사용할 수 있다.
 */

public class Q055 {
    static void print_var(int... mm) {
        for (int m: mm) {
            System.out.print(m + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] mm = {1, 6, 16, 22, 23, 33};

        print_var(mm); // 매개변수 : 배열
        print_var(2);
        print_var(6 , 7);
        print_var(8, 0, 2, 4, 6, 7, 2);
    }
}
