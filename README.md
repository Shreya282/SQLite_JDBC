Download the latest version of SQLite JDBC Driver.

**Connect to an SQLite database via JDBC:**
1. Open command prompt, and navigate to the subfolder using the following command: 
cd c:\sqlite\java\connect\net\sqlite_jdbc
2. Compile the Connect.java file using the following command:
javac Connect.java
3. Change the current directory to the connect directory using the command - cd..
4. Run the net.sqlite_jdbc.Connect class using the following command:
java -classpath ".;sqlite-jdbc-3.36.0.3.jar" net.sqlite_jdbc.Connect

After performing all these steps Connection Established Successfully message will be displayed if the Connection is successful.
Now repeat steps 1-4 for each of the four java files(Connect.java , Createdb.java, CreateTable.java, Func.java)

**By performing the above steps:-**

• We are connecting to existing database "sample.db".

• Creating a new SQLite database named "sqlite_proj.db".

• In sqlite_proj.db we are creating a table named movies.

• Then we have written query to display all the records of the table, display the records based on actor's name and insert data into the table.
