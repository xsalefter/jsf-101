# JSF 101 #

Very simple JSF use case with primefaces.

## How To Run ##

    mvn install
    mvn t7:run

Then go to `http://localhost:8080/jsf2-101-1.0/account/list.jsf`

If you want to make a change to JSF file while embedded tomcat running (hot deploy), 
make a some change and just call:

    mvn install

without restarting the server.