package org.demicon.tech.task.d3.cloud.repository.querydsl;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface QuerydslRepository<T, ID> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {

    @Override
    @NonNull
    List<T> findAll(@NonNull Predicate predicate);

    @Override
    @NonNull
    List<T> findAll(@NonNull Predicate predicate, @NonNull Sort sort);

    @Override
    @NonNull
    List<T> findAll(@NonNull Predicate predicate, @NonNull OrderSpecifier<?>... orders);

    @Override
    @NonNull
    List<T> findAll(@NonNull OrderSpecifier<?>... orders);

    @Override
    @NonNull
    Page<T> findAll(@NonNull Predicate predicate, @NonNull Pageable pageable);
}
