
import java.io.*;
import java.util.*;

public class ReversortEngin {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int numOfTests = Integer.parseInt(br.readLine()); 
        String[] temp;

        for (int i = 0; i < numOfTests; i++) {
            temp = br.readLine().split(" ");
            int numOfIntegers = Integer.parseInt(temp[0]);
            int expectedCost = Integer.parseInt(temp[1]);
            int[] inputs = makeInput(numOfIntegers, expectedCost);
            if (inputs == null) {
                pw.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                String output = "";
                for (int j = 0; j < inputs.length; j++) {
                    output += (" " + inputs[j]);
                }
                pw.println("Case #" + (i + 1) + ":" + output);
            }   
        }
        pw.close();
    }

    public static int[] makeInput(int numOfIntegers, int expectedCost) {
        int max = 0;
        for (int i = 2; i <= numOfIntegers; i++) {
            max += i;
        } 
        if (expectedCost < numOfIntegers - 1 || expectedCost > max) {
            return null;
        }
        

        int[] changes = new int[numOfIntegers - 1];

        Arrays.fill(changes, 1);
        expectedCost -= (numOfIntegers - 1);

        for (int i = 0; i < changes.length && expectedCost != 0; i++) {
            if (expectedCost >= (numOfIntegers - i - 1)) {
                changes[i] += (numOfIntegers - i - 1);
                expectedCost -= (numOfIntegers - i - 1);
            }
        }

        return reverseReversort(numOfIntegers, changes);

    }

    public static int[] reverseReversort(int numOfIntegers, int[] changes) {
        int[] result = new int[numOfIntegers];
        
        for (int i = 0; i < numOfIntegers; i++) {
            result[i] = i + 1;
        }

        for (int i = numOfIntegers - 2; i >= 0; i--) {
            reverse(result, i, i + changes[i] - 1);
        }
        return result;
    }

    public static int findMinIndex(int startingIndex, int[] inputs) {
        int minIndex = startingIndex;
        int minValue = inputs[startingIndex];
        for (int i = startingIndex + 1; i < inputs.length; i++) {
            if (inputs[i] < minValue) {
                minIndex = i;
                minValue = inputs[i];
            }
        }
        return minIndex;
    }

    public static void reverse(int[] inputs, int start, int end) {
        int[] newInputs = new int[end - start + 1];
        int count = 0;
        for (int i = end; i >= start; i--) {
            newInputs[count++] = inputs[i];
        }
        count = 0;
        for (int i = start; i <= end; i++) {
            inputs[i] = newInputs[count++];
        }
    }
}
