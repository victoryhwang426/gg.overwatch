package gg.overwatch.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "hero")
public class Hero {
    @Id
    private Long heroId;

    @Column
    private String name;

    @Column(name="real_name")
    private String realName;

    @Column
    private Integer health;

    @Column
    private Integer armour;

    @Column
    private Integer shield;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    private Set<Ability> abilities = new LinkedHashSet<>();

    @Builder
    public Hero(Long heroId,
                String name,
                String realName,
                Integer health,
                Integer armour,
                Integer shield) {
        this.heroId = heroId;
        this.name = name;
        this.realName = realName;
        this.health = health;
        this.armour = armour;
        this.shield = shield;
    }

    @Builder
    public Hero(Object heroId,
                Object name,
                Object realName,
                Object health,
                Object armour,
                Object shield) {
        this.heroId = Long.valueOf(String.valueOf(heroId));
        this.name = name.toString();
        this.realName = realName.toString();
        this.health = Integer.valueOf(String.valueOf(health));
        this.armour = Integer.valueOf(String.valueOf(armour));
        this.shield = Integer.valueOf(String.valueOf(shield));
    }

    public void addAbility(Ability ability){
        abilities.add(ability);
        ability.updateHero(this);
    }
}