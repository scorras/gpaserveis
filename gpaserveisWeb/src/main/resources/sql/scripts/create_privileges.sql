 -- ------------------------------------------------------------------------------------
 --
 -- Descripció: Script que aplica permisos al usuario consulta GPASERVEIS_CONS.
 -- Usuari Oracle: GPASERVEIS_U
 -- Proveïdor: IECISA
 -- Data: 03-12-2018
 --
 -- ------------------------------------------------------------------------------------

--Grants
SELECT 'GRANT SELECT, INSERT, UPDATE, DELETE ON ' || table_name || ' to GPASERVEIS_CONS;' from user_tables;
SELECT 'GRANT SELECT ON ' || sequence_name || ' to GPASERVEIS_CONS;' from user_sequences;


--Synonyms
SELECT 'CREATE OR REPLACE SYNONYM GPASERVEIS_CONS.' || table_name || ' FOR ' || table_name || ';' from user_tables;
SELECT 'CREATE OR REPLACE SYNONYM GPASERVEIS_CONS.' || sequence_name || ' FOR ' || sequence_name || ';' from user_sequences;
