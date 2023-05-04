package tests;

import models.member.JoinService;
import models.member.JoinValidationException;
import models.member.JoinValidator;
import models.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberJoinTest {

    private JoinService joinService;
    private Member member;

    @BeforeEach
    void init() {
        joinService = new JoinService(new JoinValidator());
        member = getMember();
    }

    private Member getMember() {
        Member member = new Member();
        member.setUserNm("사용자01");
        member.setUserId("user01");
        member.setUserPwRe("12345678");
        member.setUserPw("12345678");

        return member;
    }

    @Test
    @DisplayName("회원가입에 성공하면 예외가 발생하지 않음")
    void joinSuccessTest() {
        assertDoesNotThrow(() -> {
            joinService.join(member);
        });
    }

    @Test
    @DisplayName("필수 항목(userId, userPw, userPwRe, userNm) 체크 - 검증 실패시 JoinValidationException 발생")
    void joinRequiredFieldsTest() {
        assertAll(
                // userId 필수 항목 검증 - null
                () -> assertThrows(JoinValidationException.class, () -> {
                        Member member = getMember();
                        member.setUserId(null);
                        joinService.join(member);
                    }),
                // userId 필수 항목 검증 - 빈값(공백)
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserId("    ");
                    joinService.join(member);
                }),
                // userPw 필수 항목 검증 - null
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserPw(null);
                    joinService.join(member);
                }),
                // userPw 필수 항목 검증 - 빈값(공백)
                () -> assertThrows(JoinValidationException.class, () -> {
                    Member member = getMember();
                    member.setUserPw("    ");
                    joinService.join(member);
                })

        );
    }
}