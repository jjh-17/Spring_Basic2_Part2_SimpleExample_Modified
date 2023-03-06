package spring_basic2.part2_SimpleExample_Modified.member;

public interface MemberRepository {
    void save(Member member);       //회원 정보 저장
    Member findById(Long memberId); //회원 검색
}
