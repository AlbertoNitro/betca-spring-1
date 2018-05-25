package miw.injection;

import miw.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@TestConfig
public class InjectionMainMessageServiceMockTest {

    @MockBean
    private SingletonMessageService singletonMessageService;

    @Autowired
    private InjectionMain mainInjection;

    @Test
    public void testGetMessage() {
        given(this.singletonMessageService.getMessage()).willReturn("ok");

        assertEquals("ok", this.mainInjection.getMessage());
    }
}
