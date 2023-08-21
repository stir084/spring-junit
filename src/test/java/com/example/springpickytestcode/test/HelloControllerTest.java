package com.example.springpickytestcode.test;

import com.example.springpickytestcode.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = HelloController.class)
@AutoConfigureMockMvc(addFilters = false)
     /*   excludeFilters = { //!Added!
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyInterceptor.class) })*/
public class HelloControllerTest {
    @Test
    void test(){
        System.out.println("하이");
    }
}
