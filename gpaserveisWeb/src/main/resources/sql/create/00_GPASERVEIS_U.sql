 -- ------------------------------------------------------------------------------------
 --
 -- Descripció: Script de creació d´esquema: GPASERVEIS_U.sql.
 -- Usuari Oracle: SYSDBA
 -- Proveïdor: IECISA
 -- Data: 03-12-2018
 --
 -- ------------------------------------------------------------------------------------
 
CREATE TABLESPACE T_GPASERVEIS DATAFILE 'T_GPASERVEIS.DBF' size 250M;
CREATE TABLESPACE I_GPASERVEIS DATAFILE 'I_GPASERVEIS.DBF' size 5M;

CREATE USER GPASERVEIS_U IDENTIFIED BY GPASERVEIS_P DEFAULT TABLESPACE T_GPASERVEIS TEMPORARY TABLESPACE TEMP;

GRANT CONNECT, RESOURCE TO GPASERVEIS_U;