package gg.overwatch.domain.service.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeroMapper {
    public Long id;
    public String name;
    public String description;
    public Integer health;
    public Integer armour;
    public Integer shield;
    @JsonProperty("real_name")
    public String realName;
    public Integer age;
    public Integer height;
    public String affiliation;
    @JsonProperty("base_of_operations")
    public String baseOfOperations;
    public Integer difficulty;
    public String url;
    @JsonProperty("abilities")
    public List<HeroAbilityMapper> heroAbilities;

    public HeroMapper(){
    }
    public HeroMapper(Long id,
                      String name,
                      String description,
                      Integer health,
                      Integer armour,
                      Integer shield,
                      String realName,
                      String url,
                      List<HeroAbilityMapper> heroAbilities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.armour = armour;
        this.shield = shield;
        this.realName = realName;
        this.url = url;
        this.heroAbilities = heroAbilities;
    }
}
