public class S180519 {

    public String solution(int[] array) {
        boolean isNotExistSecond = true;
        String result = null;

        for (int i = 0; i < array.length; i++) {
            if (array[0] != array[i]) {
                isNotExistSecond = false;
                break;
            }
        }

        if (isNotExistSecond) {
            result = "Dose not exist";
        } else {
            result = getSecond(array);
        }

        return result;
    }

    private String getSecond(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > second) {
                if (array[i] > first) {
                    second = first;
                    first = array[i];
                } else if (array[i] < first) {
                    second = array[i];
                }
            }
        }

        return Integer.toString(second);
    }

}
