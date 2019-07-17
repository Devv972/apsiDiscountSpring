
drop table panierArticle;
drop table article;
drop table constructeur;
drop table categorie;
drop table client;
drop table panier;



drop sequence article_seq;
drop sequence constructeur_seq;
drop sequence categorie_seq;
drop sequence client_seq;
drop sequence panier_seq;

create table constructeur (
    id numeric not null primary key,
    nom varchar(30) not null
);

create table categorie (
    id numeric not null primary key,
    nom varchar(30) not null
);


create table article(
    id numeric not null primary key,
    designation varchar(50)not null,
    image varchar(200) null,
    prix decimal(7,2) not null,
    content varchar(1000)not null,
    categorie_id numeric not null,
    constructeur_id numeric not null,
    dateMiseEnLigne date null,
    stock numeric not null,
    constraint FK_article_constructeur foreign key (constructeur_id) references constructeur(id),
    constraint FK_article_categorie foreign key (categorie_id) references categorie(id)
);

create table panier (
    id numeric not null primary key
);

create table panierArticle(
    panier_id numeric not null,
    article_id numeric not null,
    constraint PK_panierArticle primary key (panier_id,article_id),
    constraint FK_panierArticle_panier foreign key (panier_id) references panier(id),
    constraint FK_panierArticle_article foreign key (article_id) references article(id)
);

CREATE TABLE CLIENT(
    ID NUMBER(5,0) NOT NULL ENABLE,
	NOM VARCHAR(100) NOT NULL ENABLE,
	PRENOM VARCHAR(60) NOT NULL ENABLE,
	ADRESSE VARCHAR(200) DEFAULT NULL,
	CODE_POSTAL VARCHAR(6) DEFAULT NULL,
	VILLE VARCHAR(60) DEFAULT NULL,
	PAYS VARCHAR(60) DEFAULT NULL,
	EMAIL VARCHAR(100) DEFAULT NULL,
	DATE_NAISSANCE DATE DEFAULT NULL,
	mdp varchar(10) not null ,
    panier_id numeric DEFAULT null,
    PRIMARY KEY (ID),
    constraint FK_client_panier foreign key (panier_id) references panier(id)
);
create sequence article_seq;
create sequence constructeur_seq;
create sequence categorie_seq;
create sequence client_seq;
create sequence panier_seq;



INSERT INTO Client VALUES (client_seq.NEXTVAL,'Dupont','Jean','Rue du Centre, 5','45810','Houtsiplou','France','jean.dupont@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Boudur','Marie','Place de la Gare, 2','35840','Troudumonde','France','marie.boudur@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Trachon','Fleur','Rue haute, 54b','3250','Belville','Belgique','fleurtrachon@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Van Piperseel','Julien',NULL,NULL,NULL,NULL,'jeanvp@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Nouvel','Johan',NULL,NULL,NULL,'Suisse','johanetpirlouit@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Germain','Frank',NULL,NULL,NULL,NULL,'francoisgermain@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Antoine','Maximilien','Rue Moineau, 123','4580','Trocoul','Belgique','max.antoine@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Di Paolo','Hector',NULL,NULL,NULL,'Suisse','hectordipao@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Corduro','Anaelle',NULL,NULL,NULL,NULL,'ana.corduro@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Faluche','Eline','Avenue circulaire, 7','45870','Garduche','France','elinefaluche@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Penni','Carine','Boulevard Haussman, 85','1514','Plasse','Suisse','cpenni@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Broussaille','Virginie','Rue du Fleuve, 18','45810','Houtsiplou','France','vibrousaille@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Durant','Hannah','Rue des Pendus, 66','1514','Plasse','Suisse','hhdurant@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Delfour','Elodie','Rue de Flore, 1','3250','Belville','Belgique','e.delfour@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Kestau','Joel',NULL,NULL,NULL,NULL,'joel.kestau@email.com',NULL,'0000',NULL);
INSERT INTO Client VALUES (client_seq.NEXTVAL,'Gayerie','David','Rue du Centre','33000','Bordeaux','France','david.gayerie@email.com','01-01-2019','0000',NULL);

insert into constructeur  values (constructeur_seq.NEXTVAL,'asus');
insert into constructeur  values (constructeur_seq.NEXTVAL,'acer');
insert into constructeur  values (constructeur_seq.NEXTVAL,'samsung');
insert into constructeur  values (constructeur_seq.NEXTVAL,'evga');
insert into constructeur  values (constructeur_seq.NEXTVAL,'iiyama');
insert into constructeur  values (constructeur_seq.NEXTVAL,'logitech');
insert into constructeur  values (constructeur_seq.NEXTVAL,'gigabyte');
insert into constructeur  values (constructeur_seq.NEXTVAL,'MSI');
insert into constructeur  values (constructeur_seq.NEXTVAL,'intel');
insert into constructeur  values (constructeur_seq.NEXTVAL,'AMD');


insert into categorie  values (categorie_seq.NEXTVAL,'écran');
insert into categorie  values (categorie_seq.NEXTVAL,'clavier');
insert into categorie  values (categorie_seq.NEXTVAL,'carte graphique');
insert into categorie  values (categorie_seq.NEXTVAL,'cpu');
insert into categorie  values (categorie_seq.NEXTVAL,'carte mère');
insert into categorie  values (categorie_seq.NEXTVAL,'stockage');
insert into categorie  values (categorie_seq.NEXTVAL,'souris');


