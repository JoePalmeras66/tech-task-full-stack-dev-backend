package org.demicon.tech.task.d3.cloud.domain.model.response.page;

import java.util.List;

public record PageInfo<TData>(List<TData> contents,
                              int pageIndex,
                              int pageSize,
                              int pageCount,
                              long totalElements) {
}
