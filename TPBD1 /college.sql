create database college;



	create table Etudiant(
	NumeroDossier integer AUTO_INCREMENT, 
	CodePermanent integer,
	prenom varchar(15),
	nom varchar(40),
	constraint pk_NumeroDossier primary key(NumeroDossier)
	 	
	);


	create table cours(
	Id_Cours integer ,
	Titre varchar(30),
	constraint pk_Id_Cours primary key(Id_Cours) 	
	);

	create table etudiant_cours(
	Id_Cours integer not null,
	NumeroDossier integer not null,
	note double(6,2),
	constraint fk_Id_Cours foreign key(Id_Cours)
	references cours(Id_Cours),
	constraint fk_NumeroDossier foreign key(NumeroDossier)
	references Etudiant(NumeroDossier)
);
	
-- ajouter étudiant
insert into Etudiant(codePermanent,prenom,nom) values(221282,'ROBERTA','CORREA');
insert into Etudiant(codePermanent,prenom,nom) values(060976,'RODRIGO','CORREA');
insert into Etudiant(codePermanent,prenom,nom) values(221180,'GIOVANNA','SOUZA')	;
insert into Etudiant(codePermanent,prenom,nom)  values(271108,'PEDRO','MOTTA');
insert into Etudiant(codePermanent,prenom,nom)  values(160714,'MARCO','TEIXEIRA');
insert into Etudiant(codePermanent,prenom,nom)  values(070116,'CRISTAL','CORREA');
insert into Etudiant(codePermanent,prenom,nom)  values(240551,'VALDETE','CORREA');
insert into Etudiant(codePermanent,prenom,nom)  values(030750,'ROBERTO','CORREA');


-- ajouter cours
	insert into cours(Id_Cours,Titre) VALUES(01,'MATH');
	insert into cours(Id_Cours,Titre) VALUES(02,'FRANCAIS');
	insert into cours(Id_Cours,Titre) VALUES(03,'TI');
	insert into cours(Id_Cours,Titre) VALUES(04,'BASE DONNEE');
	

-- ajouter note
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(01,1,88);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(02,1,88);	
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(01,2,78);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(02,2,78);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(03,3,89);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(04,3,75);	
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(01,4,54);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(03,4,65);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(01,5,66);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(02,5,65);	
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(01,6,64);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(04,6,63);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(02,7,90);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(03,7,76);	
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(04,8,58);
insert into etudiant_cours(Id_Cours,NumeroDossier,note) values(03,8,61);

