package gg.overwatch.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "ability")
public class Ability {
    @Id
    private Long abilityId;

    @Column
    private String name;

    @Column
    @Size(max = 1000)
    private String description;

    @Column(name="is_ultimate")
    private boolean isUltimate;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "heroId")
    private Hero hero;

    @Builder
    public Ability(Long abilityId,
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

    @Builder
    public Ability(Object abilityId,
                   Object name,
                   Object description,
                   Object isUltimate,
                   Object url) {
        this.abilityId = Long.valueOf(String.valueOf(abilityId));
        this.name = name.toString();
        this.description = description.toString();
        this.isUltimate = Boolean.valueOf(String.valueOf(isUltimate));
        this.url = url.toString();
    }

    public void updateHero(Hero hero) {
        this.hero = hero;
    }
}
