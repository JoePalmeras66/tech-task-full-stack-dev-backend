package org.demicon.tech.task.d3.cloud.repository.filters.utils;

import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.util.Objects;

public class CommonFilter {
    public static BooleanBuilder filterPredicate(String filterValue,
                                                 Predicate predicate,
                                                 BooleanBuilder predicateBuilder) {
        if(Objects.isNull(predicate) || Strings.isNullOrEmpty(filterValue))
            return predicateBuilder;

        if(Objects.isNull(predicateBuilder) && Objects.nonNull(predicate))
            return new BooleanBuilder(predicate);

        return predicateBuilder.and(predicate);
    }
}
