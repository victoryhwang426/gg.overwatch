package gg.overwatch.domain.repository;

import gg.overwatch.domain.entity.Ability;
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
public class AbilityRepositoryTest {
    @Autowired
    private AbilityRepository abilityRepository;

    @Test
    public void findAll_should_return_all_saved_entities(){
        List<Ability> abilities = abilityRepository.findAll();

        assertTrue(abilities.size() > 0);
    }

    @Test
    public void findById_should_return_exact_entity_by_abilityId(){
        Optional<Ability> optItem = abilityRepository.findById(1L);

        assertTrue(optItem.isPresent());
    }
}