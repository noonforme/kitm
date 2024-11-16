public class Arrays3 {
    public int maxSpan(int[] nums) {
    int maxSpan = 0;
    for (int i = 0; i < nums.length; i++)
        for (int j = nums.length - 1; j >= i; j--)
            if (nums[i] == nums[j])
                maxSpan = Math.max(maxSpan, j - i + 1);
    return maxSpan;
    }

    public int[] fix34(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3 && nums[i + 1] != 4) {
                while (nums[j] != 4 || (j > 0 && nums[j - 1] == 3)) {
                    j++;
                }
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
    

    public int[] fix45(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 4 && nums[i + 1] != 5) {
                while (nums[j] != 5 || (j > 0 && nums[j - 1] == 4)) {
                    j++;
                }   
                int temp = nums[i + 1];
                nums[i + 1] = nums[j];
                nums[j] = temp;
            }
        }
    return nums;
    }   


    public boolean canBalance(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j <= i; j++) {
                leftSum += nums[j];
            }
            for (int k = i + 1; k < nums.length; k++) {
                rightSum += nums[k];
            }
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }
    



    public boolean linearIn(int[] outer, int[] inner) {
        int i = 0;
        int j = 0;
    
        while (i < outer.length && j < inner.length) {
            if (outer[i] == inner[j]) {
                j++;
            } else if (outer[i] > inner[j]) {
                return false;
            }
            i++;
        }
    
        return j == inner.length;
    }
    

    public int[] squareUp(int n) {
        int[] result = new int[n * n];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[(i * n) - j - 1] = j + 1;
            }
        }
        return result;
    }
    

    public int[] seriesUp(int n) {
        int length = n * (n + 1) / 2;
        int[] result = new int[length];
        int index = 0;
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[index++] = j;
            }
        }
        
        return result;
    }
    

    public int maxMirror(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
    
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int len = 0;
                int x = i;
                int y = j;
    
                while (x < n && y >= 0 && nums[x] == nums[y]) {
                    len++;
                    x++;
                    y--;
                }
    
                maxLen = Math.max(maxLen, len);
            }
        }
    
        return maxLen;
    }
    

    public int countClumps(int[] nums) {
        int clumps = 0;
        boolean inClump = false;
    
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (!inClump) {
                    clumps++;
                    inClump = true;
                }
            } else {
                inClump = false;
            }
        }
    
        return clumps;
    }
}
