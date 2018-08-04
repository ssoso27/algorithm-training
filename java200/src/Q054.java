/*
중급 054) 향상된 for(foreach)로 배열 출력하기
- 학습 내용 : 향상된 for를 이용하여 배열을 출력해 보자.
- 힌트 내용 : 향상된 for는 index 없이도 순서대로 배열값을 사용할 수 있다.
 */

public class Q054 {
    public static void main(String[] args) {
        int[] mm = {1, 6, 16, 22, 23, 33};

        for (int m : mm) {
            System.out.println(m);
        }
    }
}
