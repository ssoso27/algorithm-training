import java.util.Scanner;

public abstract class Question {
    protected Scanner scanner;

    public Question() {
        scanner = new Scanner(System.in);
        input();
        init();
    }

    abstract void input();
    abstract void init();
    abstract void solution();
}
