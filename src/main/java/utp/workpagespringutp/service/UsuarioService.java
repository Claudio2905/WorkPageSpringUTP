package utp.workpagespringutp.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import utp.workpagespringutp.model.Usuario;
@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public boolean registrarUsuario(Usuario usuario) {
        if (existeUsuario(usuario.getUsername())) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    // Metodo para verificar si un usuario existe
    public boolean existeUsuario(String username) {
        return usuarios.stream()
                .anyMatch(u -> u.getUsername().equals(username));
    }

    // Metodo para iniciar sesión
    public boolean iniciarSesion(String username, String password) {
        return usuarios.stream()
                .anyMatch(u -> u.getUsername().equals(username) &&
                        u.getPassword().equals(password));
    }

    // Metodo para obtener un usuario
    public Optional<Usuario> obtenerUsuario(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }
}
