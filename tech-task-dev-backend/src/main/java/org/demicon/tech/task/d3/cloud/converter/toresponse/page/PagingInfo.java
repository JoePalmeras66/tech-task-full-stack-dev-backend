package org.demicon.tech.task.d3.cloud.converter.toresponse.page;

import org.demicon.tech.task.d3.cloud.converter.toresponse.SortableModel;

public record PagingInfo(
        int number,
        int pageSize,
        SortBy sortBy,
        Class<? extends SortableModel> modelType
) {

}

