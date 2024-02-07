package org.example;

import org.flywaydb.core.Flyway;

public class Flyway_migration {
    public static void process() {

        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:~/testBase",null,null).load();

        flyway.migrate();
    }
}