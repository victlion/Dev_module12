package org.example;


import org.example.crud.ClientCrud;
import org.example.crud.PlanetCrud;
import org.example.entity.Client;

public class Main {
    public static void main(String[] args) {
        Flyway_migration.process(); // start migration

        ClientCrud clientCrud = new ClientCrud(); // test client CRUD

        clientCrud.create("New_client");
        clientCrud.update(8L,"Update_name");
        System.out.println(clientCrud.read(8L));
        clientCrud.delete(9L);

        PlanetCrud planetCrud = new PlanetCrud(); //test planet CRUD
        planetCrud.update("VEN","NewPlanet");
        planetCrud.create("PLANET","NEW_PLANET");
        System.out.println(planetCrud.read("JUP"));
        planetCrud.delete("MARS");
    }
}
