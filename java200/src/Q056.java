/*
중급 056) 배열보다 편리한 List 사용하기
- 학습 내용 : List의 사용법을 익혀 보자.
- 힌트 내용 : add는 List에 입력하고, get은 List에서 가져온다.
 */

import java.util.ArrayList;
import java.util.List;

public class Q056 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            int m = list.get(i);
            System.out.print(m + " ");
        }
    }
}
