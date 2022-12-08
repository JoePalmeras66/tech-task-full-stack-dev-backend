package org.demicon.tech.task.d3.cloud.converter.toentities;

import org.demicon.tech.task.d3.cloud.entity.Name;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NameModelToEntityConverter implements Converter<org.demicon.tech.task.d3.cloud.domain.model.Name, Name> {
    @Override
    public Name convert(org.demicon.tech.task.d3.cloud.domain.model.Name source) {
        return Name.builder()
                .first(source.getFirst())
                .last(source.getLast())
                .title(source.getTitle())
                .build();
    }
}
