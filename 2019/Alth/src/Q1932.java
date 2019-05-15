import java.util.LinkedList;

public class Q1932 extends Question {
    private int triangleSize, nodeSize;
    private int[][] triangle;
    private boolean[] checked;
    private int[] values;

    @Override
    public void input() {
        triangleSize = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < scanner.nextLine(); i++)

        for (int[] arr : triangle) {
            arr = new int[triangleSize];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
        }

        for (int i = 0; i < nodeSize; i++) {
            checked[i] = false;
        }

        for (int i = 0; i < triangleSize; i++) {
            String[] arr = scanner.nextLine().split(" ");

            for (String n : arr) {
                values(Integer.parseInt(n));
            }
        }

        System.out.println(triangle[3].toString());
    }

    @Override
    void init() {


        nodeSize = triangleSize * triangleSize;
        triangle = new int[triangleSize][];
        checked = new boolean[nodeSize];
        values = new int[nodeSize];
    }

    @Override
    public void solution() {

    }
}
