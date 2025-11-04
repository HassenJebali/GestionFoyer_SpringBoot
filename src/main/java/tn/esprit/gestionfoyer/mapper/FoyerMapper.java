package tn.esprit.gestionfoyer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.gestionfoyer.DTO.FoyerDTO;
import tn.esprit.gestionfoyer.entities.Foyer;

@Mapper(componentModel = "spring")
public interface FoyerMapper {

    @Mapping(target = "name", source = "nomFoyer")
    @Mapping(target = "capacity", source = "capaciteFoyer")
    FoyerDTO foyerToDTO(Foyer foyer) ;



}
