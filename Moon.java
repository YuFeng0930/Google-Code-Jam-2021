
import java.io.*;
import java.util.*;

/**
 * 
4
2 3 CJ?CC?
4 2 CJCJ
1 3 C?J
2 5 ??J???
 */

public class Moon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int numOfTests = Integer.parseInt(br.readLine()); 
        String[] temp;

        for (int i = 0; i < numOfTests; i++) {
            int cost = 0;
            temp = br.readLine().split(" ");
            int cjCost = Integer.parseInt(temp[0]);
            int jcCost = Integer.parseInt(temp[1]);
            StringBuilder original = new StringBuilder(temp[2]);

            fillUp(original);

            cost += countCj(original) * cjCost;
            cost += coungJc(original) * jcCost;

            pw.println("Case #" + (i + 1) + ": " + cost);
        }
        pw.close();
    }

    public static void fillUp(StringBuilder str) {
        while (str.indexOf("?") != -1) {
            int i = str.indexOf("?");
            if (i == 0) {
                char insert = 'C';
                for (int j = 1; j < str.length(); j++) {
                    if (str.charAt(j) != '?') {
                        insert = str.charAt(j);
                        break;
                    }
                }
                str.setCharAt(0, insert);
            } else {
                str.setCharAt(i, str.charAt(i - 1));
            }
        }
    }

    public static int countCj(StringBuilder str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'C' && str.charAt(i + 1) == 'J') {
                count += 1;
            }
        }
        return count;
    }

    public static int coungJc(StringBuilder str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'J' && str.charAt(i + 1) == 'C') {
                count += 1;
            }
        }
        return count;
    }
}
