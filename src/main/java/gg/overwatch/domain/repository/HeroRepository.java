package gg.overwatch.domain.repository;

import gg.overwatch.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
