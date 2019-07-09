package gg.overwatch.web.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AbilityDto {
    private Long abilityId;
    private String name;
    private String description;
    @JsonProperty("is_ultimate")
    private boolean isUltimate;
    private String url;

    @Builder
    public AbilityDto(Long abilityId,
                      String name,
                      String description,
                      boolean isUltimate,
                      String url) {
        this.abilityId = abilityId;
        this.name = name;
        this.description = description;
        this.isUltimate = isUltimate;
        this.url = url;
    }
}
