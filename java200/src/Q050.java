/*
중급 050) shift 연산자를 이용하여 2진수 문자열로 바꾸기
- 학습 내용 : shift 연산자를 이용하여 10진수 정수를 2진수 문자열로 변환해 보자.
- 힌트 내용 : 2에 대한 나머지를 이용한다.
            a>>=1 은 a/=2와 같은 효과를 낸다.
 */
public class Q050 {
    static String toBinary(int num) {
        String result = "";

        for (int i = 0; i < 32; i++) {
            if (i % 4 == 0) result = " " + result;
            result = Math.abs(num % 2) + result;
            num >>= 1; // num /= 2
        }

        return result;
    }

    public static void main(String[] args) {
        int num1 = 123;
        int num2 = -123;

        System.out.println(num1 + " : " + toBinary(num1));
        System.out.println(num2 + " : " + toBinary(num2));
    }
}
