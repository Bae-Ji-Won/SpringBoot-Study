package Date10_06.collection;

import java.util.HashSet;
import java.util.Set;

public class RndNumberSwitchoutDuplicated {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Set<Integer> randomNumberSet = new HashSet<>();

        System.out.print("랜덤한 수(50개) : ");
        for(int i = 0; i < 50; i++) {
            int rndNum = randomNumberGenerator.generate(10);
            System.out.print(rndNum + " ");
            randomNumberSet.add(rndNum);
        }

        System.out.print("\n랜덤한 수 중복제거 : ");
        for (Integer integer : randomNumberSet) {
            System.out.print(integer + " ");
        }
    }
}
