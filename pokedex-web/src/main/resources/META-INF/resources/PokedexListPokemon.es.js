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

	filterOnKeyup(event) {
		this.pokemons = this.originalPokemonList.filter(
			pokemon => {
				return pokemon.name.toLowerCase().indexOf(event.target.value.toLowerCase()) !== -1;
			}
		);
	}

	/*TODO FILTERCOMPONENT
		HIERARCHIC DATA SAMPLE
	*/
}

PokedexListPokemon.STATE = {
	originalPokemonList: {
		value: []
	}
}

// Register component
Soy.register(PokedexListPokemon, templates);

export default PokedexListPokemon;