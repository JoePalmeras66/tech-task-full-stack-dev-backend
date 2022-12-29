package org.demicon.tech.task.d3.cloud.repository.filters;

import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import static org.demicon.tech.task.d3.cloud.repository.RandomUserRepository.qRandomUserEntity;

public class RandomUserFilter {
    public static BooleanBuilder filter(String country,
                                        String state,
                                        String city,
                                        String gender) {
        Predicate predicateCountry = qRandomUserEntity.location.country.toLowerCase().eq(country.toLowerCase());
        Predicate predicateState = qRandomUserEntity.location.state.toLowerCase().eq(state.toLowerCase());
        Predicate predicateCity = qRandomUserEntity.location.city.toLowerCase().eq(city.toLowerCase());
        Predicate predicateGender = qRandomUserEntity.gender.toLowerCase().eq(gender.toLowerCase());

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