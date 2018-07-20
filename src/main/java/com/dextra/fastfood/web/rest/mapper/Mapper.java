package com.dextra.fastfood.web.rest.mapper;

import java.util.List;

/**
 * The interface Mapper.
 *
 * @param <V> the type parameter, which is the data object
 * @param <T> the type parameter, which is the data transfer object
 */
public interface Mapper<V, T>
{
    /**
     * Creates a data object from a dto.
     *
     * @param dto the dto
     * @return the v
     */
    V fromDto(T dto);

    /**
     * Creates a dto from a data object.
     *
     * @param dataObject the data object
     * @return the t
     */
    T toDto(V dataObject);

    /**
     * Creates a list of dtos based on a list of objects.
     *
     * @param dataObjects the data objects
     * @return the list
     */
    List<T> toDtoList(List<V> dataObjects);
}
