package cc.mrbird.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

// @Component
// @WebFilter(urlPatterns = {"/*"})
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化 1 ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始执行过滤器 2");
        Long start = new Date().getTime();
        //todo  以下的方法注释掉的话，拦截器就不会走
       filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("【过滤器】耗时 " + (new Date().getTime() - start)+" =12");
        System.out.println("结束执行过滤器 =13");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
