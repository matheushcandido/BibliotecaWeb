package biblioteca.BibliotecaWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import biblioteca.BibliotecaWeb.models.Agenda;

public interface AgendasRepo extends CrudRepository<Agenda, Integer> {

    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END from agenda where id = :id", nativeQuery = true)
    public boolean exist(int id);
    
}
