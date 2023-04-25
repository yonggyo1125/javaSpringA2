package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class MockExam2Test {

    @Mock
    private HttpServletRequest request;
    private LoginService service;

    @BeforeEach
    void init() {
        //request = mock(HttpServletRequest.class); // 모의 객체
        given(request.getParameter("userId")).willReturn("user01"); // 스텁
        given(request.getParameter("userPw")).willReturn("12345678");

        service = new LoginService();
    }

    private void changeParamter(String key, String value) {
        given(request.getParameter(key)).willReturn(value);
    }

    @Test
    @DisplayName("로그인 성공시 예외 없음")
    void loginSuccessTest() {

        assertDoesNotThrow(() -> {
            service.login(request);
        });

    }
    
    @Test
    @DisplayName("필수 항목 검증(userId, userPw) - 검증 실패시 LoginValidationException")
    void loginTest() {


        assertThrows(LoginValidationException.class, () -> {
            // userId가 null
            changeParamter("userId", null);
            service.login(request);
        });

        assertThrows(LoginValidationException.class, () -> {
            // userId가 빈 공백
            changeParamter("userId", "  ");
            service.login(request);
        });

        assertThrows(LoginValidationException.class, () -> {
            // userPw가 null
            changeParamter("userId", "user01");
            changeParamter("userPw", null);
            service.login(request);
        });

        assertThrows(LoginValidationException.class, () -> {
            // userPw가 빈 공백
            changeParamter("userId", "user01");
            changeParamter("userPw", "    ");
            service.login(request);
        });
    }
}
