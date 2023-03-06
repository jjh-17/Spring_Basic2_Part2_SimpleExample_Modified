package spring_basic2.part2_SimpleExample_Modified.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_basic2.part2_SimpleExample_Modified.AppConfig;

public class MemberServiceTest {
    //변수
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    //테스트
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Gradle.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
