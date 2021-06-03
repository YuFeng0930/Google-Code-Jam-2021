
import java.io.*;

public class Reversort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numOfTests = Integer.parseInt(br.readLine()); 
        String[] temp;

        for (int i = 0; i < numOfTests; i++) {
            int numOfInputs = Integer.parseInt(br.readLine()); 
            int[] inputs = new int[numOfInputs];
            temp = br.readLine().split(" ");
            for (int j = 0; j < numOfInputs; j++) {
                inputs[j] = Integer.parseInt(temp[j]);
            }
            pw.println("Case #" + (i + 1) + ": " + reversort(numOfInputs, inputs));
        }
        pw.close();
    }

    public static int reversort(int numOfInputs, int[] inputs) {
        int cost = 0;
        for (int i = 0; i < numOfInputs - 1; i++) {
            int j = findMinIndex(i, inputs);
            reverse(inputs, i, j);
            cost += (j - i + 1);
        }
        return cost;
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



/**
7
4
1 2 3 4
4
1 2 4 3
4
2 4 3 1
4
4 3 2 1
4
2 4 3 1
4
2 3 4 1
4
2 4 3 1


7
4
1 2 3 4
4
1 2 4 3
4
1 4 3 2
4
4 3 2 1
4
3 4 2 1
4
2 3 4 1
4
2 4 3 1
 */