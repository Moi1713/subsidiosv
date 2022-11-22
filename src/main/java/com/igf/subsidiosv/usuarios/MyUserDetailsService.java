package com.igf.subsidiosv.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario==null) {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }

        //return new org.springframework.security.core.userdetails.User(userDetails.getUserName(), userDetails.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(userDetails.getRole())));

        return new UserPrincipal(usuario);
    }
}
