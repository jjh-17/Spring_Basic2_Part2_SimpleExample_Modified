package spring_basic2.part2_SimpleExample_Modified.discount;

import spring_basic2.part2_SimpleExample_Modified.member.Gradle;
import spring_basic2.part2_SimpleExample_Modified.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    //변수
    private int fixedDiscountAmount = 1000;

    //메서드
    @Override
    public int discount(Member member, int price) {
        if(member.getGradle() == Gradle.VIP){
            return fixedDiscountAmount;
        }
        return 0;
    }
}
