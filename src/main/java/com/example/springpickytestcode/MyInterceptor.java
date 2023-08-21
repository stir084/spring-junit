package com.example.springpickytestcode;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class MyInterceptor implements HandlerInterceptor {
    // private final TempComp tempComp;
    private final TempComp tempComp;
    // 핸들러 인터셉터 구현
}