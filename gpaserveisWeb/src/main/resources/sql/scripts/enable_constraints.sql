 -- ------------------------------------------------------------------------------------
 --
 -- Descripció: Script que activa todas las foreign keys.
 -- Usuari Oracle: GPASERVEIS_U
 -- Proveïdor: IECISA
 -- Data: 03-12-2018
 --
 -- ------------------------------------------------------------------------------------

 -- Sentencia que genera las sentencias para activar las foreign keys:
 DECLARE 
 fk_query VARCHAR2(500);
 CURSOR fk_query_cursor 
 IS
 	SELECT 'alter table '||table_name||' enable constraint '||constraint_name||''
 	FROM user_constraints
 	WHERE constraint_type = 'R';
 BEGIN
	OPEN fk_query_cursor;
	LOOP
        FETCH fk_query_cursor INTO fk_query;
        EXIT WHEN fk_query_cursor%NOTFOUND;
        BEGIN
        	dbms_output.put_line(fk_query);
        	EXECUTE IMMEDIATE fk_query;
         EXCEPTION	
 		WHEN OTHERS THEN
			dbms_output.put_line('Error code ' || SQLCODE || ': ' || SQLERRM);
		END;
    END LOOP;
 	CLOSE fk_query_cursor;
 END;
 /