public class PokemonService {
    public Pokemon createPokemon(int id, String name, int level, int health, List<String> type, List<String> moves) {
        Pokemon pokemon = new Pokemon();
        pokemon.id = id;
        pokemon.name = name;
        pokemon.level = level;
        pokemon.health = health;
        pokemon.type = type;
        pokemon.moves = moves;
        return pokemon;
    }
}
