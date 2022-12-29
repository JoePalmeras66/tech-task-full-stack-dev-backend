package org.demicon.tech.task.d3.cloud.repository.filters;

import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.demicon.tech.task.d3.cloud.repository.filters.utils.BaseFilter;

import static org.demicon.tech.task.d3.cloud.repository.RandomUserRepository.qRandomUserEntity;

public class RandomUserFilter {
    public static BooleanBuilder filter(String country,
                                        String state,
                                        String city,
                                        String gender) {
        Predicate predicateCountry = Strings.isNullOrEmpty(country) ? null : qRandomUserEntity.location.country.toLowerCase().eq(country.toLowerCase());
        Predicate predicateState = Strings.isNullOrEmpty(state) ? null : qRandomUserEntity.location.state.toLowerCase().eq(state.toLowerCase());
        Predicate predicateCity = Strings.isNullOrEmpty(city) ? null : qRandomUserEntity.location.city.toLowerCase().eq(city.toLowerCase());
        Predicate predicateGender = Strings.isNullOrEmpty(gender) ? null : qRandomUserEntity.gender.toLowerCase().eq(gender.toLowerCase());

        BooleanBuilder predicateBuilder = (Strings.isNullOrEmpty(country)) ? new BooleanBuilder()
                : BaseFilter.filterBasePredicate(country, new BooleanBuilder(), predicateCountry);
        predicateBuilder = (Strings.isNullOrEmpty(state)) ? predicateBuilder
                : BaseFilter.filterBasePredicate(state, predicateBuilder, predicateState);
        predicateBuilder = (Strings.isNullOrEmpty(city)) ? predicateBuilder
                : BaseFilter.filterBasePredicate(city, predicateBuilder, predicateCity);
        predicateBuilder = (Strings.isNullOrEmpty(gender)) ? predicateBuilder
                : BaseFilter.filterBasePredicate(gender, predicateBuilder, predicateGender);
        return predicateBuilder;
    }
}