package spring_basic2.part2_SimpleExample_Modified.discount;

import spring_basic2.part2_SimpleExample_Modified.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price); //할인 대상 금액 return
}
