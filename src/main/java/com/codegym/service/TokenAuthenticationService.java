package com.codegym.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenAuthenticationService {

    static final long EXPIRATIONTIME = 864_000_000; // 10 days

    static final String SECRET = "ThisIsASecret";

    static final String TOKEN_PREFIX = "Bearer";

    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletResponse res, String username) throws IOException {
        String JWT = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        // Nên trả token dạng json thay vì trong header
        // Có thể trả thêm nhiều data như refrestToken, thông tin user login như name, email, bithday, ... (không cần gọi thêm request)
        //res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);

        Map<String, String> tokenMap = new HashMap<String, String>();
        tokenMap.put("token", JWT);

        res.setStatus(HttpStatus.OK.value());
        res.setContentType(MediaType.APPLICATION_JSON_VALUE);

        //create Json Object
        ObjectMapper objectMapper = new ObjectMapper();

        PrintWriter out = res.getWriter();

        out.print(objectMapper.writeValueAsString(tokenMap));
        out.flush();
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
                    .getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
        }
        return null;
    }

}
