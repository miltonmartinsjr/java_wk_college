From mysql workbench run the following sql statements:

  SET @@global.time_zone = '+00:00';
  SET @@session.time_zone = '+00:00';

with the following sql statements check if the values were set:

  SELECT @@global.time_zone, @@session.time_zone;


CREATE SCHEMA `420-PB4-AG-11` ;

DROP TABLE IF EXISTS `420-PB4-AG-11`.`banques`;
CREATE TABLE `420-PB4-AG-11`.`banques` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) NOT NULL,
  `nom` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`pkid`),
  UNIQUE INDEX `banque_nom_UNIQUE` (`nom` ASC) VISIBLE);

DROP TABLE IF EXISTS `420-PB4-AG-11`.`comptes`;
CREATE TABLE `420-PB4-AG-11`.`comptes` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`pkid`));

DROP TABLE IF EXISTS `420-PB4-AG-11`.`clients`;
CREATE TABLE `420-PB4-AG-11`.`clients` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `banque_pkid` INT NOT NULL,
  PRIMARY KEY (`pkid`),
  CONSTRAINT `CLIENT_FK01`
    FOREIGN KEY (`banque_pkid`)
    REFERENCES `420-PB4-AG-11`.`banques` (`pkid`));

DROP TABLE IF EXISTS `420-PB4-AG-11`.`guichet_automatique_bancaires`;
CREATE TABLE `420-PB4-AG-11`.`guichet_automatique_bancaires` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `banque_pkid` INT NOT NULL,
  PRIMARY KEY (`pkid`),
  CONSTRAINT `GAB_FK01`
    FOREIGN KEY (`banque_pkid`)
    REFERENCES `420-PB4-AG-11`.`banques` (`pkid`));

DROP TABLE IF EXISTS `420-PB4-AG-11`.`compte_clients`;
CREATE TABLE `420-PB4-AG-11`.`compte_clients` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `client_pkid` INT NOT NULL,
  `compte_pkid` INT NOT NULL,
  PRIMARY KEY (`pkid`),
  CONSTRAINT `COMPTE_CLIENT_FK01`
    FOREIGN KEY (`client_pkid`)
    REFERENCES `420-PB4-AG-11`.`clients` (`pkid`),
  CONSTRAINT `COMPTE_CLIENT_FK02`
    FOREIGN KEY (`compte_pkid`)
    REFERENCES `420-PB4-AG-11`.`comptes` (`pkid`));

DROP TABLE IF EXISTS `420-PB4-AG-11`.`carte_bancaires`;
CREATE TABLE `420-PB4-AG-11`.`carte_bancaires` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `id_carte` VARCHAR(255) NOT NULL,
  `numero_identification_personnel` VARCHAR(255) NOT NULL,
  `date_activation` DATETIME NOT NULL,
  `date_expiration` DATETIME NOT NULL,
  `banque_pkid` INT NOT NULL,
  `compte_client_pkid` INT NOT NULL,
  PRIMARY KEY (`pkid`),
  CONSTRAINT `CARTE_BANCAIRE_FK01`
    FOREIGN KEY (`banque_pkid`)
    REFERENCES `420-PB4-AG-11`.`banques` (`pkid`),
  CONSTRAINT `CARTE_BANCAIR_FK02`
    FOREIGN KEY (`compte_client_pkid`)
    REFERENCES `420-PB4-AG-11`.`compte_clients` (`pkid`)
  );

DROP TABLE IF EXISTS `420-PB4-AG-11`.`compte_carte_bancaires`;
CREATE TABLE `420-PB4-AG-11`.`compte_carte_bancaires` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `compte_pkid` INT NOT NULL,
  `carte_bancaire_pkid` INT NOT NULL,
  PRIMARY KEY (`pkid`),
  CONSTRAINT `COMPTE_CARTE_BANCAIRE_FK01`
    FOREIGN KEY (`compte_pkid`)
    REFERENCES `420-PB4-AG-11`.`comptes` (`pkid`),
  CONSTRAINT `COMPTE_CARTE_BANCAIRE_FK02`
    FOREIGN KEY (`carte_bancaire_pkid`)
    REFERENCES `420-PB4-AG-11`.`carte_bancaires` (`pkid`)
  );

DROP TABLE IF EXISTS `420-PB4-AG-11`.`info_journal_transactions`;
CREATE TABLE `420-PB4-AG-11`.`info_journal_transactions` (
  `pkid` INT NOT NULL AUTO_INCREMENT,
  `code_id_carte` VARCHAR(255) NOT NULL,
  `date_transaction` DATETIME NOT NULL,
  `id_banque` VARCHAR(255) NOT NULL,
  `id_gab` VARCHAR(255) NOT NULL,
  `type_transaction` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`pkid`)
  );

-- Cleanup
DELETE FROM `420-PB4-AG-11`.`info_journal_transactions`;
DELETE FROM `420-PB4-AG-11`.`compte_carte_bancaires`;
DELETE FROM `420-PB4-AG-11`.`carte_bancaires`;
DELETE FROM `420-PB4-AG-11`.`compte_clients`;
DELETE FROM `420-PB4-AG-11`.`clients`;
DELETE FROM `420-PB4-AG-11`.`guichet_automatique_bancaires`;
DELETE FROM `420-PB4-AG-11`.`comptes`;
DELETE FROM `420-PB4-AG-11`.`banques`;
