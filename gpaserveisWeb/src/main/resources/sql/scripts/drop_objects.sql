 -- ------------------------------------------------------------------------------------
 --
 -- Descripció: Script que borra los objectos del esquema.
 -- Usuari Oracle: GPASERVEIS_U
 -- Proveïdor: IECISA
 -- Data: 03-12-2018
 --
 -- ------------------------------------------------------------------------------------

 -- Sentencia que borra las tablas, secuencias,...:
BEGIN

  --Bye Sequences!
  FOR i IN (SELECT us.sequence_name
              FROM USER_SEQUENCES us) LOOP
    EXECUTE IMMEDIATE 'drop sequence '|| i.sequence_name ||'';
  END LOOP;

  --Bye Tables!
  FOR i IN (SELECT ut.table_name
              FROM USER_TABLES ut) LOOP
    EXECUTE IMMEDIATE 'drop table '|| i.table_name ||' CASCADE CONSTRAINTS ';
  END LOOP;
  
  --Bye Triggers!
  FOR i IN (SELECT ut.trigger_name
              FROM USER_TRIGGERS ut) LOOP
    EXECUTE IMMEDIATE 'drop trigger '|| i.trigger_name ||'';
  END LOOP;  

END;
 /
 
