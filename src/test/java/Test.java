public class Test {

    //input - 2,6,1,6,9, output - 3
//1,3,4,8,2,3,1,8

    public static void main(String[] args) {

        int[] nums = {2, 6, 1, 6, 9};

        int output = getLength(nums);
        System.out.println(output);
    }

    private static int getLength(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int output = nums.length;

        boolean maxAvailable=false;
        boolean minAvailable=false;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                int minIdx = -1;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == min) {
                        minIdx = j;
                    }
                    output = Math.min(output, Math.abs(i - minIdx));
                }
            }
        }

        int start=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max || nums[i]==min){

            }

        }



        return output + 1;
    }
}
