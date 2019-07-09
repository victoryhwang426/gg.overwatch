package gg.overwatch.web.controller;

import gg.overwatch.domain.service.AbilityService;
import gg.overwatch.web.controller.dto.AbilityDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/abilities")
public class AbilityController {
    private AbilityService abilityService;

    @GetMapping
    public List<AbilityDto> getAbilities() {
        return abilityService.getAbilities();
    }

    @GetMapping(value = "/{abilityId}")
    public AbilityDto getHero(@PathVariable Long abilityId){
        return abilityService.getAbility(abilityId);
    }
}
