package utp.workpagespringutp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.workpagespringutp.model.Usuario;
import utp.workpagespringutp.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public boolean registrarUsuario(Usuario usuario) {
        if (existeUsuario(usuario.getUsername())) {
            return false;
        }
        usuarioRepository.save(usuario);
        return true;
    }

    // Metodo para verificar si un usuario existe
    public boolean existeUsuario(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    // Metodo para iniciar sesión
    public boolean iniciarSesion(String username, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        return usuario.isPresent() && usuario.get().getPassword().equals(password);
    }

    // Metodo para obtener un usuario
    public Optional<Usuario> obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }
}
