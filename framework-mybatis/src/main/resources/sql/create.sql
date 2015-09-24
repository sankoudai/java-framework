use test;

DROP TABLE if EXISTS date_test_entity;
create table date_test_entity(
  id int PRIMARY KEY,
  create_date datetime
);


DROP TABLE if EXISTS example_entity;
CREATE TABLE example_entity(
  id INT PRIMARY KEY  auto_increment,
  username VARCHAR(500) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  name VARCHAR(1000) ,
  gender VARCHAR(500) Comment'female, male',
  age SMALLINT ,
  phone VARCHAR(30)
);
