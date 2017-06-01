--CREATE SCHEMA `musicdb` DEFAULT CHARACTER SET utf8 ;
--USE musicdb;
DROP TABLE songs CASCADE CONSTRAINTS ;
DROP TABLE bands CASCADE CONSTRAINTS ;


CREATE TABLE songs
  (
    songId     INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    songName   VARCHAR (20) ,
	songYear   SMALLINT,
    bandId     INTEGER
  ) ;

CREATE TABLE bands
  (
    bandId INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
    bandName          VARCHAR (20) 
  ) ;
  
ALTER TABLE songs ADD CONSTRAINT songsPK PRIMARY KEY ( songId ) ;
ALTER TABLE bands ADD CONSTRAINT songsPK PRIMARY KEY ( bandId ) ;
ALTER TABLE songs ADD CONSTRAINT songs FOREIGN KEY ( bandId ) REFERENCES bands ( bandId ) ;


-- ALTER TABLE songs ADD CONSTRAINT songs FOREIGN KEY ( bandId ) REFERENCES bands ( bandId ) ON DELETE CASCADE;

