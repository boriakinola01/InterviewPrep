import javax.print.DocFlavor;
import java.lang.invoke.SwitchPoint;
import java.util.*;



public class MathSolution {

    //Palindrome number
    public boolean isPalindrome(int x){
        int num = x;
        int rev =0;

        while(x > 0){
            int digit = x % 10;
            rev = rev * 10 +  digit;
            x = x /10;
        }

        return rev == num;
    }

    // removing duplicate elements in an integer array
    public static int removeDuplicates(int[] nums) {
        int index = 0;

        for(int i=1; i< nums.length; i++){
            if(nums[index]!= nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    // removing element form an array
    public int removeElement(int[] nums, int val) {
        int j = 0;

        for(int i =0; i< nums.length; i++){
            if (nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    // Move all zeros to the end of the array
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for(int i = j; i< nums.length; i++){
            nums[i] = 0;
        }
    }

    // search for an int and if not found, return position for it to be inserted into
    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;

        while(first <= last){
            int mid = nums.length/2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target){
                first = mid + 1;
            } else if(nums[mid] > target){
                last = mid - 1;
            }
        }

        return first;
    }

    // converting an integer to roman numerals.

    public static String intToRoman(int num){
        //TODO
        String result = "";
        LinkedHashMap<Integer, String> data = new LinkedHashMap<>();

        data.put(1000, "M");
        data.put(500, "D");
        data.put(100, "C");
        data.put(50, "L");
        data.put(10, "X");
        data.put(5, "V");


        return result;
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        //TODO
        // Write your code here
        int left = 0;
        int right = 0;
        int size = arr.size();

        for (int i = 0; i < size; i++) {
            right += arr.get(i).get(i);
            left += arr.get(i).get(size-i-1);
        }
        return Math.abs(left - right);
    }

    // Toast interview prep1
    public static int leastMissingPositive(int[] nums) {
        // fill in
        // with solution
        quick(nums, 0, nums.length-1);

        for(int i=0;i<nums.length-1; i++){
            if(nums[i+1] != nums[i] + 1){
                if(nums[i] + 1 > 0)
                    return nums[i] + 1;
            }
        }
        return nums[nums.length-1] + 1;
    }
    public static void quick(int[] array, int left, int right){
        if(left<right){
            int pivot = partition(array, left, right);
            quick(array, left, pivot-1);
            quick(array, pivot, right);
        }
    }

    static int partition(int[] arr, int left, int right){
        int mid = (left+right) / 2;
        int pivot = arr[mid];

        while(right >= left){
            while(arr[left] < pivot)
                left++;

            while (pivot < arr[right])
                right--;

            if(right >= left){
                swap(left, right, arr);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void swap(int i, int j, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //Hackerrank interview prep
    // counting sort
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(100, 0));

        for(int i=0; i < arr.size(); i++){
            int num = arr.get(i);
            list.set(num, list.get(num) + 1);
        }

        // returns the frequency array of each element
        return list;
    }


    // flipping matrix
    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        int max = 0;
        int size = matrix.size();

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                int currentMax = sumUpper(matrix);
                if(currentMax>max)
                    max = currentMax;
                reverseCol(j, matrix);
            }
            Collections.reverse(matrix.get(i));
        }

        return max;
    }

    public static void reverseCol(int i, List<List<Integer>> matrix){
        for(int row = 0; row<matrix.size()/2; row++){
            int temp = matrix.get(row).get(i);
            matrix.get(row).set(i, matrix.get(matrix.size()-row-1).get(i));
            matrix.get(matrix.size()-row-1).set(i, temp);
        }
    }

    public static int sumUpper(List<List<Integer>> matrix){
        int sum = 0;
        int n = matrix.size()/2;

        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                sum += matrix.get(i).get(j);
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0};
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(5);
        l1.add(1);
        l1.add(4);
        List<Integer> l2 = new ArrayList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);
        List<Integer> l3 = new ArrayList<>();
        l2.add(9);
        l2.add(8);
        l2.add(9);
        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        System.out.println(calculateAmount(l1));
        //System.out.println(diagonalDifference(list));
        //System.out.println(removeDuplicates(arr));
        //System.out.println(leastMissingPositive(arr));
    }

    static void printArr(int[] arr){
        for (int i =0; i< arr.length; i++){
            System.out.print(arr[i]  + ", ");
        }
    }
    public static long calculateAmount(List<Integer> prices){

        long amount = prices.get(0);
        int min = prices.get(0);
        for(int i=1; i<prices.size(); i++){
            amount = amount + Math.max(prices.get(i) - min, 0);
            if(min > prices.get(i))
                min = prices.get(i);
        }

        return amount;
    }

    public static List<Long> maxMin(List<String> operations, List<Integer> x){

        int min = 0;
        int max = 0;
        List<Long> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

        for(int i=0; i<x.size(); i++){

            if(i == 0){
                min = x.get(i);
                max = x.get(i);
            }

            if(operations.get(i).equals("Push")){
                tempList.add(x.get(i));

                if(x.get(i) > max)
                    max = x.get(i);
                if(x.get(i) < min)
                    min = x.get(i);
            } else if(operations.get(i).equals("Pop")){
                tempList.remove(x.get(i));

                if(x.get(i) == min)
                    min = Collections.min(tempList);
                if(x.get(i) == max)
                    max = Collections.max(tempList);

            }

            result.add( ((long) min * max));

        }

        return result;
    }

}
