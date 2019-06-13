package com.spring.cloud.filter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyZuulPreFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() {
		
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getServletPath());
        Cookie[] cookies = request.getCookies();
        HttpSession session=request.getSession();
        System.out.println(session.getId());
        if(cookies==null || cookies.length==0) {
        	System.out.println("不通过自定义的路由器.......");
            //shouldNotFilter(ctx);
            ctx.setSendZuulResponse(true);
            //设置返回码
            ctx.setResponseStatusCode(200);

            ctx.set("isSuccess",false);

            return null;
        }else {
        	System.out.println("通过自定义的路由器.......");
            //不进行路由
            ctx.setSendZuulResponse(true);
            //设置返回码
            ctx.setResponseStatusCode(200);

            ctx.set("isSuccess",false);

            return null;
        }
	}

	@SuppressWarnings("unused")
	private void shouldNotFilter(RequestContext ctx) {
		// TODO Auto-generated method stub
		//不进行路由
        ctx.setSendZuulResponse(false);
        //设置返回码
        ctx.setResponseStatusCode(401);
        //设置返回体
        ctx.setResponseBody("权限不够");
        ctx.set("isSuccess",false);
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
