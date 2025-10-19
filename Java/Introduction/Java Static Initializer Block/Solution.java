import java.io.*;
import java.util.*;

public class Solution {

    static boolean flag;
    static int B;
    static int H;
    static{
        Scanner sc= new Scanner(System.in);
         B = sc.nextInt();
         H = sc.nextInt();
         if (B<=0 || H<=0) {
            flag = true;
         }
    }
    public static void main(String[] args) {

        if (flag) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            return ;
        }
        System.out.println(B*H);
    }
}