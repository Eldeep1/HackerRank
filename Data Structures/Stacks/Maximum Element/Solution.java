import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> myStack = new ArrayDeque<>();
        List<Integer> orderedIntegers = new ArrayList<>();

        for (String operations2 : operations) {

            if (operations2.charAt(0) == '1') {

                String x = operations2.substring(2);

                Integer num = Integer.parseInt(x);

                myStack.push(num);

                // put the new number on an ordered position
                orderList(num, orderedIntegers);
            } else if (operations2.charAt(0) == '2') {
                orderedIntegers.remove(myStack.pop());
            } else {
                result.add(orderedIntegers.get(0));
            }
        }
        return result;
    }

    public static void orderList(Integer num, List<Integer> integers) {
        if (integers.isEmpty()) {
            integers.add(num);
        }
        else{
            //make the first integer the largest of them all
            for (int i = 0; i < integers.size(); i++) {
                int tmp=integers.get(i);
                if (num>tmp) {
                    integers.add(i, num);
                    return;
                }
            }
            integers.add(num);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = Result.getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
