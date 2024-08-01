package jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;
import utility.CookieUtil;


@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private CustomUserDetailsService adminDetailsService;
	@Autowired 
	private JwtUtil jwtUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.info("JwtFilter is called.");
		
		String refreshToken = CookieUtil.getCookie(req, "refreshToken");
		if(refreshToken == null || refreshToken.isEmpty() ||jwtUtil.isTokenExpired(refreshToken)) {
			res.sendRedirect("/login/api");
			return;
		}
		
		final String authorization = req.getHeader("Authorization");
		String userId = null;
		String token = null;
		
		
		
		if(authorization != null && authorization.startsWith("bearer ")) {
			token = authorization.substring(7);
			userId = this.jwtUtil.getId(token);
		}
		
		if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.adminDetailsService.loadUserByUsername(userId);
				
			if(!this.jwtUtil.isTokenExpired(token)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
			
		filterChain.doFilter(req, res);
		
		
	}
}
