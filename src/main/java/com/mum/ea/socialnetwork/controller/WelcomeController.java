package com.mum.ea.socialnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@Controller
@RestController
public class WelcomeController {
    private TokenStore tokenStore = new InMemoryTokenStore();

    @GetMapping("/")
    private String welcome(Model model){

        model.addAttribute("msg", "Hello Message");

        return "index";
    }


    @GetMapping("/getUser")
    private String getUser()
    {
        String username="";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        return username;
    }

    @Autowired
    private DefaultTokenServices tokenServices;


    @RequestMapping(value = "/SignOut",method= RequestMethod.GET)
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // token can be revoked here if needed
        new SecurityContextLogoutHandler().logout(request, null, null);
            request.logout();
            //sending back to client app
            response.sendRedirect(request.getHeader("referer"));

    }

    @RequestMapping(value = "isAthenticated")
    public String isAthenticated(HttpServletRequest request) {
        String user=request.getUserPrincipal().getName();
        return user;
    }

}
