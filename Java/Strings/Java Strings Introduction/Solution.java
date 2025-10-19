import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length()+B.length());
        
       int x= A.compareTo(B);
       if (x>0) {
        System.out.println("Yes ");
       }else{
        System.out.println("No");
       }
       String firstStringChar=A.charAt(0)+"";
       String secondStringChar=B.charAt(0)+"";
       System.out.println(A.replaceFirst(firstStringChar, firstStringChar.toUpperCase())+" "+ B.replaceFirst(secondStringChar, secondStringChar.toUpperCase()));
    }
}



