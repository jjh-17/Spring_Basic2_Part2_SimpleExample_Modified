package spring_basic2.part2_SimpleExample_Modified.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_basic2.part2_SimpleExample_Modified.AppConfig;
import spring_basic2.part2_SimpleExample_Modified.member.Gradle;
import spring_basic2.part2_SimpleExample_Modified.member.Member;
import spring_basic2.part2_SimpleExample_Modified.member.MemberService;

public class OrderServiceTest {
    //변수
    MemberService memberService;
    OrderService orderService;

    //초기화
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    //테스트
    @Test
    void createVIPOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Gradle.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "productA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void createBASICOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Gradle.BASIC);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "productA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(0);
    }
}
