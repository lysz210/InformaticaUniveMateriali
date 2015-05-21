Put all system files into a folder. Do not forget to include the folder helpFiles.

If your system is MacX or a recent version of Windows, with a java machine installed, 
to run the application it should be enough a click on the .jar file. 
Otherwise try one of the following methods.

MAC USERS: with JBindery   the  Class Name field should contain the name of 
the class 
                     InterpreteSQL.Main  

WIN USERS: create in the folder a file exec.bat which contains the commands

java -classpath JRSFileName.jar InterpreteSQL.Main 
exit

then modify, if necessary, the file C:\Autoexec.bat by adding the following row 

SET PATH=%PATH%;C:\<XXX>\bin

where <XXX> is the folder name with  JDK. Restart the system and then click
on file exec.bat.

WIN2000-XP: set the PATH environment variable in the 
'Control Panel-System-Environment-System Variables' :
1) select the variable Path in the system Variables
2) add value ";c:\<xxx>\bin"


===========

The JRS version with transactions creates the folder JRS_directory, 
in the folder where there is the application. The JRS_directory contains:

- the file $SYSDB$, where information about the system state is stored,

- a folder for each database created,

- the folder SYS_Log for the log (the folder can be deleted when JRS is 
not running)

When JRS is not running, if the file $SYSDB$ is deleted then also the 
created DB folder must be deleted. Tables and databased should always be
deleted from the system running.

===========

The JRS version without transactions creates the folder JRS_directory, 
in the folder where there is the application. The JRS_directory contains: 

- the file $SYSDB$, where information about the system state is stored,

- a folder for each database created.

When JRS is not running, if the file $SYSDB$ is deleted then also the 
created database folders must be deleted. Tables and a database  should always 
be deleted from the system running with an SQL command.

===========

A database created with the version without transactions cannot be used 
with the version with transactions, and viceversa. 

The file LoadSportDB.txt contains the SQL commands to create a database.
They can be loaded with the command Load in the menu File. 
Examples of queries are in the  file SQLByExamples under the Help button 
in the system window.

The JRS window provides a browser in the menu File to open a database and 
to explore the table definitions.
The selection of a database with the name DB is equivalent to the command:

connect BD;

SQL commands, which terminate with a semicolumn, are written in the input window 
and to execute them must first be selected.

Enjoy JRS! 