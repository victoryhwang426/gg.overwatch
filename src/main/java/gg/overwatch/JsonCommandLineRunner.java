package gg.overwatch;

import gg.overwatch.domain.service.HeroParserService;
import gg.overwatch.domain.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JsonCommandLineRunner implements CommandLineRunner {
    private HeroParserService heroParserService;

    private HeroService heroService;

    @Override
    public void run(String... args)  {
        heroService.saveHeros(heroParserService.getHeros());
    }
}
