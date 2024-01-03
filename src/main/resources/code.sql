/*
Created: 12/5/2023
Modified: 12/11/2023
Project: Operator Telekomunikacyjny
Model: OperatorTelekomunikacyjny (1.0) (1.0)
Company: Essunia Inc.
Author: Jakub Sierocki, Maciej Nadolski
Database: Oracle 19c
*/


-- Create sequences section -------------------------------------------------

CREATE SEQUENCE Operator_telekomunikacyjnyS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/


CREATE SEQUENCE NadajnikiS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE UslugiS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE PracownicyS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE KlienciS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE OddzialyS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE WynagrodzeniaS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/

CREATE SEQUENCE UzytkownicyS
    INCREMENT BY 1
    START WITH 1
    NOMAXVALUE
 NOMINVALUE
 CACHE 20
/



-- Create tables section -------------------------------------------------

-- Table Operatorzy_telekomunikacyjni

CREATE TABLE Operatorzy_telekomunikacyjni(
                                             ID_operatora Integer NOT NULL,
                                             Nazwa Varchar2(30 ) NOT NULL,
                                             NIP Varchar2(10 ) NOT NULL,
                                             Email Varchar2(30 ) NOT NULL,
                                             Numer_telefonu Varchar2(15 ) NOT NULL
)
    /


-- Add keys for table Operatorzy_telekomunikacyjni

ALTER TABLE Operatorzy_telekomunikacyjni ADD CONSTRAINT Unique_Identifier1 PRIMARY KEY (ID_operatora)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Operatorzy_telekomunikacyjni.ID_operatora IS 'Unikatowy identyfikator operatora telekomunikacyjnego'
/
COMMENT ON COLUMN Operatorzy_telekomunikacyjni.Nazwa IS 'Nazwa operatora telekomunikacyjnego'
/
COMMENT ON COLUMN Operatorzy_telekomunikacyjni.NIP IS 'Numer NIP operatora telekomunikacyjnego'
/
COMMENT ON COLUMN Operatorzy_telekomunikacyjni.Email IS 'Adres email operatora telekomunikacyjnego
'
/
COMMENT ON COLUMN Operatorzy_telekomunikacyjni.Numer_telefonu IS 'Numer telefonu operatora telekomunikacyjnego'
/


-- Create tables section -------------------------------------------------

-- Table Uzytkownicy

CREATE TABLE Uzytkownicy(
                            ID_uzytkownika Integer NOT NULL,
                            Nick Varchar2(30 ) NOT NULL,
                            Haslo Varchar2(30 ) NOT NULL,
                            Rola Varchar2(30 ) NOT NULL
)
    /

-- Add keys for table Operatorzy_telekomunikacyjni

ALTER TABLE Uzytkownicy ADD CONSTRAINT Unique_Identifier111 PRIMARY KEY (ID_uzytkownika)
    /

-- Table Oddzialy

CREATE TABLE Oddzialy(
                         ID_oddzialu Integer NOT NULL,
                         Nazwa Varchar2(20 ) NOT NULL,
                         Numer_telefonu Varchar2(15 ) NOT NULL,
                         ID_operatora Integer NOT NULL
)
    /

-- Create indexes for table Oddzialy

CREATE INDEX IX_Ma ON Oddzialy (ID_operatora)
    /


-- Add keys for table Oddzialy

ALTER TABLE Oddzialy ADD CONSTRAINT Unique_Identifier6 PRIMARY KEY (ID_oddzialu)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Oddzialy.ID_oddzialu IS 'Unikatowy identyfikator oddzialu'
/
COMMENT ON COLUMN Oddzialy.Nazwa IS 'Nazwa oddzialu'
/
COMMENT ON COLUMN Oddzialy.Numer_telefonu IS 'Numer telefonu oddzialu'
/

-- Table Uslugi

CREATE TABLE Uslugi(
                       ID_uslugi Integer NOT NULL,
                       Nazwa Varchar2(30 ) NOT NULL,
                       Typ_uslugi Varchar2(40 ) NOT NULL
                           CONSTRAINT UslugiCR CHECK (Typ_uslugi IN ('abonament telefoniczny','internet mobilny','internet swiatlowodowy','TV')),
                       Data_zawarcia_umowy Date NOT NULL,
                       Data_zakonczenia_umowy Date NOT NULL,
                       Czy_urzadzenie Char(1 ) NOT NULL
                           CONSTRAINT SprawnoscCR CHECK (Czy_urzadzenie IN ('T','N')),
                       Wartosc Number(10,2) NOT NULL,
                       ID_operatora Integer NOT NULL
)
    /

