package dev.nassime.restaurant1.api.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import dev.nassime.restaurant1.entities.Client;
import dev.nassime.restaurant1.entities.dao.ClientDao;
import dev.nassime.restaurant1.services.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JWTRequestFilter extends OncePerRequestFilter {
    private JWTService jwtService;
    private ClientDao clientDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            try {
                String username = jwtService.getUsername(token);
                Optional<Client> opClient = clientDao.findByUsernameIgnoreCase(username);
                if (opClient.isPresent()) {
                    Client client = opClient.get();
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(client, null, new ArrayList());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (JWTDecodeException ex) {
            }
        }
        filterChain.doFilter(request, response);
    }
}
