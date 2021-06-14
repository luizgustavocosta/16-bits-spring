package com.costa.luiz.multitenancy;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class TenantRequestInterceptor implements AsyncHandlerInterceptor {

    private SecurityDomain securityDomain;

    public TenantRequestInterceptor(SecurityDomain securityDomain) {
        this.securityDomain = securityDomain;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return Optional.ofNullable(request)
                .map(req -> securityDomain.getTenantIdFromJwt(req))
                .map(TenantContext::setCurrentTenant)
                .orElse(false);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }
}
