public class S180518 {

    public String solution(String input) {
        String[] strArray = input.split(" ");
        String result = "";

        for (int i = 0; i < strArray.length; i++) {
            result += reverseString(strArray[i]);

            if (i != strArray.length - 1) result += " ";
        }

        return result;
    }

    private String reverseString(String str) {
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        return reverse;
    }
}
