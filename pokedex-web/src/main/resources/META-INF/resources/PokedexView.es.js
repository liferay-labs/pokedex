import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import Dropdown from 'metal-dropdown/src/Dropdown';

import templates from './PokedexView.soy';

class PokedexView extends Component {
	/**
	 * @inheritDoc
	 */
	constructor(opt_config) {
		super(opt_config);
	}

	selectDropdown(event) {
		this.action = event.target.dataset.value;
	}

	selectPokemon(pokemon) {
		debugger;
	}
}

PokedexView.STATE = {
	action: {
		// The default value will be: `true`.
		value: 'list'
	}
};


// Register component
Soy.register(PokedexView, templates);

export default PokedexView;