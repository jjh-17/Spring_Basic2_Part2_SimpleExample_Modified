package spring_basic2.part2_SimpleExample_Modified.discount;

import spring_basic2.part2_SimpleExample_Modified.member.Gradle;
import spring_basic2.part2_SimpleExample_Modified.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    //변수
    private int ratedDiscountAmount = 10;

    //메서드
    //메서드 혹은 클래스 위에 ctrl+shift+t하면 새로운 데스트 자동 완성 가능
    @Override
    public int discount(Member member, int price) {
        if(member.getGradle() == Gradle.VIP){
            return price * ratedDiscountAmount / 100;
        }
        return 0;
    }
}
