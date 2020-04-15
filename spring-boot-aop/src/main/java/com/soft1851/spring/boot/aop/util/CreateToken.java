package com.soft1851.spring.boot.aop.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wl
 * @ClassNameCreateToken
 * @Description TODO
 * @Date 2020/1/13
 * @Version 1.0
 */
@Slf4j
public class CreateToken {
    /**
     * 生成token
     *
     * @param num
     * @return
     */
    public static String getToken(String num, String rolecode) {
        //密匙
        String key = "NiitScsWL";
        Date start = new Date();
        //一小时有效时间

        LocalDateTime localDateTime=LocalDateTime.now().plusDays(30);
        //locadatetime转换成date

        ZoneId zoneId =ZoneId.systemDefault();
        ZonedDateTime zonedDateTime =localDateTime.atZone(zoneId);
        Date end = Date.from(zonedDateTime.toInstant());
        System.out.println(end);
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");


        String token = JWT.create().withHeader(map).withClaim("uid", num).withClaim("rolecode", rolecode)
                .withIssuer("niit").withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(key));
        System.out.println(token);
        return token;
    }
    /**
     * 获取登陆用户ID
     * @param token
     * @return
     */


    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            //获得num
            return jwt.getClaim("uid").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获取登陆用户ID
     *
     * @param token
     * @return
     */
    public static String getUserRolecode(String token) {
        try {

            DecodedJWT jwt = JWT.decode(token);
            //获得num
            return jwt.getClaim("rolecode").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 判断token是否合法
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            //密匙
            String key = "NiitScsWL";


            Algorithm algorithm = Algorithm.HMAC256(key);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            //判断时间等等是否合法
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {

            return false;
        }
    }
    /**
     * 正则替换所有特殊字符
     * @param orgStr
     * @return
     */
    public static String replaceSpecStr(String orgStr){
        if (null!=orgStr&&!"".equals(orgStr.trim())) {
            String regEx="[\\s~·`!！@#￥$%^……&*（()）\\-——\\-_=+【\\[\\]】｛{}｝\\|、\\\\；;：:‘'“”\"，,《<。.》>、/？?]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(orgStr);
            return m.replaceAll("");
        }
        return null;
    }






    public static void main(String[] args) {
        String num = "123";
        String password = "123";
        String token = CreateToken.getToken(num, "0");

        String loginstate = CreateToken.getUserId("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlY29kZSI6IjAiLCJ1aWQiOiIxODAyMzQzMTM5IiwiaXNzIjoibmlpdCIsImV4cCI6MTU4OTM2NjY1NCwiaWF0IjoxNTg2Nzc0NjU0fQ.BNF4BWOeX7GUGqKi5DezQDBDOuDDpQa3O4BOjdFe9Aw");
        System.out.println(loginstate);
        String loginstate1 = CreateToken.getUserRolecode(token);
        System.out.println(loginstate1);
        System.out.println(CreateToken.verify(token));
        log.error("XXXXX");
    }

}


















