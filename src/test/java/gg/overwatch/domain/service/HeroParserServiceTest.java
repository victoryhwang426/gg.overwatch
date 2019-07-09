package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HeroParserServiceTest {
    @InjectMocks
    private HeroParserService heroParserService;

    @Test
    public void getHeros_should_return_hero_entity_list() {
        List<Hero> heros = heroParserService.getHeros();

        assertTrue(heros.size() > 0);
    }

    @Test
    public void getHeros_should_contain_hero_abilities(){
        List<Hero> heros = heroParserService.getHeros();

        assertTrue(heros.get(0).getAbilities().size() > 0);
    }
}