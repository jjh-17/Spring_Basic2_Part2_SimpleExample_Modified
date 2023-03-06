package spring_basic2.part2_SimpleExample_Modified;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_basic2.part2_SimpleExample_Modified.discount.DiscountPolicy;
import spring_basic2.part2_SimpleExample_Modified.discount.RateDiscountPolicy;
import spring_basic2.part2_SimpleExample_Modified.member.MemberRepository;
import spring_basic2.part2_SimpleExample_Modified.member.MemberService;
import spring_basic2.part2_SimpleExample_Modified.member.MemberServiceImpl;
import spring_basic2.part2_SimpleExample_Modified.member.MemoryMemberRepository;
import spring_basic2.part2_SimpleExample_Modified.order.OrderService;
import spring_basic2.part2_SimpleExample_Modified.order.OrderServiceImpl;

/*
애플리케이션의 동작에 필요한 구현 객체 생성
생성자를 통해 객체 인스턴스 참조 ==> 생성자를 통해 주입
DIP 준수

AppConfig에서의 수정으로 각 클래스의 의존관계 변경 가능
 */

@Configuration
public class AppConfig {

    /*
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }

    역할에 따른 구현이 보이도록 리펙터링 필요
    중복되는 메서드에 ctrl + alt + m을 하면 자동 리펙토링 가능
     */

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        //생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
