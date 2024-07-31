package jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	//access토큰 생성
	public String createAccessToken(String id, String permission) {
		Claims claims = Jwts.claims();
		claims.put("id", id);
		claims.put("permission", permission);
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+86400*1000)) 
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
	
	//refresh토큰 생성
	public String createRefreshToken(String id) {
		return Jwts.builder()
				.setSubject(id)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+86400*1000*24))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
	
	//token을 파싱하여 user의 정보가 담긴 Claim 추출 (복호화)
	public Claims parseToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	
	//Claim에서 id 추출
	public String getId(String token) {
		return parseToken(token).get("id").toString();
	}
	
	//Claim에서 permission 추출
	public String getPermission(String token) {
		return parseToken(token).get("permission").toString();
	}
	
	//Token 유효성 검사
	public boolean isTokenExpired(String token) {
        return parseToken(token).getExpiration().before(new Date());
    }
}
