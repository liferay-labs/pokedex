import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './PokedexEditPokemonError.soy';

class PokedexEditPokemonError extends Component {
	/**
	 * @inheritDoc
	 */
	constructor(opt_config) {
		super(opt_config);
	}
}

// Register component
Soy.register(PokedexEditPokemonError, templates);

export default PokedexEditPokemonError;