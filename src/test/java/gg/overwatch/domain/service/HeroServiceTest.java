package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.entity.Hero;
import gg.overwatch.domain.repository.HeroRepository;
import gg.overwatch.web.controller.dto.AbilityDto;
import gg.overwatch.web.controller.dto.HeroDto;
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
public class HeroServiceTest {
    @InjectMocks
    private HeroService heroService;

    @Mock
    private HeroRepository heroRepository;

    private Hero tempHero = Hero.builder()
            .heroId(1L)
            .name("Miss Fortune")
            .realName("Miss Fortune, the Bounty Hunter")
            .health(541)
            .armour(0)
            .shield(28)
            .build();

    private Ability tempAbility = Ability.builder()
            .abilityId(1L)
            .name("Double up")
            .description("One shot two kill")
            .isUltimate(false)
            .url(null)
            .build();

    @Test
    public void getHeros_should_return_hero_list(){
        List<Hero> heros = new ArrayList<>();
        heros.add(tempHero);

        when(heroRepository.findAll()).thenReturn(heros);

        List<HeroDto> heroDtos = heroService.getHeros();

        assertEquals(heros.size(), heroDtos.size());
    }

    @Test
    public void getHero_should_return_exact_hero_by_heroId(){
        tempHero.addAbility(tempAbility);
        when(heroRepository.findById(any(Long.class))).thenReturn(Optional.of(tempHero));

        HeroDto heroDto = heroService.getHero(tempHero.getHeroId());

        assertEquals(tempHero.getHeroId(), heroDto.getId());
        assertFalse(heroDto.getAbilityDtos().isEmpty());
    }

    @Test
    public void getHeroAbilities_should_return_exact_hero_abilities(){
        tempHero.addAbility(tempAbility);
        when(heroRepository.findById(any(Long.class))).thenReturn(Optional.of(tempHero));

        List<AbilityDto> abilityDtos = heroService.getHeroAbilities(tempHero.getHeroId());

        assertTrue(abilityDtos.size() > 0);
    }
}