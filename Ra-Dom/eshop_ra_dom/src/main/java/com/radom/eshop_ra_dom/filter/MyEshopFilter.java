package com.radom.eshop_ra_dom.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Slf4j
public class MyEshopFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.trace("------> my eshop filter implementation :::before::: do filter chain");

        chain.doFilter(request, response);

        log.trace("------> my eshop filter implementation :::after::: do filter chain");
    }
}