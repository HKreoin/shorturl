package org.kreoin.shorturl.mapper;

import org.kreoin.shorturl.dto.UrlCreateDTO;
import org.kreoin.shorturl.dto.UrlDTO;
import org.kreoin.shorturl.entity.Url;
import org.mapstruct.*;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UrlMapper {
    public abstract Url map(UrlCreateDTO dto);
    //public abstract void update(UrlUpdateDTO dto, @MappingTarget Url model);
    public abstract UrlDTO map(Url model);
}
