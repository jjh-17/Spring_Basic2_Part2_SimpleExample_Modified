package spring_basic2.part2_SimpleExample_Modified;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_basic2.part2_SimpleExample_Modified.member.Gradle;
import spring_basic2.part2_SimpleExample_Modified.member.Member;
import spring_basic2.part2_SimpleExample_Modified.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        /*
        //AppConfig에서 @로 빈 등록을 하지 않았을 때
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
         */

        /*
        @Configuration이 붙은 클래스를 구성 정보로 사용
        @Bean이 적힌 메서드를 모두 호출한 후, 반환된 객체를 스프링 빈으로써 스프링 컨테이너에 등록
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //현재 관리하는 컨테이너 내 memberService라는 메서드와 그 리턴 값에 해당하는 빈 정보를 받는다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Gradle.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
