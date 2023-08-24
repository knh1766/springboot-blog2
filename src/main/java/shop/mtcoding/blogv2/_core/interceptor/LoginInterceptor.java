package shop.mtcoding.blogv2._core.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import shop.mtcoding.blogv2._core.util.Script;
import shop.mtcoding.blogv2.user.User;

public class LoginInterceptor implements HandlerInterceptor {
    //리턴이 트루이면 컨트롤러 메서드진입
    //리턴이 펄스이면 요청이 종료됨
     @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                System.out.println("loginInterceptor  preHandle");
                HttpSession session = request.getSession();
                User sessionUser = (User) session.getAttribute("sessionUser");

                if(sessionUser == null){
                    
                    response.setHeader("Content-Type", "text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    System.out.println(Script.href("/loginForm", "인증이필요합니다"));
                    return false;

                }
              return true;  
        //return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("loginInterceptor postHandle");
    }

   
    
}