insert into article values (article_seq.NEXTVAL, 'ASUS Ecran Gaming MG248QE','/assets/images/materiel/ASUS Ecran Gaming MG248QE.PNG',219.00,
'Ecran LCD à rétroéclairage LED - matrice active TFT
Interfaces : DisplayPort, HDMI, DVI-D (double connexion), Casque
Résolution native : Full HD (1080p) 1920 x 1080 à 144 Hz
Temps de réponse : 1 ms (gris à gris)
Type de panneau : TN
Luminosité : 350 cd-m²
Rapport de contraste : 100000000:1 (dynamique)',1,1,null,5);

insert into article values (article_seq.NEXTVAL, 'MSI Optix MAG241C','/assets/images/materiel/MSI Optix MAG241C.PNG',214.00,
'Ecran Gamer Incurvé 23,6" - FHD - 1ms - 144Hz - DisplayPort / HDMI
Ecran LCD à rétroéclairage LED - matrice active TFT
Interfaces : DisplayPort, 2 x HDMI, Amont USB 2.0 (Type B), 2 x aval USB 2.0, Casque
Résolution native : Full HD (1080p) 1920 x 1080 (DisplayPort: 144 Hz, HDMI: 144 Hz)
Temps de réponse : 1 ms (MPRT)
Type de panneau : VA
Luminosité : 300 cd-m²
Rapport de contraste : 3000:1 - 100000000:1 (dynamique)',1,8,current_date,20);
insert into article values (article_seq.NEXTVAL, 'SAMSUNG Ecran incurvé C24FG73','/assets/images/materiel/SAMSUNG Ecran incurvé C24FG73.PNG',309.99,
'24" Full HD - Dalle VA - 1ms - HDMI/DP - FreeSync
QLED monitor - matrice active TFT
Interfaces : DisplayPort, 2 x HDMI, Casque
Résolution native : Full HD (1080p) 1920 x 1080 à 144 Hz
Temps de réponse : 1 ms
Type de panneau : VA
Luminosité : 350 cd-m²
Rapport de contraste : 3000:1',1,3,current_date,5);

insert into article values (article_seq.NEXTVAL, 'GIGABYTE Carte Mère Z370P D3','/assets/images/materiel/GIGABYTE Carte Mère Z370P D3.PNG',109.99,
'Carte-mère - ATX - Socket LGA1151
Technologie : DDR4
Interfaces : 1 x LAN (Gigabit Ethernet), 1 x HDMI, 1 x clavier PS-2, 1 x sortie de ligne audio - mini-jack, 1 x entrée de ligne audio - mini-jack, 1 x microphone - mini-jack,
',5,7,current_date,6);
insert into article values (article_seq.NEXTVAL, 'ASUS Carte Mère ROG MAXIMUS X HERO','/assets/images/materiel/ASUS Carte Mère ROG MAXIMUS X HERO.PNG',273.27,
'Carte-mère - ATX - Socket LGA1151
Technologie : DDR4
Interfaces : 1 x HDMI, 1 x DisplayPort, 4 x USB 3.1 Gen 1, 1 x LAN (Gigabit Ethernet), 1 x entrée de ligne audio - mini-jack, 1 x sortie de ligne audio - mini-jack,
',5,1,current_date,2);
insert into article values (article_seq.NEXTVAL, 'LOGITECH Souris Gamer G402','/assets/images/materiel/LOGITECH Souris Gamer G402 Hyperion Fury FPS.PNG',29.99,
'La souris Logitech G402 Hyperion Fury est la souris pour le jeu la plus rapide au monde, grâce à la technologie de moteur à fusion qui permet le suivi à une vitesse de plus de 1 m/s, en plus de ses 8 boutons programmables et ses 4 paramètres de résolution ppp.
',7,6,current_date,10);
insert into article values (article_seq.NEXTVAL, 'LOGITECH M330 Silent Plus','/assets/images/materiel/LOGITECH M330 Silent Plus.PNG',19.99,
'Souris - Connectivité sans fil 2,4 GHz de pointe
Résolution : 1000 ppp
Nombre de boutons : 3
Caractéristiques : Silencieuse : réduction des bruits de plus de 90 %',7,6,current_date,10);
insert into article values (article_seq.NEXTVAL, 'LOGITECH M187 Noir','/assets/images/materiel/LOGITECH M187 Noir.PNG',16.95,
'Souris sans fil - Format de poche ultra-compacte - Récepteur compact pour la connexion sans fil - Technologie sans fil 2,4 GHz de pointe Logitech pour une connexion fiable - Compatible PC (Windows Vista, 7, 8 et Windows 10), Mac et Linux - Garantie du fabricant 1 an.
',7,6,current_date,5);
insert into article values (article_seq.NEXTVAL, 'GeForce® GTX 1050 Ti ','/assets/images/materiel/cg_1050ti.PNG',195.40,
'NVIDIA GeForce GTX 1050 Ti - 4 Go
Type de bus : PCI Express 3.0 x16
Horloge principale : 1316 MHz
Horloge boostée : 1430 MHz
Interfaces : DVI-D (liaison double), DisplayPort, HDMI
Technologie : GDDR5 SDRAM',3,1,current_date,5);

commit;

select * from constructeur;
select * from categorie;
