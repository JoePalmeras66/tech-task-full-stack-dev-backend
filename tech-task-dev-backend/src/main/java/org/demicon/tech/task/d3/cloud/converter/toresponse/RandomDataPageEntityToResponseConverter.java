package org.demicon.tech.task.d3.cloud.converter.toresponse;

import lombok.RequiredArgsConstructor;
import org.demicon.tech.task.d3.cloud.entity.RandomUser;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import tech.task.d3.cloud.api.model.PageableRandomUserDTO;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RandomDataPageEntityToResponseConverter implements Converter<Page<RandomUser>, PageableRandomUserDTO> {
    private final RandomDataStreamEntityToResponseConverter randomDataStreamEntityToResponseConverter;

    @Override
    public PageableRandomUserDTO convert(Page<RandomUser> source) {
        PageableRandomUserDTO pageableRandomUserDTO = new PageableRandomUserDTO();
        pageableRandomUserDTO.contents(this.randomDataStreamEntityToResponseConverter.convert(source.get())
                .collect(Collectors.toList()));
        pageableRandomUserDTO.pageIndex(source.getNumber());
        pageableRandomUserDTO.pageSize(source.getSize());
        pageableRandomUserDTO.pageCount(source.getTotalPages());
        pageableRandomUserDTO.totalElements(source.getTotalElements());
        return pageableRandomUserDTO;
    }
}