import Component from 'metal-component/src/Component';
import Soy from 'metal-soy/src/Soy';

import templates from './PokedexEditPokemon.soy';


class PokedexEditPokemon extends Component {

	/**
   * @inheritDoc
   */
  constructor(opt_config) {
		  super(opt_config);
   }
};

// Register component
Soy.register(PokedexEditPokemon, templates);

export default PokedexEditPokemon;

