package gg.overwatch.domain.service;

import gg.overwatch.RestTemplateConfiguration;
import gg.overwatch.domain.entity.Hero;
import gg.overwatch.domain.service.mapper.HeroAbilityMapper;
import gg.overwatch.domain.service.mapper.HeroMainMapper;
import gg.overwatch.domain.service.mapper.HeroMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = RestTemplateConfiguration.class)
public class HeroParserServiceTest {
    @InjectMocks
    private HeroParserService heroParserService;

    @Mock
    private RestTemplate restTemplate;

    private HeroMapper heroMapper = new HeroMapper(
            1L,
            "hero name",
            "hero description",
            null,
            null,
            null,
            "Seungri Hwang",
            null,
            Arrays.asList(new HeroAbilityMapper(1L, "name", "description", true, "url"))
    );

    private HeroMainMapper heroMainMapper = new HeroMainMapper (
        0,
        "",
        "",
        "",
        Arrays.asList(heroMapper)
    );

    @Test
    public void getHeros_should_return_hero_entity_list() {
        when(restTemplate.getForEntity("https://overwatch-api.net/api/v1/hero/", HeroMainMapper.class))
            .thenReturn(ResponseEntity.ok(heroMainMapper));
        when(restTemplate.getForEntity("https://overwatch-api.net/api/v1/hero/1", HeroMapper.class))
            .thenReturn(ResponseEntity.ok(heroMapper));

        List<Hero> heros = heroParserService.getHeros();

        assertEquals(1, heros.size());
        assertEquals("hero name", heros.get(0).getName());
    }

    @Test
    public void getHeros_should_contain_hero_abilities(){
        when(restTemplate.getForEntity("https://overwatch-api.net/api/v1/hero/", HeroMainMapper.class))
            .thenReturn(ResponseEntity.ok(heroMainMapper));
        when(restTemplate.getForEntity("https://overwatch-api.net/api/v1/hero/1", HeroMapper.class))
            .thenReturn(ResponseEntity.ok(heroMapper));

        List<Hero> heros = heroParserService.getHeros();

        assertTrue(heros.get(0).getAbilities().size() > 0);
    }
}