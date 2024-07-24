package repositories;

import entities.ClientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    /*List<ClientEntity> findAll();

    ClientEntity findById(int clientId);

    @Override
    <S extends ClientEntity> S save(S entity);

    @Modifying
    @Query("update ClientEntity c set " +
            "c.name = :name, c.phone = :phone, c.balancing = :balancing where c.id = :id")
    @Transactional
    void update(@Param("id") int id, @Param("name") String name,
                      @Param("phone") String phone, @Param("balancing") double balancing);*/
}