-- Create indexes for table Uslugi

CREATE INDEX IX_Oferuje ON Uslugi (ID_operatora)
    /

-- Add keys for table Uslugi

ALTER TABLE Uslugi ADD CONSTRAINT Unique_Identifier7 PRIMARY KEY (ID_uslugi)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Uslugi.ID_uslugi IS 'Unikatowy identyfikator uslugi'
/
COMMENT ON COLUMN Uslugi.Nazwa IS 'Nazwa uslugi'
/
COMMENT ON COLUMN Uslugi.Typ_uslugi IS 'Typ uslugi'
/
COMMENT ON COLUMN Uslugi.Data_zawarcia_umowy IS 'Data zawarcia umowy'
/
COMMENT ON COLUMN Uslugi.Data_zakonczenia_umowy IS 'Data zakonczenia umowy'
/
COMMENT ON COLUMN Uslugi.Czy_urzadzenie IS 'Flaga okreslajaca czy do umowy dolaczone jest urzadzenie'
/
COMMENT ON COLUMN Uslugi.Wartosc IS 'Wartosc uslugi'
/

-- Table Klienci

CREATE TABLE Klienci(
                        ID_klienta Integer NOT NULL,
                        Imie Varchar2(20 ) NOT NULL,
                        Nazwisko Varchar2(30 ) NOT NULL,
                        Numer_telefonu Varchar2(15 ) NOT NULL,
                        ID_operatora Integer NOT NULL
)
    /

-- Create indexes for table Klienci

CREATE INDEX IX_Obsluguje ON Klienci (ID_operatora)
    /


-- Add keys for table Klienci

ALTER TABLE Klienci ADD CONSTRAINT Unique_Identifier8 PRIMARY KEY (ID_klienta)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Klienci.ID_klienta IS 'Unikatowy identyfikator klienta'
/
COMMENT ON COLUMN Klienci.Numer_telefonu IS 'Imie klienta'
/
COMMENT ON COLUMN Klienci.Numer_telefonu IS 'Nazwisko klienta'
/
COMMENT ON COLUMN Klienci.Numer_telefonu IS 'Numer telefonu klienta'
/


-- Table Nadajniki

CREATE TABLE Nadajniki(
                          ID_nadajnika INTEGER DEFAULT NadajnikiS.NEXTVAL NOT NULL,
                          Wysokosc Float(1) NOT NULL,
                          Pasmo Float(2) NOT NULL,
                          Czy_sprawny Char(1 ) NOT NULL
                              CONSTRAINT SprawdzenieCR CHECK (Czy_sprawny IN ('T','N')),
                          ID_operatora Integer NOT NULL
)
    /

-- Create indexes for table Nadajniki

CREATE INDEX IX_Posiada ON Nadajniki (ID_operatora)
    /

-- Add keys for table Nadajniki

ALTER TABLE Nadajniki ADD CONSTRAINT Unique_Identifier11 PRIMARY KEY (ID_nadajnika)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Nadajniki.Wysokosc IS 'Wysokosc nadajnika n.p.m.'
/
COMMENT ON COLUMN Nadajniki.Pasmo IS 'Pasmo nadajnika'
/
COMMENT ON COLUMN Nadajniki.Czy_sprawny IS 'Flaga kontrola czy jest sprawny (T,N)'
/

-- Table Pracownicy

CREATE TABLE Pracownicy(
                           ID_pracownika Integer NOT NULL,
                           Imie Varchar2(20 ) NOT NULL,
                           Nazwisko Varchar2(30 ) NOT NULL,
                           Plec Char(1 ) NOT NULL
                               CONSTRAINT PlecCR CHECK (PLEC IN ('K','M')),
                           PESEL Char(11 ) NOT NULL,
                           Data_zatrudnienia Date NOT NULL,
                           Data_zwolnienia Date,
                           ID_operatora Integer NOT NULL
)
    /

-- Create indexes for table Pracownicy

CREATE INDEX IX_Zatrudnia ON Pracownicy (ID_operatora)
    /


-- Add keys for table Pracownicy

