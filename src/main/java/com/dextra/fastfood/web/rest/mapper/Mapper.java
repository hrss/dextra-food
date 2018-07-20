package com.dextra.fastfood.web.rest.mapper;

import java.util.List;

public interface Mapper<V, T>
{
    V fromDto(T dto);
    T toDto(V dataObject);
    List<T> toDtoList(List<V> dataObjects);
}
