package com.uncleray.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.uncleray.config.exception.ApiException;
import com.uncleray.util.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * @program: uncle-springboot
 * @description: 认证拦截器
 * @author: lei pei
 * @create: 2020-11-24 23:04
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            Annotation annotation = method.getMethodAnnotation(GetMapping.class);
        }
        //token一般放在请求头里，更安全
        String token = request.getHeader("token");
        try {
            JWTUtils.verify(token);
        } catch (TokenExpiredException tokenExpiredException) {
            throw new ApiException(400, "token已经过期");
        } catch (SignatureVerificationException signatureVerificationException) {
            throw new ApiException(400, "签名验证不通过");
        } catch (AlgorithmMismatchException algorithmMismatchException) {
            throw new ApiException(400, "生成token的算法不匹配");
        } catch (NullPointerException nullPointerException) {
            throw new ApiException(400, "token不存在");
        } catch (Exception exception) {
            throw new ApiException(400, exception.getMessage());
        }
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().println();
        return true;
    }
}
