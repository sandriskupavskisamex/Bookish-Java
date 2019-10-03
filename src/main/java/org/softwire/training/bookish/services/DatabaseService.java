package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;

public abstract class DatabaseService {

    String hostname = "localhost";
    String database = "library";
    String user = "root";
    String password = "1258LUki";
    String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    protected final Jdbi jdbi = Jdbi.create(connectionString);
}
