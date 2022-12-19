package org.demicon.tech.task.d3.cloud.domain.model.response.page;

import org.demicon.tech.task.d3.cloud.domain.model.response.RandomUserResponse;

import java.util.List;

public record RandomUserResponsePageInfo(List<RandomUserResponse> contents,
                                         int pageIndex,
                                         int pageSize,
                                         int pageCount,
                                         long totalElements) {
}
