package utp.workpagespringutp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.workpagespringutp.model.Usuario;
import utp.workpagespringutp.repository.UsuarioRepository;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // Registrar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            return false;
        }
        usuarioRepository.save(usuario);
        return true;
    }
    
    // Iniciar sesión
    public boolean iniciarSesion(String username, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        return usuario.isPresent() && usuario.get().getPassword().equals(password);
    }
    
    // Obtener un usuario por username
    public Optional<Usuario> obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }
    
    // Actualizar usuario
    public boolean actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
            usuarioRepository.save(usuario);
            return true;
        }
        return false;
    }
    
    // Eliminar cuenta
    public boolean eliminarCuenta(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}