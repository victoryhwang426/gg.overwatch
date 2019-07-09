package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.repository.AbilityRepository;
import gg.overwatch.web.controller.dto.AbilityDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbilityServiceTest {
    @InjectMocks
    private AbilityService abilityService;

    @Mock
    private AbilityRepository abilityRepository;

    private Ability tempAbility = Ability.builder()
            .abilityId(1L)
            .name("Double up")
            .description("One shot two kill")
            .isUltimate(false)
            .url(null)
            .build();

    @Test
    public void getAbilities_should_return_Ability_list(){
        List<Ability> abilities = new ArrayList<>();
        abilities.add(tempAbility);

        when(abilityRepository.findAll()).thenReturn(abilities);

        List<AbilityDto> abilityDtos = abilityService.getAbilities();

        assertEquals(abilities.size(), abilityDtos.size());
    }

    @Test
    public void getAbility_should_return_exact_ability_by_abilityId(){
        when(abilityRepository.findById(any(Long.class))).thenReturn(Optional.of(tempAbility));

        AbilityDto abilityDto = abilityService.getAbility(tempAbility.getAbilityId());

        assertEquals(tempAbility.getAbilityId(), abilityDto.getAbilityId());
    }
}