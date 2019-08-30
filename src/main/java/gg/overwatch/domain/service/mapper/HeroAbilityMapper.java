package gg.overwatch.domain.service.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeroAbilityMapper {
    public Long id;
    public String name;
    public String description;
    @JsonProperty("is_ultimate")
    public boolean isUltimate;
    public String url;

    public HeroAbilityMapper(){
    }
    public HeroAbilityMapper(Long id,
                             String name,
                             String description,
                             boolean isUltimate,
                             String url) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isUltimate = isUltimate;
        this.url = url;
    }
}
