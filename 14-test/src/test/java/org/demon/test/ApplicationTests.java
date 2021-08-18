package org.demon.test;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @DisplayName("测试")
    @Test
    void contextLoads() {
        System.out.println("hello world");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("before each ...");
    }

    @AfterEach
    void afterEach(){
        System.out.println("after each ...");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("before all ...");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all ...");
    }

    @Disabled
    @RepeatedTest(value = 7)
    void repeatedTest(){
        System.out.println("repeat test ...");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void timeoutTest() throws InterruptedException {
        Thread.sleep(600);
    }

    /*======================= 断言测试 ========================*/
    @Test
    @DisplayName("简单断言测试")
    void simpleTest(){
        /**
         * 前面的断言失败，则后面的不会再执行
         */
        assertEquals(3, 1 + 2);
        // assertSame(new Object(), new Object());
        assertFalse(1 == 2);
    }

    @Test
    @DisplayName("数组断言测试")
    void arrayTest(){
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    @Test
    @DisplayName("组合断言测试")
    void allTest(){
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0));
    }

    @Test
    @DisplayName("异常断言测试")
    void exceptionTest(){
        assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0));
    }

    @Test
    @DisplayName("超时断言测试")
    void timeoutATest(){
        assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("快速失败测试")
    void failTest(){
        fail("快速失败");
    }

    /*======================= 前置条件 ========================*/
    @Test
    @DisplayName("前置条件测试")
    void assumptionTest(){
        Assumptions.assumeTrue(false, "不满足测试条件");
        System.out.println("gl yyds");
    }
}
