package com.poly.truongnvph29176.interceptor;

import com.poly.truongnvph29176.entity.Category;
import com.poly.truongnvph29176.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GlobalInnterceptor implements HandlerInterceptor {
    private final CategoryService categoryService;

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        List<Category> category = categoryService.findAllCategory();
        request.setAttribute("category", category);
    }
}
