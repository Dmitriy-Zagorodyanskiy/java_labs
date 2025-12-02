import java.util.Scanner;

public class task1 {

    public static String fixText(String input) {
        if (input == null || input.isEmpty()) return input;

        StringBuilder out = new StringBuilder(input.length());
        char[] s = input.toCharArray();

        for (int i = 0; i < s.length; i++) {
            char c = s[i];

            if (i + 1 < s.length) {
                char next = s[i + 1];

                // англ букви p/P + a/A → o/O
                if ((c == 'p' || c == 'P') && (next == 'a' || next == 'A')) {
                    out.append(c);
                    out.append(Character.isUpperCase(next) ? 'O' : 'o');
                    i++; // пропускаємо початкову 'a'
                    continue;
                }
            }

            out.append(c);
        }

        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть строку:");
        String input = sc.nextLine();

        String fixed = fixText(input);

        System.out.println("Виправлений текст:");
        System.out.println(fixed);
    }
}
