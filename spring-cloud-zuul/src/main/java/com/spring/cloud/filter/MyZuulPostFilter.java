package com.spring.cloud.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


@Component
public class MyZuulPostFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getServletPath());
        Cookie[] cookies = request.getCookies();
        HttpSession session=request.getSession();
        System.out.println(session.getId());
    	System.out.println("不通过自定义的路由器.......");
        //shouldNotFilter(ctx);
        ctx.setSendZuulResponse(true);
        //设置返回码
        ctx.setResponseStatusCode(200);

        ctx.set("isSuccess",false);
        return null;

	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 100;
	}

}
