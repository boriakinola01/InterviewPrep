public class practiceCodesignal {

    static boolean[] solution(int[] a, int l, int r) {
        boolean[] result = new boolean[a.length];

        for(int i = 0; i<a.length; i++){
            int x = a[i] / (i+1);
            boolean check = a[i] % (i+1) == 0;
            result[i] = x >= l && x <= r && check;
        }

        return result;
    }

    static String solution2(String s) {
        int longestEnd = 0;
        int max = 0;
        int start = 0;
        int end = 0;
        if(s.isEmpty())
            return "";
        while(true){
            String prefix;
            end = 0;
            while(end <=s.length()){
                prefix = s.substring(start, end);
                if(isPalindrome(prefix) && prefix.length()>max){
                    max = prefix.length();
                    longestEnd = end;
                }
                end++;
            }
            if(max < 2)
                return s;

            if(longestEnd == s.length()-1)
                return s;

            s = s.substring(longestEnd);
            max = 0;


        }
    }
    public static boolean isPalindrome(String s) {
        int len = s.length();
        for(int i =0; i<len/2; i++){
            if(s.charAt(i) != s.charAt(len-1-i))
                return false;
        }
        return true;
    }

    //select operation
    static String solution3(String[] operations) {
        String output = "";
        int currentCursor = 0;

        for(int i =0; i< operations.length; i++){
            String[] operate = operations[i].split(" ");

            switch (operate[0]){
                case "TYPE":
                    output = output + operate[1];
                    currentCursor = output.length();
                    System.out.println(addChar(output, '|', currentCursor));
                    break;
                case "MOVE_CURSOR":
                    if(operate[i].charAt(0) == '-')
                        currentCursor = currentCursor-Character.getNumericValue(operate[1].charAt(1));
                    else{
                        currentCursor = currentCursor+Character.getNumericValue(operate[1].charAt(0));
                        if(currentCursor > output.length())
                            currentCursor = output.length();
                    }
                    System.out.println(addChar(output, '|', currentCursor));
                    break;
                case "SELECT":
                    int start = Integer.parseInt(operate[1]);
                    int end = Integer.parseInt(operate[2]);
                    System.out.println(output.substring(start, end));
            }
        }

        return output;
    }

    public static String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }

    public static String delChar(String str, int start, int end){
        return str.substring(0, start) + str.substring(end);
    }

    public static void main(String[] args) {
        String[] s = {"TYPE myname", "MOVE_CURSOR -3"};
        int[] a ={9, 8, 7, 6, 5};
        System.out.println(solution7(a));
    }


    static long solution7(int[] arr) {
        long count = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(arr[i] >= arr[j])
                    count++;
                else
                    break;
            }
        }

        return count;
    }

    int[] solution(int[] numbers) {
        int[] arr = new int[numbers.length-2];

        for(int i =0; i< numbers.length-2; i++){
            if((numbers[i] < numbers[i+1] && numbers[i+1] > numbers[i+2]) || (numbers[i] > numbers[i+1] && numbers[i+1] < numbers[i+2]))
                arr[i] = 1;
            else
                arr[i] = 0;
        }

        return arr;
    }

    static boolean solution6(int[] a) {
        int[] b = new int[a.length];
        int left = 0;
        int right = a.length-1;
        for(int i=0; i < a.length/2; i++){
            b[i] = a[left++];
            b[++i] = a[right--];
        }
        boolean result = true;
        for(int j =0; j<b.length -1; j++){
            if(b[j] > b[j+1]){
                result=false;
                break;
            }
        }
        return result;
    }



    static void printArr(boolean[] arr){
        for (int i =0; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
    }

}
