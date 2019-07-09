package gg.overwatch.domain.service;

import gg.overwatch.domain.entity.Ability;
import gg.overwatch.domain.entity.Hero;
import gg.overwatch.util.URLClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroParserService {
    private final String HERO_LIST_END_POINT = "https://overwatch-api.net/api/v1/hero/";

    private final String HERO_END_POINT = "https://overwatch-api.net/api/v1/hero/";

    private List<Hero> mapToHeroEntity(JSONArray jsonHeros){
        List<Hero> heros = new ArrayList<>();

        jsonHeros.forEach(o -> {
            JSONObject hero = (JSONObject) o;
            heros.add(createHeroEntity(hero));
        });

        return heros;
    }

    private Hero createHeroEntity(JSONObject jsonHero){
        JSONArray jsonHeroAbilities = getHeroAbilities(jsonHero.get("id"));
        Hero hero = new Hero(
                jsonHero.get("id"),
                jsonHero.get("name"),
                jsonHero.get("real_name"),
                jsonHero.get("health"),
                jsonHero.get("armour"),
                jsonHero.get("shield")
        );

        jsonHeroAbilities.forEach(o -> {
            JSONObject ability = (JSONObject) o;
            hero.addAbility(
                    new Ability(
                            ability.get("id"),
                            ability.get("name"),
                            ability.get("description"),
                            ability.get("is_ultimate"),
                            ability.get("url"))
            );
        });

        return hero;
    }

    private JSONArray getHeroAbilities(Object heroId){
        JSONArray heroAbilities = new JSONArray();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject =
                    (JSONObject) jsonParser.parse(URLClient.getJsonString(HERO_END_POINT + heroId));

            heroAbilities = (JSONArray) jsonObject.get("abilities");
        } catch (Exception e){
            e.printStackTrace();
        }

        return heroAbilities;
    }

    public List<Hero> getHeros() {
        List<Hero> heros = new ArrayList<>();
        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject =
                    (JSONObject) jsonParser.parse(URLClient.getJsonString(HERO_LIST_END_POINT));

            heros = mapToHeroEntity( (JSONArray) jsonObject.get("data") );
        } catch (Exception e){
            e.printStackTrace();
        }

        return heros;
    }
}
