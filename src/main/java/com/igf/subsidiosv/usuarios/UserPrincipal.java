package com.igf.subsidiosv.usuarios;

import com.igf.subsidiosv.rol.Rol;
import com.igf.subsidiosv.rol.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UserPrincipal implements UserDetails {

    @Autowired
    private RolRepository rolRepository;

    private Usuario usuario;

    public UserPrincipal(Usuario usuario) { this.usuario = usuario; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(usuario.getRole()));
    }

    @Override
    public String getPassword() { return usuario.getPassword(); }

    @Override
    public String getUsername() { return usuario.getUsername(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
