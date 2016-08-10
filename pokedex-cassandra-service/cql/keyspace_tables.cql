// create keyspace and reconnect using keyspace liferay
create keyspace liferay with replication = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

// create Pokemon table in keyspace liferay
create table Pokemon (
	pokemonId bigint primary key,
    uuid varchar,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar,
	createDate timestamp,
	modifiedDate timestamp,
	originalName varchar,
	customName varchar,
	description text,
	type_ varchar,
	order_ bigint,
	frontImageURL varchar,
	frontShinyImageURL varchar,
	backImageURL varchar,
	backShinyImageURL varchar
);

// create custom pokemon type
create type Pokemon (
	name varchar,
	order_ bigint,
	description text,
	type_ varchar,
	frontImageURL varchar,
	frontShinyImageURL varchar,
	backImageURL varchar,
	backShinyImageURL varchar
);

// table with pokemons cache
create table PokemonCache (
	id bigint,
  	cacheDate timestamp,
  	start_ int,
  	end_ int,
  	pokemons list<frozen <Pokemon>>,
  	primary key((id), cacheDate)
) with clustering order by (cacheDate desc);
