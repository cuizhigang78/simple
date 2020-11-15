package tk.mybatis.simple.plugin;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName MyInterceptor
 * @Author Maxwell
 * @Date 2020/11/14 22:06
 * @Description MyInterceptor
 * @Version 1.0
 */
public class MyInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取被当前拦截的对象
        Object target = invocation.getTarget();
        // 获取被当前拦截的方法
        Method method = invocation.getMethod();
        // 获取被当前拦截的方法中的参数
        Object[] args = invocation.getArgs();
        // 执行被拦截对象真正的方法
        Object result = invocation.proceed();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
