package gg.overwatch.domain.repository;

import gg.overwatch.domain.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityRepository extends JpaRepository<Ability, Long> {
}
