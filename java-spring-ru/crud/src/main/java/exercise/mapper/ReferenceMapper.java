package exercise.mapper;

import exercise.dto.CategoryDTO;
import exercise.model.Category;
import exercise.model.Product;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import exercise.model.BaseEntity;
import jakarta.persistence.EntityManager;

import java.lang.ref.Reference;

// BEGIN
@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING
)
public abstract class ReferenceMapper {
    @Autowired
    private EntityManager entityManager;

    public <T extends BaseEntity> T toEntity(Long id, @TargetType Class<T> entityClass) {
        return id != null ? entityManager.find(entityClass, id) : null;
    }
}
// END
