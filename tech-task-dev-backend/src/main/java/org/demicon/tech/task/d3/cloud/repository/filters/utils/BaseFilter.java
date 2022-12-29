package org.demicon.tech.task.d3.cloud.repository.filters.utils;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.demicon.tech.task.d3.cloud.repository.filters.utils.CommonFilter;

public class BaseFilter {
    public static BooleanBuilder filterBasePredicate(String predicateValue,
                                                     BooleanBuilder predicateBuilder,
                                                     Predicate predicate) {
        return CommonFilter.filterPredicate(predicateValue, predicate, predicateBuilder);
    }
}
