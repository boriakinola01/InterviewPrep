import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringSolution {

    // Check if a phrase is a palindrome removing all the spaces
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int len = s.length();
        for(int i =0; i<len/2; i++){
            if(s.charAt(i) != s.charAt(len-1-i))
                return false;
        }
        return true;
    }

    // check if a string is a palindrome or can be a palindrome when at most
    // one character is replaced

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left <= right){
            if(s.charAt(left) != s.charAt(right))
                return helperValidPalindrome(s, left+1, right) || helperValidPalindrome(s, left, right-1);

            left++;
            right--;
        }
        return true;
    }

    public static boolean helperValidPalindrome(String s, int i, int j){
        while( i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // find the longest common prefix of some strings
    public static String longestCommonPrefix(String[] strs) {
        String pref = "";
        boolean flag = true;
        for(int j = 0;j<strs[0].length(); j++){
            pref = strs[0].substring(0, j+1);
            for(int i = 0; i< strs.length; i++){
                if(!strs[i].startsWith(pref)){
                    pref = strs[0].substring(0, j);
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }
        return pref;
    }

    // find the length of the longest substring having all distinct letters.
    // brute force method. Wouldn't even compile
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> visited = new HashSet<>();
        int max = 0;
        int start = 0, end = 0;
        while(end < s.length()){
            if(!visited.contains(s.charAt(end))){
                visited.add(s.charAt(end));
                end++;
                max = Math.max(visited.size(), max);
            } else {
                visited.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }

    // Zigzag conversion
    public static String convert(String s, int numRows){
        String result = "";
        int n = (numRows - 1) * 2;
        int col = 0;
        int row = 0;

        int num = (n * col) + row;
        while(row < numRows){
            while(num<s.length()){
                result += s.charAt(num);
                num = n*(++col) + row;
            }
            col = 0;
            row++;
            num = (n * col) + row;

        }

        return result;
    }

    // check if a square grid is in alphabetical order by rows and columns
    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int n = grid.size();
        int len = grid.get(0).length();

        for(int i=0; i < n; i++){
            char[] arr = grid.get(i).toCharArray();
            Arrays.sort(arr);
            grid.set(i, String.valueOf(arr));
        }

        boolean ok = true;

        for(int i=0; i<len; i++){
            for(int j = 1; j<n; j++){
                if(grid.get(j).charAt(i) < grid.get(j-1).charAt(i)){
                    ok = false;
                    break;
                }
            }
        }

        if(ok) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("hjk");
        list.add("mpq");
        list.add("rtv");
//        list.add("xywuv");
        String test = "pin";
        System.out.println(gridChallenge(list));
    }
}
