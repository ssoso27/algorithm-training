/*
중급 052) 문자열 자르기를 이용하여 2진수 문자열로 바꾸기
- 학습 내용 : 10진수 정수를 2진수 문자열로 변환해 보자. (단, 불필요한 0은 제거한다.)
- 힌트 내용 : 문자열 메서드를 이용하여 필요 없는 0을 제거한다.
 */

public class Q052 {
    static String toBinary(int num) {
        String result = "";
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            result = (num & mask) + result;
            num >>= 1;
        }

        return result.substring(result.indexOf("1"));
    }

    public static void main(String[] args) {
        int num1 = 123;
        int num2 = -123;

        System.out.println(num1 + " : " + toBinary(num1));
        System.out.println(num2 + " : " + toBinary(num2));
    }
}
