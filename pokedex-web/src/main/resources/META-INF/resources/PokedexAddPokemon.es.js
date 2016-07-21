import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './PokedexAddPokemon.soy';

class PokedexAddPokemon extends Component {
	/**
	 * @inheritDoc
	 */
	constructor(opt_config) {
		super(opt_config);
	}
}

// Register component
Soy.register(PokedexAddPokemon, templates);

export default PokedexAddPokemon;