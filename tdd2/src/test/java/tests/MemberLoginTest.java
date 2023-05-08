package tests;

import models.member.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;

@DisplayName("로그인 기능 테스트")
@ExtendWith(MockitoExtension.class)
public class MemberLoginTest {

    private LoginService loginService;

    private JoinService joinService;

    @Mock
    private HttpServletRequest request;

    private Member member; // 실제 가입 회원

    @BeforeEach
    void init() {
        loginService = new LoginService(new LoginValidator());

        MemberDao memberDao = new MemberDao();
        JoinValidator joinValidator = new JoinValidator();
        joinValidator.setMemberDao(memberDao);
        joinService = new JoinService(joinValidator, memberDao);

        // 회원 가입
        member = new Member();
        member.setUserId("user01");
        member.setUserPw("12345678");
        member.setUserPwRe("12345678");
        member.setUserNm("사용자01");
        joinService.join(member);

    }

    private void createSuccessData() {
        given(request.getParameter("userId")).willReturn("user01");
        given(request.getParameter("userPw")).willReturn("12345678");
    }

    private void createWrongData(String userId, String userPw) {
        given(request.getParameter("userId")).willReturn(userId);
        given(request.getParameter("userPw")).willReturn(userPw);
    }

    @Test
    @DisplayName("로그인에 성공하면 예외가 발생하지 않음")
    void loginSuccessTest() {
        assertDoesNotThrow(() -> {
            createSuccessData();
            loginService.login(request);
        });
    }

    @Test
    @DisplayName("로그인 필수 항목(userId, userPw) 체크 - 검증 실패 LoginValidationException")
    void loginRequiredFieldTest() {
        assertAll(
                // userId가 null 값
                () -> assertThrows(LoginValidationException.class, () -> {
                    createWrongData(null, "12345678");
                    loginService.login(request);
                }),
                // userId가 빈 값
                () -> assertThrows(LoginValidationException.class, () -> {
                    createWrongData("    ", "12345678");
                    loginService.login(request);
                }),
                // userPw가 null 값
                () -> assertThrows(LoginValidationException.class, () -> {
                    createWrongData("user01", null);
                    loginService.login(request);
                }),
                // userPw가 빈 값
                () -> assertThrows(LoginValidationException.class, () -> {
                    createWrongData("user01", "     ");
                    loginService.login(request);
                })
        );
    }

    @Test
    @DisplayName("등록되지 않은 아이디로 로그인시 LoginValidationException 발생, 예외 메세지 - 가입되지 않은 회원입니다")
    void loginMemberExistsTest() {
        // 회원 가입

        // 회원 가입 계정으로 로그인시 오류 없음

        // 가입 계정과 다른 계정으로 로그인 오류 발생


    }


}
