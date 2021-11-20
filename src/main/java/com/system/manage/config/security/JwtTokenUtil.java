//package com.system.manage.config.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Clock;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.DefaultClock;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cglib.core.internal.Function;
//import org.springframework.stereotype.Component;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Created by lq
// * @version jdk1.8
// * @description
// * @date 2021/4/12 20:00
// */
//@Component
//public class JwtTokenUtil implements Serializable {
//
//    @Value("${jwt.base64-secret}")
//    private String secret;
//
//    @Value("${jwt.token-validity-in-seconds}")
//    private Long expiration;
//
//    private Clock clock = DefaultClock.INSTANCE;
//
//    /**
//     * 生成token
//     * @param subject
//     * @return
//     */
//    public String generateToken(String subject) {
//        Map<String, Object> claims = new HashMap<>();
//        Date createdDate = clock.now();
//        Date expirationDate = calculateExpirationDate(createdDate);
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(createdDate)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    /**
//     * 计算token存活时间
//     * @param createdDate
//     * @return
//     */
//    private Date calculateExpirationDate(Date createdDate) {
//        return new Date(createdDate.getTime() + expiration);
//    }
//
//    /**
//     * 验证token
//     * @param token
//     * @param username
//     * @return
//     */
//    public Boolean validateToken(String token, String username) {
//        final String tokenUsername = getUsernameFromToken(token);
//        return (tokenUsername.equals(username) && !isTokenExpired(token)
//        );
//    }
//
//    /**
//     * 从token中获取用户名
//     * @param token
//     * @return
//     */
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    /**
//     * 判断token是否存活
//     * @param token
//     * @return
//     */
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = getExpirationDateFromToken(token);
//        return expiration.before(clock.now());
//    }
//
//    /**
//     * 获取存活时间
//     * @param token
//     * @return
//     */
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//}
//
