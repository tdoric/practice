DROP TABLE IF EXISTS route;
create table route
(
   id integer not null,
   x integer not null,
   y integer not null,
   primary key(id)
);
insert into route (id,x,y) 
values	(1,5,5),
		(1,4,4),
		(1,3,4),
		(1,2,3),
		(1,1,4),
		(1,1,6),
		(1,2,7),
		(1,2,8),
		(1,3,9),
		(1,5,9),
		(1,7,8),
		(1,8,7),
		(1,9,6),
		(1,9,4)
