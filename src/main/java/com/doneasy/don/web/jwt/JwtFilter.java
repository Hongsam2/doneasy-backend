package com.doneasy.don.web.jwt;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;

@Slf4j
@RequiredArgsConstructor
@Order(1)
@WebFilter(urlPatterns = "/admin/token")
public class JwtFilter implements Filter {

    private final JwtTokenService jwtTokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("JWTFILTER INIT!!!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("JWTFILTER");
        HttpServletRequest req = (HttpServletRequest) request;
        Iterator<String> stringIterator = req.getHeaderNames().asIterator();
        while (stringIterator.hasNext()) {
            log.info(stringIterator.next());
        }
        String authorizationHeader = req.getHeader("Authorization");
        log.info("header: {}", authorizationHeader);
        Claims claims = jwtTokenService.parseJwtToken(authorizationHeader);
        request.setAttribute("memberId", claims.get("member", String.class));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
