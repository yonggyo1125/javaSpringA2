package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class MockExam2Test {

    private HttpServletRequest request;

    @BeforeEach
    void init() {
        request = mock(HttpServletRequest.class); // 모의 객체
        given(request.getParameter("userId")).willReturn("user01"); // 스텁
        given(request.getParameter("userPw")).willReturn("12345678");
    }
    
    @Test
    @DisplayName("로그인 성공시 예외 없음")
    void loginSuccessTest() {
        
    }
    
    @Test
    @DisplayName("필수 항목 검증(userId, userPw) - 검증 실패시 LoginValidationException")
    void loginTest() {

    }
}
