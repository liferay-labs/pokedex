import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import Dropdown from 'metal-dropdown/src/Dropdown';
import Tooltip from 'metal-tooltip/src/Tooltip';
import Autocomplete from 'metal-autocomplete/src/Autocomplete';

import templates from './PokedexView.soy';
import pokemonViewTemplates from './PokemonListItem.soy';

class PokedexView extends Component {
	/**
	 * @inheritDoc
	 */
	constructor(opt_config) {
		super(opt_config);
		this.listPokemons = opt_config.pokemons.slice();
		this.pokemons = opt_config.pokemons;
	}

	attached(){
		var instance = this;

		new Autocomplete(
			{
				elementClasses: 'autocomplete-pokemon',
				inputElement: document.getElementById('input-search'),
				data: function(query) {
					return instance.listPokemons.filter(function(item) {
						item.textPrimary = item.name;
						return query && item.name.toLowerCase().indexOf(query.toLowerCase()) !== -1;
					});
				}
			}
		);
	}

	filter(event) {
		var search = event.target.value;

		this.pokemons = this.listPokemons.filter(pokemon => {
			return pokemon.name.toLowerCase().indexOf(search.toLowerCase()) !== -1;
		})

	}
}

PokedexView.STATE = {
	action: {
		// The default value will be: `true`.
		value: 'list'
	},

	listPokemons: {
		value: []
	}

};


// Register component
Soy.register(PokedexView, templates);

export default PokedexView;