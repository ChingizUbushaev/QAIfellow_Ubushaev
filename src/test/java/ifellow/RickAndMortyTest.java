package ifellow;

import ifellow.dto.Character;
import ifellow.dto.Episode;
import ifellow.steps.RickAndMortySteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ifellow.constants.EnvConstants.LAST_EPISODE_WITH_MORTY;
import static ifellow.constants.EnvConstants.MORTY_SMITH_ID;

public class RickAndMortyTest {
    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();

    @Test
    @DisplayName("Тестирование API RICK and Morty")
    public void testingRickAndMortyAPI() {
        Character mortySmith = rickAndMortySteps.getCharacterById(MORTY_SMITH_ID);
        String lastEpisodeWithMorty = rickAndMortySteps.getLastEpisode(mortySmith);
        Assertions.assertEquals(lastEpisodeWithMorty, LAST_EPISODE_WITH_MORTY);
        System.out.println("Последний эписод с Морти Смит:" + lastEpisodeWithMorty);

        Episode series = rickAndMortySteps.getEpisodeById(lastEpisodeWithMorty);
        String characterId = rickAndMortySteps.getLastCharacterFromEpisode(series);
        Assertions.assertNotNull(characterId);
        System.out.println("id последнего персонажа:" + characterId);

        Character character825 = rickAndMortySteps.getCharacterById(characterId);
        System.out.println("Местоположение персонажа №" + characterId + ":" + character825.location.name);
        System.out.println("Расса персонажа №" + characterId + ":" + character825.species);
        Assertions.assertNotEquals(character825.location.name, mortySmith.location.name);
        Assertions.assertEquals(character825.species, mortySmith.species);
    }
}
