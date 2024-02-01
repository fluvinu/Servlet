CREATE SCHEMA `note` ;
use note;
-- carete the note table 
CREATE TABLE `note`.`notes` (
  `nid` INT NOT NULL AUTO_INCREMENT,
  `n_title` TEXT NULL,
  `note` TEXT NULL,
  `date` TIME NULL,
  `user` TEXT NULL,
  PRIMARY KEY (`nid`));


-- cretare a user table 
CREATE TABLE `note`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user` TEXT NOT NULL,
  `pass` TEXT NULL,
  PRIMARY KEY (`user_id`));

-- edit coll time ste,mp
ALTER TABLE `note`.`notes` 
CHANGE COLUMN `date` `date` timestamp NULL DEFAULT NULL ;

-- carete note table agian 
ALTER TABLE `note`.`notes` 
ADD COLUMN `user_id` INT NULL AFTER `user`,
ADD INDEX `uid_idx` (`user_id` ASC) VISIBLE;
;
ALTER TABLE `note`.`notes` 
ADD CONSTRAINT `uid`
  FOREIGN KEY (`user_id`)
  REFERENCES `note`.`user` (`user_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

-- make user a primary key isted og id 
ALTER TABLE `note`.`user` 
CHANGE COLUMN `user` `user` VARCHAR(50) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`user`),
ADD UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE;
;

-- now add pk acc 
ALTER TABLE `note`.`notes` 
ADD CONSTRAINT `userpk`
  FOREIGN KEY (`user`)
  REFERENCES `note`.`user` (`user`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


-- insert int o user 
INSERT INTO `note`.`user` (`user_id`, `user`, `pass`) VALUES ('1', 'sid', '123');

select * from notes;
INSERT INTO `note`.`notes` (`n_title`, `note`,`date`, `user`, `user_id`) VALUES ( 'good', 'nid  djjkds dsjk',now(), 'sid', '1');


select * from notes where nid=2 and user_id=1;
delete from notes where user_id = 1 and nid =10;
UPDATE notes SET n_title = 'dsd', note = 'gfg' ,`date` = now() WHERE nid = '6' and user_id = 1;

select user from notes where user_id=1;
select * from user;


select * from notes  where user='goku' and n_title like  '%k%' ;



