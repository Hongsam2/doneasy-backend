package com.doneasy.don.web.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@Slf4j
@Service
public class JwtTokenService {

    @Value("${secretkey}")
    private String secretkey;

    // 토큰 발급
    public String makeJwtToken(String memberId, String organizationId) {
        Date date = new Date();
        if (memberId != null && organizationId == null) {
            return Jwts.builder()
                    .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더에 JWT 토큰임을 표시
                    .setIssuer("donzo") // 토큰 발급자 donzo로 설정
                    .setIssuedAt(date) // 발급 일자 현재 시간
                    .setExpiration(new Date(date.getTime() + Duration.ofMinutes(30).toMillis())) // 만료시간 현재 시간 + 30분
                    .claim("member", memberId) // 담을 정보 아이디
                    .signWith(SignatureAlgorithm.HS256, secretkey) // 전자서명
                    .compact();
        }
        if (memberId == null && organizationId != null) {
            return Jwts.builder()
                    .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더에 JWT 토큰임을 표시
                    .setIssuer("donzo") // 토큰 발급자 donzo로 설정
                    .setIssuedAt(date) // 발급 일자 현재 시간
                    .setExpiration(new Date(date.getTime() + Duration.ofMinutes(30).toMillis())) // 만료시간 현재 시간 + 30분
                    .claim("organization", organizationId) // 담을 정보 아이디
                    .signWith(SignatureAlgorithm.HS256, secretkey) // 전자서명
                    .compact();
        }
        return null;
    }

    public Claims parseJwtToken(String authorizationHeader) {
        validationAuthorizationHeader(authorizationHeader);
        String token = extractToken(authorizationHeader);
        return Jwts.parser()
                .setSigningKey(secretkey) // secretkey를 넣어 토큰 해석
                .parseClaimsJws(token) // 해석할 토큰 주입
                .getBody();
    }

    // 헤더 토큰 검증
    private void validationAuthorizationHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("토큰 에러!!");
        }
    }

    // 헤더 문자열 분리
    private String extractToken(String token) {
        return token.substring("Bearer ".length());
    }
}
