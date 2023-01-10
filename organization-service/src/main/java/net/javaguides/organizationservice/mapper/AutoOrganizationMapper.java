package net.javaguides.organizationservice.mapper;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entitiy.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoOrganizationMapper {

    // This will be the instance of the interface to use!!
    AutoOrganizationMapper MAPPER = Mappers.getMapper(AutoOrganizationMapper.class);

    // MapStruct creates code during compilation time..
    // If object have same field names.. nothing to change
    // @Mapping(source = "email", target = "emailAddress")
    OrganizationDto mapToOrganizationDto(Organization organization);

    Organization mapToOrganization(OrganizationDto organizationDto);
}
