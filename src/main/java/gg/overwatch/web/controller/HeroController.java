package gg.overwatch.web.controller;

import gg.overwatch.domain.service.HeroService;
import gg.overwatch.web.controller.dto.AbilityDto;
import gg.overwatch.web.controller.dto.HeroDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/heros")
public class HeroController {
    private HeroService heroService;

    @GetMapping
    public List<HeroDto> getHeros() {
        return heroService.getHeros();
    }

    @GetMapping(value = "/{heroId}")
    public HeroDto getHero(@PathVariable Long heroId){
        return heroService.getHero(heroId);
    }

    @GetMapping(value = "/{heroId}/abilities")
    public List<AbilityDto> getHeroAbilities(@PathVariable Long heroId){
        return heroService.getHeroAbilities(heroId);
    }
}