ALTER TABLE Pracownicy ADD CONSTRAINT Unique_Identifier12 PRIMARY KEY (ID_pracownika)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Pracownicy.ID_pracownika IS 'Unikatowy identyfikator pracownika'
/
COMMENT ON COLUMN Pracownicy.Imie IS 'Imie pracownika'
/
COMMENT ON COLUMN Pracownicy.Nazwisko IS 'Nazwisko pracownika'
/
COMMENT ON COLUMN Pracownicy.Plec IS 'Plec pracownika'
/
COMMENT ON COLUMN Pracownicy.PESEL IS 'Numer PESEL pracownika'
/
COMMENT ON COLUMN Pracownicy.Data_zatrudnienia IS 'Data zatrudnienia pracownika'
/
COMMENT ON COLUMN Pracownicy.Data_zwolnienia IS 'Data zwolnienia pracownika'
/

-- Table Udostepnianie_uslug

CREATE TABLE Udostepnianie_uslug(
                                    ID_oddzialu Integer NOT NULL,
                                    ID_uslugi Integer NOT NULL
)
    /

-- Table Umowy

CREATE TABLE Umowy(
                      ID_uslugi Integer NOT NULL,
                      ID_klienta Integer NOT NULL
)
    /

-- Table Zatrudnienie_pracownikow

CREATE TABLE Zatrudnienie_pracownikow(
                                         ID_pracownika Integer NOT NULL,
                                         ID_oddzialu Integer NOT NULL
)
    /

-- Table Obsluga

CREATE TABLE Obsluga(
                        ID_nadajnika Integer NOT NULL,
                        ID_pracownika Integer NOT NULL
)
    /


-- Table Wynagrodzenia

CREATE TABLE Wynagrodzenia(
                              ID_wynagrodzenia Integer NOT NULL,
                              Data_przyznania Date NOT NULL,
                              Pensja_podstawowa Number(8,2) NOT NULL,
                              Premia Number(8,2),
                              ID_pracownika Integer NOT NULL
)
    /

-- Create indexes for table Wynagrodzenia

CREATE INDEX IX_Relationship18 ON Wynagrodzenia (ID_pracownika)
    /

-- Add keys for table Wynagrodzenia

ALTER TABLE Wynagrodzenia ADD CONSTRAINT PK_Wynagrodzenia PRIMARY KEY (ID_wynagrodzenia)
    /

-- Table and Columns comments section

COMMENT ON COLUMN Wynagrodzenia.ID_wynagrodzenia IS 'Unikatowy identyfikator wynagrodzenia'
/
COMMENT ON COLUMN Wynagrodzenia.Data_przyznania IS 'Data przyznania'
/
COMMENT ON COLUMN Wynagrodzenia.Pensja_podstawowa IS 'Pensja podstawowa'
/
COMMENT ON COLUMN Wynagrodzenia.Premia IS 'Premia wynagrodzenia'
/

-- Trigger for sequence Operator_telekomunikacyjnyS for column ID_operatora in table Operatorzy_telekomunikacyjni ---------
CREATE OR REPLACE TRIGGER ts_Operatorzy_telekomunikacyjni_Operator_telekomunikacyjnyS BEFORE INSERT
ON Operatorzy_telekomunikacyjni FOR EACH ROW
BEGIN
  :new.ID_operatora := Operator_telekomunikacyjnyS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Operatorzy_telekomunikacyjni_Operator_telekomunikacyjnyS AFTER UPDATE OF ID_operatora
                                                                                             ON Operatorzy_telekomunikacyjni FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_operatora in table Operatorzy_telekomunikacyjni as it uses sequence.');
END;
/

-- Trigger for sequence OddzialyS for column ID_oddzialu in table Oddzialy ---------
CREATE OR REPLACE TRIGGER ts_Oddzialy_OddzialyS BEFORE INSERT
ON Oddzialy FOR EACH ROW
BEGIN
  :new.ID_oddzialu := OddzialyS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Oddzialy_OddzialyS AFTER UPDATE OF ID_oddzialu
                                                       ON Oddzialy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_oddzialu in table Oddzialy as it uses sequence.');
END;
/

