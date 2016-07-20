create index IX_77009D11 on Pokemon (groupId);
create index IX_C998DD6D on Pokemon (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9CA3DB2F on Pokemon (uuid_[$COLUMN_LENGTH:75$], groupId);