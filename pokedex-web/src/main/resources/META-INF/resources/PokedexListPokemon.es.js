import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import Dropdown from 'metal-dropdown/src/Dropdown';
import Tooltip from 'metal-tooltip/src/Tooltip';

import templates from './PokedexListPokemon.soy';
import pokemonViewTemplates from './PokemonListItem.soy';
//TODO FILTERCOMPONENT IMPORT

class PokedexListPokemon extends Component {
	/**
	 * @inheritDoc
	 */
	constructor(opt_config) {
		super(opt_config);
	}

	updatePokemons(pokemons) {
		this.pokemons = pokemons;
	}

	/*TODO FILTERCOMPONENT
		HIERARCHIC DATA SAMPLE
	*/
}

// Register component
Soy.register(PokedexListPokemon, templates);

export default PokedexListPokemon;