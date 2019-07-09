package gg.overwatch.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.entity.Hero;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class HeroDto {
    private Long id;
    private String name;
    @JsonProperty("real_name")
    private String realName;
    private Integer health;
    private Integer armour;
    private Integer shield;
    @JsonProperty("abilities")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AbilityDto> abilityDtos;

    @Builder
    public HeroDto(Hero hero, Set<Ability> abilities) {
        this.id = hero.getHeroId();
        this.name = hero.getName();
        this.realName = hero.getRealName();
        this.health = hero.getHealth();
        this.armour = hero.getArmour();
        this.shield = hero.getShield();
        if(abilities != null){
            this.abilityDtos = new ArrayList<>();
            this.abilityDtos.addAll(
                    abilities.stream().map(ability ->
                            AbilityDto.builder()
                                    .abilityId(ability.getAbilityId())
                                    .name(ability.getName())
                                    .description(ability.getDescription())
                                    .isUltimate(ability.isUltimate())
                                    .url(ability.getUrl())
                                    .build()
                    ).collect(Collectors.toList())
            );
        }
    }
}
