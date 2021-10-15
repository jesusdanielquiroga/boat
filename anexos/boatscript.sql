DROP SCHEMA IF EXISTS boat;
DROP SCHEMA IF EXISTS boat_dev;
DROP SCHEMA IF EXISTS boat_prod;
CREATE SCHEMA boat DEFAULT CHARACTER SET utf8 ;
CREATE SCHEMA boat_dev DEFAULT CHARACTER SET utf8 ;
CREATE SCHEMA boat_prod DEFAULT CHARACTER SET utf8 ;

CREATE USER 'demo'@'localhost' IDENTIFIED BY 'Demo123.';
GRANT ALL PRIVILEGES ON * . * TO 'demo'@'localhost';
FLUSH PRIVILEGES;