-- Trigger for sequence UzytkownicyS for column ID_uzytkownika in table Uzytkownicy ---------
CREATE OR REPLACE TRIGGER ts_Uzytkownicy_UzytkownicyS BEFORE INSERT
ON Uzytkownicy FOR EACH ROW
BEGIN
  :new.ID_uzytkownika := UzytkownicyS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Uzytkownicy_UzytkownictS AFTER UPDATE OF ID_uzytkownika
                                                             ON Uzytkownicy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_uzytkownika in table Uzytkownicy as it uses sequence.');
END;
/

-- Trigger for sequence UslugiS for column ID_uslugi in table Uslugi ---------
CREATE OR REPLACE TRIGGER ts_Uslugi_UslugiS BEFORE INSERT
ON Uslugi FOR EACH ROW
BEGIN
  :new.ID_uslugi := UslugiS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Uslugi_UslugiS AFTER UPDATE OF ID_uslugi
                                                   ON Uslugi FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_uslugi in table Uslugi as it uses sequence.');
END;
/

-- Trigger for sequence KlienciS for column ID_klienta in table Klienci ---------
CREATE OR REPLACE TRIGGER ts_Klienci_KlienciS BEFORE INSERT
ON Klienci FOR EACH ROW
BEGIN
  :new.ID_klienta := KlienciS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Klienci_KlienciS AFTER UPDATE OF ID_klienta
                                                     ON Klienci FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_klienta in table Klienci as it uses sequence.');
END;
/

-- Trigger for sequence NadajnikiS for column ID_nadajnika in table Nadajniki ---------
CREATE OR REPLACE TRIGGER ts_Nadajniki_NadajnikiS BEFORE INSERT
ON Nadajniki FOR EACH ROW
BEGIN
  :new.ID_nadajnika := NadajnikiS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Nadajniki_NadajnikiS AFTER UPDATE OF ID_nadajnika
                                                         ON Nadajniki FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_nadajnika in table Nadajniki as it uses sequence.');
END;
/

-- Trigger for sequence PracownicyS for column ID_pracownika in table Pracownicy ---------
CREATE OR REPLACE TRIGGER ts_Pracownicy_PracownicyS BEFORE INSERT
ON Pracownicy FOR EACH ROW
BEGIN
  :new.ID_pracownika := PracownicyS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Pracownicy_PracownicyS AFTER UPDATE OF ID_pracownika
                                                           ON Pracownicy FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_pracownika in table Pracownicy as it uses sequence.');
END;
/




-- Trigger for sequence WynagrodzeniaS for column ID_wynagrodzenia in table Wynagrodzenia ---------
CREATE OR REPLACE TRIGGER ts_Wynagrodzenia_WynagrodzeniaS BEFORE INSERT
ON Wynagrodzenia FOR EACH ROW
BEGIN
  :new.ID_wynagrodzenia := WynagrodzeniaS.nextval;
END;
/
CREATE OR REPLACE TRIGGER tsu_Wynagrodzenia_WynagrodzeniaS AFTER UPDATE OF ID_wynagrodzenia
                                                                 ON Wynagrodzenia FOR EACH ROW
BEGIN
  RAISE_APPLICATION_ERROR(-20010,'Cannot update column ID_wynagrodzenia in table Wynagrodzenia as it uses sequence.');
END;
/


-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE Oddzialy ADD CONSTRAINT Operator_ma FOREIGN KEY (ID_operatora) REFERENCES Operatorzy_telekomunikacyjni (ID_operatora)
    /



ALTER TABLE Uslugi ADD CONSTRAINT Operator_oferuje FOREIGN KEY (ID_operatora) REFERENCES Operatorzy_telekomunikacyjni (ID_operatora)
    /



ALTER TABLE Nadajniki ADD CONSTRAINT Operator_posiada FOREIGN KEY (ID_operatora) REFERENCES Operatorzy_telekomunikacyjni (ID_operatora)
    /



ALTER TABLE Pracownicy ADD CONSTRAINT Operator_zatrudnia FOREIGN KEY (ID_operatora) REFERENCES Operatorzy_telekomunikacyjni (ID_operatora)
    /



ALTER TABLE Klienci ADD CONSTRAINT Operator_Obsluguje FOREIGN KEY (ID_operatora) REFERENCES Operatorzy_telekomunikacyjni (ID_operatora)
    /


ALTER TABLE Wynagrodzenia ADD CONSTRAINT Pracownik_ma_wynagordzenie FOREIGN KEY (ID_pracownika) REFERENCES Pracownicy (ID_pracownika)
    /





