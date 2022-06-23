package com.spring5.practice.config;

import com.spring5.practice.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        //User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User authUser = (User) authentication.getPrincipal();
        session.setAttribute("user", authUser);
        session.setAttribute("username", authUser.getName());
        session.setAttribute("authorities", authentication.getAuthorities());


        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);



        if(authUser.getRole().toString().contains("ROLE_ADMIN")) {
            response.sendRedirect("/user/maintain/");
        } else {
            response.sendRedirect("/user/show/"+authUser.getId());
        }

        //since we have created our custom success handler, its up to us, to where
        //we will redirect the user after successfully login
        // SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
//        String requestUrl = savedRequest.getRedirectUrl();
        //response.sendRedirect(savedRequest.getRedirectUrl().isEmpty() ? "/" : savedRequest.getRedirectUrl()); //requestUrl!=null?requestUrl:
    }
}
