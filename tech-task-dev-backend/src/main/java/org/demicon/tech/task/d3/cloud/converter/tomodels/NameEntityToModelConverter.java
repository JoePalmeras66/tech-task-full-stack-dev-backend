package org.demicon.tech.task.d3.cloud.converter.tomodels;

import org.demicon.tech.task.d3.cloud.entity.Name;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NameEntityToModelConverter implements Converter<Name, org.demicon.tech.task.d3.cloud.domain.model.Name> {
    @Override
    public org.demicon.tech.task.d3.cloud.domain.model.Name convert(Name source) {
        org.demicon.tech.task.d3.cloud.domain.model.Name name = new org.demicon.tech.task.d3.cloud.domain.model.Name();
        name.setFirst(source.getFirst());
        name.setLast(source.getLast());
        name.setTitle(source.getTitle());
        return name;
    }
}
