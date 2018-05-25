package miw.persistence.jpa.daos;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import miw.persistence.jpa.entities.UnRelatedEntity;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, Integer> {

    // Consulta: por Nombre de Método
    UnRelatedEntity findByNickIgnoreCase(String nick);

    List<UnRelatedEntity> findFirst3ByNickStartingWith(String prefix);

    List<UnRelatedEntity> findByNickOrLargeOrderByIdDesc(String nick, String large);

    List<UnRelatedEntity> findByIdGreaterThan(int id, Pageable pageable);

    List<UnRelatedEntity> findByNickIn(Collection<String> values);

    // Consulta: JPQL
    // ?1 ?2 ?3...
    // :name ... @Param("name")
    @Query("select u.nick from un_related u where u.nick like ?1")
    List<String> findNickByNickLike(String nick);

    @Query("select u.id from un_related u where u.id > ?1 and u.id < ?2")
    List<Integer> findIdByIdBetween(int initial, int end);

    // Consulta: SQL
    @Query(value = "SELECT * FROM un_related WHERE KCIN = ?1", nativeQuery = true)
    UnRelatedEntity findByNick(String nick);

    @Transactional
    int deleteByNick(String nick);

    @Transactional
    int deleteByIdGreaterThan(int value);

    @Modifying
    @Transactional
    @Query(value = "delete from un_related u where u.nick = ?1")
    void deleteByNickQuery(String nick);

}
