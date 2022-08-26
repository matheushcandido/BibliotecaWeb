package biblioteca.BibliotecaWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import biblioteca.BibliotecaWeb.models.Livro;

public interface LivrosRepo extends CrudRepository<Livro, Integer>{

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from livro where id = :id", nativeQuery = true)
    public boolean exist(int id);
    
}
