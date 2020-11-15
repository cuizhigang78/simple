package tk.mybatis.simple.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.*;

/**
 * @ClassName CameHumpInterceptor
 * @Author Maxwell
 * @Date 2020/11/15 19:13
 * @Description CameHumpInterceptor
 * @Version 1.0
 */
@Intercepts(
        @Signature(
                type = ResultSetHandler.class,
                method = "handleResultSets",
                args = {Statement.class}
        )
)
public class CameHumpInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 先执行得到结果，再对结果进行处理
        List<Object> list = (List<Object>) invocation.proceed();

        List<Object> rtList = new ArrayList<Object>();

        for (Object obj : list) {
            // 如果结果是Map类型，就对Map的key进行转换
            if (obj instanceof Map) {
                obj = processMap((Map) obj);
            }
            rtList.add(obj);
        }
        return rtList;
    }

    /**
     * 处理Map类型
     * @param map
     */
    private Map<String, Object> processMap(Map<String, Object> map) {
        Map<String, Object> rtMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if ((key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') || key.contains("_")) {
                key = underlineToCamelHump(key);
            }
            rtMap.put(key, value);
        }
        return rtMap;
    }

    /**
     * 将下划线风格替换为驼峰风格
     * @param inputString
     * @return
     */
    private String underlineToCamelHump(String inputString) {
        StringBuilder sb = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
