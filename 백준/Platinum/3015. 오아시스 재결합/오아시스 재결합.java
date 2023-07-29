import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class Person {
        int height;
        int pair;

        public Person (int height, int pair) {
            this.height = height;
            this.pair = pair;
        }
    }
    static int N;
    static Stack<Person> stack = new Stack<>();
    static long cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            Person person = new Person(h, 1);

            // 자신보다 키가 작은 경우 스택에서 pop
            while(!stack.isEmpty() && stack.peek().height <= h) {
                Person poppedPerson = stack.pop();
                cnt += poppedPerson.pair;
                if (poppedPerson.height == h) person.pair += poppedPerson.pair;
            }

            if (!stack.isEmpty()) cnt++;

            stack.push(person);
        }

        System.out.println(cnt);
    }
}