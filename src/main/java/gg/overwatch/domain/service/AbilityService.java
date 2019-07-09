package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.repository.AbilityRepository;
import gg.overwatch.web.controller.dto.AbilityDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AbilityService {
    private AbilityRepository abilityRepository;

    public List<AbilityDto> getAbilities(){
        List<Ability> abilities = abilityRepository.findAll();
        return abilities.stream()
                .map(ability ->
                        AbilityDto.builder()
                                .abilityId(ability.getAbilityId())
                                .name(ability.getName())
                                .isUltimate(ability.isUltimate())
                                .description(ability.getDescription())
                                .url(ability.getUrl())
                                .build()
                ).collect(Collectors.toList());
    }

    public AbilityDto getAbility(Long abilityId){
        Optional<Ability> optAbility = abilityRepository.findById(abilityId);
        if(optAbility.isPresent()){
            return AbilityDto.builder()
                    .abilityId(optAbility.get().getAbilityId())
                    .name(optAbility.get().getName())
                    .description(optAbility.get().getDescription())
                    .isUltimate(optAbility.get().isUltimate())
                    .url(optAbility.get().getUrl())
                    .build();
        }

        return AbilityDto.builder().build();
    }
}
