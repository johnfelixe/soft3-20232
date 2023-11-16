package co.com.uniquindio.jpa.usuario;

import co.com.uniquindio.jpa.helper.AdapterOperations;
import co.com.uniquindio.model.exception.JPAException;
import co.com.uniquindio.model.usuario.Usuario;
import co.com.uniquindio.model.usuario.gateways.UsuarioRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
public class JPAUsuarioRepositoryAdapter extends AdapterOperations<Usuario, UsuarioDTO, Long, JPAUsuarioRepository>
        implements UsuarioRepository, UserDetailsService {


    @Autowired
    private JPAUsuarioRepository jpaUsuarioRepository;

    private Logger logger = LoggerFactory.getLogger(JPAUsuarioRepositoryAdapter.class);

    public JPAUsuarioRepositoryAdapter(JPAUsuarioRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDTO usuario = jpaUsuarioRepository.findByUsername(username);

        if (usuario == null) {
            logger.error("Error en el login: No existe el usuario '" + username + "' en el sistema!");
            throw new UsernameNotFoundException("Error en el login: No existe el usuario '" + username + "' en el sistema!");
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_".concat(usuario.getRole())));


        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
    }

    @Override
    public Usuario guardarUsuario(Usuario var) {
        return super.save(var);
    }

    public Usuario findByUsername(String username) {
        UsuarioDTO usuarioDTO;
        Usuario usuario;

        try {
            usuarioDTO = jpaUsuarioRepository.findByUsername(username);

        } catch (RuntimeException e) {
            throw new JPAException(e.getMessage() + ", en tabla usuarios");
        }
        usuario = mapper.map(usuarioDTO, Usuario.class);

        return usuario;
    }


    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return super.findById(id);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return super.findAll();
    }

    @Override
    public void eliminarUsuario(Long id) {
        super.delete(id);

    }


}