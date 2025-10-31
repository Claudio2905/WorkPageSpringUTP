package utp.workpagespringutp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.workpagespringutp.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByUsername(String username);
    Optional<Usuario> findByUsername(String username);
}
