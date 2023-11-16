package co.com.uniquindio.usecase.usuario;

import co.com.uniquindio.model.usuario.Usuario;
import co.com.uniquindio.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.guardarUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuario();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.obtenerUsuarioPorId(id);
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.eliminarUsuario(id);
    }


}
