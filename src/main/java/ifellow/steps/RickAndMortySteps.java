package ifellow.steps;

import ifellow.api.RickAndMortyApi;
import ifellow.dto.Character;
import ifellow.dto.Episode;

public class RickAndMortySteps {

    private static final RickAndMortyApi characterApi = new RickAndMortyApi();
    private static final RickAndMortyApi episodeApi = new RickAndMortyApi();

    public Character getCharacterById(String id) {
        Character character = characterApi.getCharacterId(id)
                .statusCode(200)
                .extract()
                .body()
                .as(Character.class);
        return character;
    }

    public String getLastEpisode(Character character) {
        String linkForLastEpisode = character.episode.get(character.episode.size() - 1);
        String[] partsLink = linkForLastEpisode.split("/");
        String lastEpisode = partsLink[partsLink.length - 1];
        return lastEpisode;
    }

    public Episode getEpisodeById(String id) {
        Episode series = episodeApi.getEpisodeId(id)
                .statusCode(200)
                .extract()
                .body()
                .as(Episode.class);
        return series;
    }

    public String getLastCharacterFromEpisode(Episode series) {
        String linkToLastCharacter = series.characters.get(series.characters.size() - 1);
        String[] partsLink = linkToLastCharacter.split("/");
        String lastCharacterId = partsLink[partsLink.length - 1];
        return lastCharacterId;
    }
}
