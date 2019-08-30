package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.entity.Hero;
import gg.overwatch.domain.service.mapper.HeroAbilityMapper;
import gg.overwatch.domain.service.mapper.HeroMapper;
import gg.overwatch.domain.service.mapper.HeroMainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroParserService {
    private final String HERO_LIST_END_POINT = "https://overwatch-api.net/api/v1/hero/";

    private final String HERO_END_POINT = "https://overwatch-api.net/api/v1/hero/";

    private RestTemplate restTemplate;

    @Autowired
    public HeroParserService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private List<Hero> mapToHeroEntity(List<HeroMapper> heroMappers){
        List<Hero> heros = new ArrayList<>();

        heroMappers.forEach(heroMapper -> {
            heros.add(createHeroEntity(heroMapper));
        });

        return heros;
    }

    private Hero createHeroEntity(HeroMapper heroMapper){
        List<HeroAbilityMapper> heroAbilities = getHeroAbilities(heroMapper.id);
        Hero hero = new Hero(
                heroMapper.id,
                heroMapper.name,
                heroMapper.realName,
                heroMapper.health,
                heroMapper.armour,
                heroMapper.shield
        );

        heroAbilities.forEach(heroAbility -> {
            hero.addAbility(
                new Ability(
                    heroAbility.id,
                    heroAbility.name,
                    heroAbility.description,
                    heroAbility.isUltimate,
                    heroAbility.url
                )
            );
        });

        return hero;
    }

    private List<HeroAbilityMapper> getHeroAbilities(Object heroId){
        List<HeroAbilityMapper> heroAbilities = new ArrayList<>();
        try {
            ResponseEntity<HeroMapper> response = restTemplate.getForEntity(HERO_END_POINT + heroId, HeroMapper.class);
            heroAbilities = response.getBody().heroAbilities;
        } catch (Exception e){
            e.printStackTrace();
        }

        return heroAbilities;
    }

    public List<Hero> getHeros() {
        List<Hero> heros = new ArrayList<>();
        try {
            ResponseEntity<HeroMainMapper> response = restTemplate.getForEntity(HERO_LIST_END_POINT, HeroMainMapper.class);
            heros = mapToHeroEntity( response.getBody().heros );
        } catch (Exception e){
            e.printStackTrace();
        }

        return heros;
    }
}
