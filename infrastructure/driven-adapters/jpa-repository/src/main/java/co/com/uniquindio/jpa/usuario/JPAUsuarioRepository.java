package co.com.uniquindio.jpa.usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAUsuarioRepository extends CrudRepository<UsuarioDTO, Long>, QueryByExampleExecutor<UsuarioDTO> {

    public UsuarioDTO findByUsername(String username);


}