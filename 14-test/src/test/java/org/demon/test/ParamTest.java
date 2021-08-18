package org.demon.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class ParamTest {

    @ParameterizedTest
    @ValueSource(strings = {"selina", "hebe", "ella"})
    @DisplayName("Value Source Test")
    void valueSourceTest(String string){
        System.out.println(string);
    }

    @ParameterizedTest
    @MethodSource("method")
    @DisplayName("Method Source Test")
    void methodSourceTest(String string){
        System.out.println(string);
    }

    static Stream<String> method(){
        return Stream.of("陆青时", "林厌", "南泱");
    }
}
