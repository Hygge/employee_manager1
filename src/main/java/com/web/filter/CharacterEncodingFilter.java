package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决全站乱码问题，处理所有的请求
 */
@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //将父接口转为子接口
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //获取资源路径
        String uri = request.getRequestURI();
        //判断是否包含登录相关资源路径    注意要排除 css/js/图片/验证码等其他资源
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/css/") || uri.contains("/js/")
                || uri.contains("/checkCodeServlet") || uri.contains("/images/") || uri.contains("/assets/")
                || uri.contains("/bootstrap/") || uri.contains("/font/")) {
            //包含代表用户登录放行
            chain.doFilter(request, response);
        } else {
            //不包含，需要用户验证是否登录
            //从获取session中获取对象
            Object adim = request.getSession().getAttribute("yname");
            if (adim != null) {
                //登录，放行
                chain.doFilter(request, response);
            } else {
                //没有登陆跳转登录页面
                request.setAttribute("login_msg", "您尚未登录，请先登录在操作数据！");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                return;
            }

            //获取请求方法
            String method = request.getMethod();
            //解决post请求中文数据乱码问题
            if (method.equalsIgnoreCase("post")) {
                request.setCharacterEncoding("utf-8");
                chain.doFilter(request, response);
            }
            //处理响应乱码
            response.setContentType("text/html;charset=utf-8");


        }
    }
        public void init(FilterConfig config) throws ServletException {

        }

}
