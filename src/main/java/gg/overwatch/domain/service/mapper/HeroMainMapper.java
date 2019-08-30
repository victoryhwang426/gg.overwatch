package gg.overwatch.domain.service.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeroMainMapper {
    public Integer total;
    public String first;
    public String next;
    public String previous;
    @JsonProperty("data")
    public List<HeroMapper> heros;

    public HeroMainMapper(){
    }
    public HeroMainMapper(Integer total,
                          String first,
                          String next,
                          String previous,
                          List<HeroMapper> heros) {
        this.total = total;
        this.first = first;
        this.next = next;
        this.previous = previous;
        this.heros = heros;
    }
}
