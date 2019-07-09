package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Hero;
import gg.overwatch.domain.repository.HeroRepository;
import gg.overwatch.web.controller.dto.AbilityDto;
import gg.overwatch.web.controller.dto.HeroDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HeroService {
    private HeroRepository heroRepository;

    public void saveHeros(List<Hero> heros){
        heroRepository.saveAll(heros);
    }

    public List<HeroDto> getHeros(){
        List<Hero> heros = heroRepository.findAll();

        return heros.stream()
                .map(hero ->
                        HeroDto.builder()
                                .hero(hero)
                                .build()
                ).collect(Collectors.toList());
    }

    public HeroDto getHero(Long heroId){
        Optional<Hero> optHero = heroRepository.findById(heroId);
        if(optHero.isPresent()) {
            return HeroDto.builder()
                    .hero(optHero.get())
                    .abilities(optHero.get().getAbilities())
                    .build();
        }

        return HeroDto.builder().build();
    }

    public List<AbilityDto> getHeroAbilities(Long heroId){
        Optional<Hero> optHero = heroRepository.findById(heroId);
        if(optHero.isPresent()){
            return optHero.get().getAbilities().stream()
                    .map(heroAbility ->
                            AbilityDto.builder()
                                    .abilityId(heroAbility.getAbilityId())
                                    .name(heroAbility.getName())
                                    .description(heroAbility.getDescription())
                                    .isUltimate(heroAbility.isUltimate())
                                    .url(heroAbility.getUrl())
                                    .build()
                    ).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }
}
