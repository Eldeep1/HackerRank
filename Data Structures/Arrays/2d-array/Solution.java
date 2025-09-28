import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int hourglassSum(List<List<Integer>> arr) {
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 5; j++) {
                int firstrowSum= rowSum(arr.get(i), j);
                int secondRowSum=arr.get(i+1).get(j);
                int thirdRowSum=rowSum(arr.get(i+2), j);
                int tmpMax= firstrowSum+secondRowSum+thirdRowSum;
                if (tmpMax>max) {
                    max=tmpMax;
                }
            }
        }
        return max;
    }
    private static int rowSum(List<Integer> arr, int j){
        return arr.get(j)+arr.get(j-1)+arr.get(j+1);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
