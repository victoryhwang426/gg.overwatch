package gg.overwatch.domain.repository;

import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.entity.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HeroRepositoryTest {
    @Autowired
    private HeroRepository heroRepository;

    private Hero tempHero = Hero.builder()
            .heroId(10000L)
            .name("Miss Fortune")
            .realName("Miss Fortune, the Bounty Hunter")
            .health(541)
            .armour(0)
            .shield(28)
            .build();

    private Ability tempAbility = Ability.builder()
            .abilityId(10000L)
            .name("Double up")
            .description("One shot two kill")
            .isUltimate(false)
            .url(null)
            .build();

    @Test
    public void save_should_return_saved_entity(){
        tempHero.addAbility(tempAbility);
        Hero hero = heroRepository.save(tempHero);

        assertNotNull(hero);
        assertEquals(tempHero.getHeroId(), hero.getHeroId());
        assertEquals(1, hero.getAbilities().size());
    }

    @Test
    public void findAll_should_return_all_saved_entities(){
        List<Hero> heros = heroRepository.findAll();

        assertTrue(heros.size() > 0);
    }

    @Test
    public void findById_should_return_exact_entity_by_heroId(){
        Optional<Hero> optItem = heroRepository.findById(1L);

        assertTrue(optItem.isPresent());
    }
}