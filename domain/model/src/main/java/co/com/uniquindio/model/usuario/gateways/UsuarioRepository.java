package co.com.uniquindio.model.usuario.gateways;

import co.com.uniquindio.model.usuario.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario guardarUsuario(Usuario Usuario);

    Usuario findByUsername(String username);

    Usuario obtenerUsuarioPorId(Long id);

    List<Usuario> listarUsuario();

    void eliminarUsuario(Long id);
}
