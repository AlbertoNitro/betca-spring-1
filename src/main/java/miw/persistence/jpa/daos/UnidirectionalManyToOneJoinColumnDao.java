package miw.persistence.jpa.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import miw.persistence.jpa.entities.UnidirectionalManyToOneJoinColumnEntity;

public interface UnidirectionalManyToOneJoinColumnDao
        extends JpaRepository<UnidirectionalManyToOneJoinColumnEntity, Integer> {
}
