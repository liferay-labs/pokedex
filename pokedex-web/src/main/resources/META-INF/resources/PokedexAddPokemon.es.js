import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import Ajax from 'metal-ajax/src/Ajax';
import Dropdown from 'metal-dropdown/src/Dropdown';

import templates from './PokedexAddPokemon.soy';
import pokemonViewTemplates from './PokemonListItem.soy';
import PokemonFilter from './PokemonFilter.es';

class PokedexAddPokemon extends Component {
	/**
	 * @inheritDoc
	 */
	constructor(opt_config) {
		super(opt_config);

		this.getPokemonsURL = opt_config.getPokemonsURL;

		//temporal
		this.getPokemons();
	}

	getPokemons() {
		var instance = this;

		Ajax.request(
			this.getPokemonsURL,
			'GET'
		)
		.then(
			function(response) {
				instance.pokemons = JSON.parse(response.response);
				instance.originalPokemonList = JSON.parse(response.response);
			}
		);
	}

	updatePokemons(pokemons) {
		this.pokemons = pokemons;
	}
}

PokedexAddPokemon.STATE = {
	pokemons: {
		value: []
	},
	originalPokemonList: {
		value: []
	}
};

// Register component
Soy.register(PokedexAddPokemon, templates);

export default PokedexAddPokemon;