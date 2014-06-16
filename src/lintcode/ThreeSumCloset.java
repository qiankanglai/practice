package lintcode;

import java.util.Arrays;

/**
 * Created by anthony on 6/11/14.
 */
public class ThreeSumCloset {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if(numbers == null || numbers.length < 3) {
            return 0;
        }
        Arrays.sort(numbers);
        int closet = numbers[0] + numbers[1] + numbers[2];
        int threshold = target + Math.abs(target - closet);
        for(int i1 = 0; i1 < numbers.length; i1++) {
            if (numbers[i1] * 3 > threshold) break;
            if (i1 > 0 && numbers[i1] == numbers[i1 - 1])
                continue;
            for (int i2 = i1 + 1; i2 < numbers.length; i2++) {
                if (numbers[i1] + numbers[i2] * 2 > threshold) break;
                if (i2 > i1 + 1 && numbers[i2] == numbers[i2 - 1])
                    continue;
                for (int i3 = i2 + 1; i3 < numbers.length; i3++) {
                    int t = numbers[i1]+numbers[i2]+numbers[i3];
                    if(t > threshold)
                        break;
                    if(Math.abs(t - target) < Math.abs(closet - target)){
                        closet = t;
                        threshold = target + Math.abs(target - closet);
                    }
                }
            }
        }

        return closet;
    }
}
