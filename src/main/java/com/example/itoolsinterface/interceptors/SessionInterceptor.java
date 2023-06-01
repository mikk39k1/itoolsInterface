package com.example.itoolsinterface.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && (session.getAttribute("user") != null)) {
            return true;
        } else {
            response.sendRedirect("/accessDenied"); // Redirect to access denied or login page
            return false;
        }
    }
}
