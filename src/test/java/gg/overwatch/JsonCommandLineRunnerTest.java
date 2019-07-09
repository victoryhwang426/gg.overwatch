package gg.overwatch;

import gg.overwatch.domain.entity.Hero;
import gg.overwatch.domain.service.HeroParserService;
import gg.overwatch.domain.service.HeroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class JsonCommandLineRunnerTest {
    @InjectMocks
    private JsonCommandLineRunner jsonCommandLineRunner;

    @Mock
    private HeroParserService heroParserService;

    @Mock
    private HeroService heroService;

    private Hero tempHero = Hero.builder()
            .heroId(10000L)
            .name("Miss Fortune")
            .realName("Miss Fortune, the Bounty Hunter")
            .health(541)
            .armour(0)
            .shield(28)
            .build();

    @Test
    public void run_should_save_heros_into_database() {
        when(heroParserService.getHeros()).thenReturn(Arrays.asList(tempHero));

        jsonCommandLineRunner.run();

        verify(heroService).saveHeros(anyList());
    }
}