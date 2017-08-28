// https://www.hackerrank.com/challenges/gem-stones
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        List<Character> result = new ArrayList<Character>();
        Set<Character> tmp = new HashSet<Character>();
        for(int i = 0 ; i < cases ; i++){
            String gem = in.next();
            for(int j = 0 ; j < gem.length() ; j++){
                tmp.add(gem.charAt(j));
            }
            if(i == 0){
                result.addAll(tmp);
            } else {
                for(int j = 0 ; j < result.size() ; ){
                    if(tmp.contains(result.get(j))){
                        j++;
                    } else {
                        result.remove(j);
                    }
                }
            }
            tmp.clear();
        }
        System.out.println(result.size());
    }
}
