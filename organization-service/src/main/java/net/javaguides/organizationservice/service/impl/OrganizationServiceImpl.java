package net.javaguides.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.entitiy.Organization;
import net.javaguides.organizationservice.mapper.AutoOrganizationMapper;
import net.javaguides.organizationservice.repository.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto){

        // Convert dto
        Organization organization = AutoOrganizationMapper.MAPPER.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode){
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return AutoOrganizationMapper.MAPPER.mapToOrganizationDto(organization);
    }
}
