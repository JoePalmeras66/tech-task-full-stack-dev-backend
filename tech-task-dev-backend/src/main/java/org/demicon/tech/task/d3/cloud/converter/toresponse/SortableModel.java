package org.demicon.tech.task.d3.cloud.converter.toresponse;

/**
 * A Marker interface that is used by model classes to indicate that sorting on model properties is supported (even when
 * public field names differ from entity field names). Models are not required to implement it - only when you want to
 * sort by unmatching api-spec model field name/ DB entity field name. e.g. field name: "creationDate" / DB entity field
 * name: "createdOn"
 */
public interface SortableModel {

}
