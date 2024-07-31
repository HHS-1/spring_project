package jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailsService adminDetailsService;
	@Autowired 
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		
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
