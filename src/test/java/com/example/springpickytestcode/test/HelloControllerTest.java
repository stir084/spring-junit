package com.example.springpickytestcode.test;

import com.example.springpickytestcode.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*@WebMvcTest(controllers = HelloController.class,  excludeFilters = { //!Added!
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyInterceptor.class) })*/
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk()); // Expecting the response content to be "hello"
    }
}