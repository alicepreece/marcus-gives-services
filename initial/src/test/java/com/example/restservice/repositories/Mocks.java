package com.example.restservice.repositories;

import com.example.restservice.models.*;

import java.util.ArrayList;
import java.util.List;

public class Mocks {

    public static List<Client> mockClientList() {
        List<Client> clients = new ArrayList<>();
        Client client1 = mockClient1();
        Client client2 = mockClient2();
        clients.add(client1);
        clients.add(client2);
        return clients;
    }

    public static Client mockClient1() {
        return new Client(1, mockUser(), "email", 123, "recommendation", mockDonationList(), mockDonationList(), 5000, "team", mockScores());
    }

    public static Client mockClient2() {
        return new Client(2, mockUser(), "email", 123, "beta", mockDonationList(), mockDonationList(), 5000, "team", mockScores());
    }

    public static List<Donation> mockDonationList() {
        List<Donation> donations = new ArrayList<>();
        Donation donation1 = new Donation(new Project(), 200, 54321234);
        Donation donation2 = new Donation(new Project(), 300, 54321235);
        donations.add(donation1);
        donations.add(donation2);
        return donations;
    }

    public static User mockUser() {
        return new User("username", "password", "firstName", "lastName", RoleEnum.CLIENT);
    }

    public static Scores mockScores() {
        List<String> regions = new ArrayList<>();
        regions.add("Europe");
        regions.add("East & South East Asia");
        return new Scores(1, true, false, false, true, "5", true, false, regions);
    }

    public static Project mockProject() {
        List<Integer> inv = new ArrayList<>();
        inv.add(1);
        inv.add(2);
        return new Project(1, "alpha", "Protect the Environment", 30000, "Europe", "Save the woodland", "Globally Diversified ESG", "3", inv, mockScores());
    }

    public static List<Project> mockProjectList() {
        List<Project> projects = new ArrayList<>();
        projects.add(mockProject());
        return projects;
    }
}
