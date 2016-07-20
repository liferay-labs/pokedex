create table Pokemon (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	originalName VARCHAR(75) null,
	customName VARCHAR(75) null,
	description VARCHAR(75) null,
	type_ VARCHAR(75) null,
	order_ LONG,
	frontImageURL VARCHAR(75) null,
	frontShinyImageURL VARCHAR(75) null,
	backImageURL VARCHAR(75) null,
	backShinyImageURL VARCHAR(75) null
);