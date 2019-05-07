import java.util.ArrayList;

public class S180518 {

    public String solution(String input) {
        String[] strArray = splitString(input, ' ');
        String result = "";

        for (int i = 0; i < strArray.length; i++) {
            result += reverseString(strArray[i]);

            if (i != strArray.length - 1) result += " ";
        }

        return result;
    }

    private String[] splitString(String target, char cut) {
        ArrayList<String> strList = new ArrayList<String>();

        String tempStr = "";
        for (int i = 0; i < target.length(); i++) {
            char currnetChar = target.charAt(i);

            if (currnetChar == cut) {
                strList.add(tempStr);
                tempStr = "";
            } else {
                tempStr += currnetChar;
            }
        }
        strList.add(tempStr);

        return listToArray(strList);
    }

    private String[] listToArray(ArrayList<String> list) {
        String[] array = new String[list.size()];

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    private String reverseString(String str) {
        String reverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.charAt(i);
        }

        return reverse;
    }
}
