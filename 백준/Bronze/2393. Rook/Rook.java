public class Main {
    public static void main(String[] args) {
        // 패턴을 구성하는 문자열 배열
        String[] pattern = {
            "  ___  ___  ___",
            "  | |__| |__| |",
            "  |           |",
            "   \\_________/",
            "    \\_______/",
            "     |     |",
            "     |     |",
            "     |     |",
            "     |     |",
            "     |_____|",
            "  __/       \\__",
            " /             \\",
            "/_______________\\"
        };

        // 패턴 출력
        for (String line : pattern) {
            System.out.println(line);
        }
    }
}