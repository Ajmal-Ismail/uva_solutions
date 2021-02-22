import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Integer algorithm(Integer n, Map<Integer, Integer> mem) {
        if (!mem.containsKey(n)) {
            mem.put(n, 1 + algorithm(n % 2 == 0 ? n >> 1 : 3 * n + 1, mem));
        }
        return mem.get(n);
    }

    public static void main(String... args) {
        Map<Integer, Integer> mem = new HashMap<Integer, Integer>() {{
            put(1, 1);
        }};

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            Integer i = s.nextInt();
            Integer j = s.nextInt();
            Integer ii = Math.min(i, j);
            Integer jj = Math.max(i, j);
            Integer max = 0;
            for (Integer k = ii; k <= jj; k++) {
                Integer length = algorithm(k, mem);
                max = length > max ? length : max;
            }
            System.out.println(String.format("%d %d %d", i, j, max));
        }
    }
}

