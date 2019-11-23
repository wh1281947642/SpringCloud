package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * <code>LoginFilter</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2019/10/24 18:25
 */

@Component
public class LoginFilter extends ZuulFilter {
    
    /**
     * 过滤器的类型: pre route post error
     *
     * @param
     * @return 
     * @description TODO
     * @author huiwang45@iflytek.com
     * @date 2019/10/24 18:26
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     *  执行顺序,返回值越小，优先级越高
     *
     * @param
     * @return 
     * @description TODO
     * @author huiwang45@iflytek.com
     * @date 2019/10/24 18:27
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 是否执行该过滤器
     *  true:执行run方法
     * @param
     * @return 
     * @description TODO
     * @author huiwang45@iflytek.com
     * @date 2019/10/24 18:28
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *  编写过滤器的业务逻辑
     *
     * @param
     * @return 
     * @description TODO
     * @author huiwang45@iflytek.com
     * @date 2019/10/24 18:29
     */
    @Override
    public Object run() throws ZuulException {
        //初始化context上下文对象,servlet  spring
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //获取参数
        String token = request.getParameter("token");
        if(StringUtils.isBlank(token)){
            //拦截,不转发请求
            currentContext.setSendZuulResponse(false);
            //响应状态码,401-身份未认证
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            //设置响应的提示
            currentContext.setResponseBody("requst error!");
        }
        //返回值为null，就代表过滤器什么都不做
        return null;
    }
}
