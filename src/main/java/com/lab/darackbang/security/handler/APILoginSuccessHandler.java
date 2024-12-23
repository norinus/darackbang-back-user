package com.lab.darackbang.security.handler;

import com.google.gson.Gson;
import com.lab.darackbang.common.utils.JWTUtil;
import com.lab.darackbang.security.dto.LoginDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
public class APILoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        // 리디렉션 추가. 로그인 성공 후 전환시킬 페이지*/
        LoginDTO loginDTO = (LoginDTO) authentication.getPrincipal();

        // LoginDTO에서 역할을 가져오고 "ROLE_" 접두사를 제거
        List<String> roleNamesWithoutPrefix = loginDTO.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority) // GrantedAuthority에서 역할 이름을 가져옴
                .map(role -> role.replace("ROLE_", "")) // "ROLE_" 접두사를 제거
                .collect(Collectors.toList()); // List<String>으로 변환

        // 사용자 정보 생성
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", loginDTO.getUsername());
        claims.put("roleNames", roleNamesWithoutPrefix);
        // 10분짜리 JWT 생성
        String token = JWTUtil.generateToken(claims, 10);

        claims.put("token", token);
        claims.put("memberState", loginDTO.getMemberState());
        Gson gson = new Gson();

        // JWT를 응답으로 전송
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(gson.toJson(claims));
    }
}
