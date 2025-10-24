import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {

    String[] chunks=s.split(":");


    if (chunks[0].equals("12")) {
        if (chunks[2].endsWith("PM")) {
        return s.substring(0,8);
        }
        else{
            return s.replaceFirst("[0-9]+", "00").substring(0,8);
        }
    }
    if (chunks[2].endsWith("AM")) {
        return s.substring(0,8);
    }

    int firstRegion=Integer.parseInt(chunks[0]);
    firstRegion+=12;

    if (firstRegion==24) {
        return s.replaceFirst("[0-9]+", "00").substring(0,8);
    }
    else{
        return s.replaceFirst("[0-9]+",firstRegion+"").substring(0, 8);
    }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
