import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import Autocomplete from 'metal-autocomplete/src/Autocomplete';

import core from 'metal/src/core';

import templates from './PokemonFilter.soy';

class PokemonFilter extends Component {
	attached() {
		var instance = this;

		var inputSearch = document.getElementById('input-search');

		new Autocomplete(
			{
				elementClasses: 'autocomplete-pokemon',
				inputElement: inputSearch,
				data: function(query) {
					return instance.originalPokemonList.filter(function(item) {
						item.textPrimary = item.name;
						return query && item.name.toLowerCase().indexOf(query.toLowerCase()) !== -1;
					});
				},
				select: event => {
					inputSearch.value = event.name;
					this.filterPokemon(event.name);
				}
			}
		);
	}

	filterOnClick(event) {
		var name = event.target.value;

		this.filterPokemon(name);
	}

	filterPokemon(name) {
		var pokemons = this.originalPokemonList.filter(
			pokemon => {
				return pokemon.name.toLowerCase().indexOf(name.toLowerCase()) !== -1;
			}
		);

		this.updatePokemons(pokemons);
	}
}

PokemonFilter.STATE = {
	originalPokemonList : {
		validator: core.isArray,
		value: []
	},

	updatePokemons: {
		validator: core.isFunction
	}
};

// Register component
Soy.register(PokemonFilter, templates);

export default PokemonFilter;