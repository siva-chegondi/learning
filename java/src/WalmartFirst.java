// Find first missing number in a sorted array of positive number.

// 1 2 3 4
public class WalmartFirst {

    public static void main(String... args) {

        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(findFirstMissing(arr, arr.length/2));
    }

    private static int findFirstMissing(int[] arr, int pivot) {
        if (arr[pivot] == pivot) {
            return findFirstMissing(arr, (pivot + arr.length)/ 2);
        } else {
            if (pivot == 0) {
                return 0;
            } else if (arr[pivot - 1] == pivot - 1) {
                return pivot;
            }
            else
                return findFirstMissing(arr, pivot / 2);
        }
    }
}
