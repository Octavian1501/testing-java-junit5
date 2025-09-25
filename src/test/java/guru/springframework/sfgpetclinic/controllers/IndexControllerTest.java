package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest implements ControllerTests {
    IndexController controller;

    @BeforeEach
    void setUp() {
        controller =  new IndexController();
    }

    @DisplayName("Test Proper View name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong View Returned");

        assertEquals("index", controller.index(), () -> "Another Expensive Message. " +
                "Make me if you have to");

        assertThat(controller.index()).isEqualTo("index");

    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeoutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(5000);

            System.out.println("I got here 123456789");
        });
    }

    @Test
    void testAssumptionTrue() {
        Assumptions.assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        Assumptions.assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.LINUX)
    @Test
    void testMeOnLinuxOS() {

    }

    @EnabledOnJre(JRE.JAVA_17)
    @Test
    void testMeOnJava17() {

    }

    @EnabledIfEnvironmentVariable(named = "USER", matches="octavian")
    @Test
    void testIfUserOctavian() {

    }

}