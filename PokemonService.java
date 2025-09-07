import skaro.pokeapi.client.*;
import skaro.pokeapi.resource.pokemon.Pokemon as ApiPokemon;
import java.util.*;

public class PokemonService {
    private final PokeApiClient client = new ReactiveCachingPokeApiClient();

    public List<Pokemon> getRandomTeam() {
        Random rand = new Random();
        List<Pokemon> team = new ArrayList<>();
        Set<Integer> usedIds = new HashSet<>();

        while (team.size() < 6) {
            int randomId = rand.nextInt(151) + 1;
            if (usedIds.contains(randomId)) continue;
            usedIds.add(randomId);

            ApiPokemon apiPokemon = client.getResource(ApiPokemon.class, String.valueOf(randomId)).block();
            if (apiPokemon != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.id = apiPokemon.getId();
                pokemon.name = apiPokemon.getName();
                pokemon.level = rand.nextInt(51) + 50;
                pokemon.health = pokemon.level * 10;

                pokemon.type = apiPokemon.getTypes().stream().map(t -> t.getType().getName()).toList();

                List<String> allMoves = apiPokemon.getMoves().stream().map(m -> m.getMove().getName()).toList();
                Collections.shuffle(allMoves);
                pokemon.moves = allMoves.stream().limit(4).toList();

                team.add(pokemon);
            }
        }
        return team;
    }
}
