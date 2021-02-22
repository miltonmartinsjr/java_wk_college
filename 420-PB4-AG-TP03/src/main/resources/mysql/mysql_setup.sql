From mysql workbench run the following sql statements:

  SET @@global.time_zone = '+00:00';
  SET @@session.time_zone = '+00:00';

with the following sql statements check if the values were set:

  SELECT @@global.time_zone, @@session.time_zone;


CREATE SCHEMA `420-PB4-AG-TP03` ;

INSERT INTO `420-PB4-AG-TP03`.`departements` (`pkid`, `description`) VALUES ('01', 'Informatique');

INSERT INTO `420-PB4-AG-TP03`.`statut_professeurs` (`pkid`, `description`) VALUES ('0', 'Actif');
INSERT INTO `420-PB4-AG-TP03`.`statut_professeurs` (`pkid`) VALUES ('99');

INSERT INTO `420-PB4-AG-TP03`.`statut_offre_de_cours` (`pkid`, `description`) VALUES ('0', 'Ouverte');
INSERT INTO `420-PB4-AG-TP03`.`statut_offre_de_cours` (`pkid`) VALUES ('99');

INSERT INTO `420-PB4-AG-TP03`.`statut_factures` (`pkid`, `description`) VALUES ('0', 'Nouvelle');

INSERT INTO `420-PB4-AG-TP03`.`semestres` (`pkid`, `description`) VALUES ('201901', 'Hiver 2019');

INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('1', '20190001', 'etudiant.20190001.nom', 'etudiant.201900001.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('2', '20190002', 'etudiant.20190002.nom', 'etudiant.201900002.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('3', '20190003', 'etudiant.20190003.nom', 'etudiant.201900003.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('4', '20190004', 'etudiant.20190004.nom', 'etudiant.201900004.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('5', '20190005', 'etudiant.20190005.nom', 'etudiant.201900005.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('6', '20190006', 'etudiant.20190006.nom', 'etudiant.201900006.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('7', '20190007', 'etudiant.20190007.nom', 'etudiant.201900007.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('8', '20190008', 'etudiant.20190008.nom', 'etudiant.201900008.prenom');
INSERT INTO `420-PB4-AG-TP03`.`etudiants` (`pkid`, `matricule`, `nom`, `prenom`) VALUES ('9', '20190009', 'etudiant.20190009.nom', 'etudiant.201900009.prenom');

INSERT INTO `420-PB4-AG-TP03`.`professeurs` (`pkid`, `nom`, `prenom`, `statut_professeur_pkid`) VALUES ('1', 'professeur.1.nom', 'professeur.1.prenom', '0');
INSERT INTO `420-PB4-AG-TP03`.`professeurs` (`pkid`, `nom`, `prenom`, `statut_professeur_pkid`) VALUES ('2', 'professeur.2.nom', 'professeur.2.prenom', '0');
INSERT INTO `420-PB4-AG-TP03`.`professeurs` (`pkid`, `nom`, `prenom`, `statut_professeur_pkid`) VALUES ('3', 'professeur.3.nom', 'professeur.3.prenom', '0');
INSERT INTO `420-PB4-AG-TP03`.`professeurs` (`pkid`, `nom`, `prenom`, `statut_professeur_pkid`) VALUES ('4', 'professeur.4.nom', 'professeur.4.prenom', '0');
INSERT INTO `420-PB4-AG-TP03`.`professeurs` (`pkid`, `nom`, `prenom`, `statut_professeur_pkid`) VALUES ('5', 'professeur.5.nom', 'professeur.5.prenom', '0');

INSERT INTO `420-PB4-AG-TP03`.`cours` (`pkid`, `description`) VALUES ('1', 'Cours.1');
INSERT INTO `420-PB4-AG-TP03`.`cours` (`pkid`, `description`) VALUES ('2', 'Cours.2');
INSERT INTO `420-PB4-AG-TP03`.`cours` (`pkid`, `description`) VALUES ('3', 'Cours.3');
INSERT INTO `420-PB4-AG-TP03`.`cours` (`pkid`, `description`) VALUES ('4', 'Cours.4');
