import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ColorPaper {

    private static ArrayList<Group> groups;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int numOfTestcase = sc.nextInt();

        for (int testcase = 1; testcase <= numOfTestcase; testcase++) {
            int numOfPaper = sc.nextInt();
            int numOfColor = sc.nextInt();
            int[] papers = new int[numOfPaper];
            int[] colorCount = new int[numOfColor+1];
            boolean isEmpty = true;
            groups = new ArrayList<Group>();

            // 색종이배열 입력
            for (int idx = 0; idx < papers.length; idx++) {
                papers[idx] = sc.nextInt();

                // 빈칸일때
                if (papers[idx] == 0) {
                    // 그룹이 비었거나 마지막 그룹이 끝난 그룹이면
                    if (groups.isEmpty() || groups.get(groups.size() - 1).getEnd() != -1) {
                        // 그룹 시작
                        Group group = new Group();
                        group.setStart(idx);
                        if (idx == 0) group.setMin(1);
                        else group.setMin(papers[idx-1]);

                        groups.add(group);
                    }
                } else { // 빈칸 아닐때
                    colorCount[papers[idx]]++;
                    isEmpty = false;

                    // 그룹이 있고 마지막 그룹이 아직 덜 끝났으면
                    if (!groups.isEmpty() && groups.get(groups.size() - 1).getEnd() == -1) {
                        // 그룹 끝
                        Group group = groups.get(groups.size() - 1);
                        group.setEnd(idx - 1);
                        group.setMax(papers[idx]);

                        groups.set(groups.size()-1, group);
                    }
                }
            }

            if (!groups.isEmpty() && groups.get(groups.size() - 1).getEnd() == -1) {
                Group group = groups.get(groups.size() - 1);
                group.setEnd(papers.length - 1);
                group.setMax(numOfColor);

                groups.set(groups.size()-1, group);
            }

            // 결과 구하기
            int max = -1;
            if (groups.isEmpty()) {
                for (int count : colorCount) {
                    if (max < count) max = count;
                }
            } else if (isEmpty) {
                max = numOfPaper - (numOfColor - 1);
            } else {
                max = Math.max(
                        countMax(colorCount, 0, true),
                        countMax(colorCount, 0, false)
                );
            }

            System.out.println("#" + testcase + " " + max);
        }
    }

    private static int countMax(int[] colorCount, int idx, boolean isMin) {
        Group group = groups.get(idx);
        colorCount = colorCount.clone();
        int sum;

        if (group.getColorScope() < 3) {
            if (group.getStart() == 0) sum = group.getLength() - (group.getColorScope() - 1);
            else sum = group.getLength();
        } else {
            sum = group.getLength() - (group.getColorScope() - 2);
        }

        if (isMin) {
            // min
            colorCount[group.getMin()] += sum;
        } else {
            // max
            colorCount[group.getMax()] += sum;
        }

        if (idx < groups.size()-1) {
            return Math.max(countMax(colorCount, idx+1, true), countMax(colorCount, idx+1, false));
        } else { // 끝까지 도달
            // 계산하고 리턴
            int max = -1;
            for (int count : colorCount) {
                if (max < count) max = count;
            }
            return max;
        }
    }
}

class Group {
    private int start;
    private int end;
    private int max;
    private int min;
    private int length;
    private int colorScope;

    public Group() {
        this.start = -1;
        this.end = -1;
        this.max = -1;
        this.min = -1;
        this.length = 0;
        this.colorScope = 0;
    }

    public String toString() {
        return "start: " + this.start + ", end: " + this.end
                + ", min: " + this.min + ", max: " + this.max
                + ", length: " + this.length + ", colorScope: " + this.colorScope;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
        this.length = this.end - this.start + 1;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
        this.length = this.end - this.start + 1;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
        this.colorScope = this.max - this.min + 1;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
        this.colorScope = this.max - this.min + 1;
    }

    public int getLength() {
        return length;
    }

    public int getColorScope() {
        return colorScope;
    }
}