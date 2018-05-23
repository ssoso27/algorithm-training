public class S180523 {

    public int solution(String input) {
        int result = 0;
        String substr = "";

//        for (int start = 0; start < input.length(); start++) {
//            String substr = "";
//
//            for (int j = start; j < input.length(); j++) {
//                char curChar = input.charAt(j);
//
//                if (substr.indexOf(curChar) == -1) substr += curChar;
//                else break;
//            }
//
//            result = Math.max(result, substr.length());
//        }

        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);

            if (substr.indexOf(curChar) == -1) substr += curChar;
            else {
                result = Math.max(substr.length(), result);
                substr = "";
            }
        }
        result = Math.max(substr.length(), result);

        return result;
    }
}
