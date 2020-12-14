 -- ------------------------------------------------------------------------------------
 --
 -- Descripció: Script de creació de packages, procedures, funcions i triggers: GPASERVEIS_P.sql.
 -- Usuari Oracle: GPASERVEIS_U
 -- Proveïdor: IECISA
 -- Data: 03-12-2018
 --
 -- ------------------------------------------------------------------------------------


CREATE OR REPLACE TRIGGER NLS_SETTINGS 

AFTER LOGON ON SCHEMA

  BEGIN
  
    EXECUTE IMMEDIATE 'ALTER SESSION SET NLS_SORT=BINARY_AI';
    EXECUTE IMMEDIATE 'ALTER SESSION SET NLS_COMP=LINGUISTIC';
    
  END NLS_SETTINGS;
  /





