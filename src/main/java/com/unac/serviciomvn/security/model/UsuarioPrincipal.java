package com.unac.serviciomvn.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings({"serial","unused"})
public class UsuarioPrincipal implements UserDetails {
    private String nombreUsuario;
    private String password;
    private String imagenUser;
	private Boolean estadoContrato;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombreUsuario, String password, String imagenUser
    		,Boolean estadoContrato, Collection<? extends GrantedAuthority> authorities) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.imagenUser = imagenUser;
        this.estadoContrato = estadoContrato;
        this.authorities = authorities;
        
    }

    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombreUsuario(), usuario.getPassword()
        		, usuario.getImagenUser(), usuario.getEstadoContrato() , authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
