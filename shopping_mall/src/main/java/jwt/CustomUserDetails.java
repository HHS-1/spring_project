package jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {

    private String id, password, permission;

    public CustomUserDetails(String id, String password, String permission) {
        this.id = id;
        this.password = password;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public String getUsername() {
        return String.valueOf(id); 
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // permission에 따라 권한 부여
        if ("M".equals(permission)) {
            return Collections.singletonList(new SimpleGrantedAuthority("SUPER_ADMIN"));
        } else {
            return Collections.singletonList(new SimpleGrantedAuthority("ADMIN"));
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠김 여부
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 자격 증명 만료 여부
    }

    @Override
    public boolean isEnabled() {
        return true; // 활성화 여부
    }
}
