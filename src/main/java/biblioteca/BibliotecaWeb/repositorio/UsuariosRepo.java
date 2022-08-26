package biblioteca.BibliotecaWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import biblioteca.BibliotecaWeb.models.Usuario;


public interface UsuariosRepo extends CrudRepository<Usuario, Integer> {

    @Query(value="select * from usuario where email = :email and senha = :senha", nativeQuery = true)
    public Usuario Login(String email, String senha);
    
}
