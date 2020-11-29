package com.uncleray.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.uncleray.web.model.query.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: uncle-springboot
 * @description: JWT工具类
 * @author: lei pei
 * @create: 2020-11-29 12:13
 */
public class JWTUtils {

    private static final String SIGN = "1qaz@WSX#EDC";

    /**
     * 签名 生成token
     *
     * @param user
     * @return
     */
    public static String sign(User user) {
        // head.payLoad.signature
        HashMap map = new HashMap();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 2000);//过期时间
        String sign = JWT.create()
                .withClaim("user", map)
                .withExpiresAt(calendar.getTime())//过期时间
                .sign(Algorithm.HMAC256(SIGN));//密钥签名
        return sign;
    }

    /**
     * 验签
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> verify(String token) {
        // 验签 根据 HS256算法 私玥 验签token
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SIGN)).build();
        DecodedJWT verify = verifier.verify(token);
        Map<String, Claim> claims = verify.getClaims();
        return claims;
    }

}
