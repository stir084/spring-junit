package com.example.springpickytestcode.test;

import com.example.springpickytestcode.HelloController;
import com.example.springpickytestcode.MyInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@Import(MyInterceptor.class)
public class HelloControllerTest2 {

    @InjectMocks
    private HelloController helloController;
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController)
                .build();
    }

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/hello"))  // Replace with the appropriate endpoint
                .andExpect(status().isOk());
    }
}
