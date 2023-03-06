package spring_basic2.part2_SimpleExample_Modified;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic2.part2_SimpleExample_Modified.member.Gradle;
import spring_basic2.part2_SimpleExample_Modified.member.Member;
import spring_basic2.part2_SimpleExample_Modified.member.MemberService;
import spring_basic2.part2_SimpleExample_Modified.order.Order;
import spring_basic2.part2_SimpleExample_Modified.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
