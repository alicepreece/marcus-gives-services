package com.example.restservice.mocks;

import com.example.restservice.DBConnection;
import com.example.restservice.models.Client;
import com.example.restservice.models.Donation;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ClientRepository {
    private MongoCollection<Client> clients;


    public ClientRepository() {
        MongoDatabase database = DBConnection.getDBConnection().getDatabase("marcus-gives");
        clients = database.getCollection("clients", Client.class);
    }

    public List<Client> getClients() {
        try {
            List<Client> clientList = new ArrayList<>();
            clients.find(Client.class).into(clientList);
            return clientList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public Client getClientByID(String filterID) {
        try {
            Client client = clients.find(Filters.eq("id", Integer.parseInt(filterID)), Client.class).first();
            return client;
        } catch (Exception e) {
            return new Client();
        }
    }

    public Client getClientByUsername(String filterUsername) {
        try {
            Client client = clients.find(Filters.eq("user.username", filterUsername), Client.class).first();
            return client;
        } catch (Exception e) {
            return new Client();
        }
    }

    public int createClient(Client client) {
        try {
            clients.insertOne(client);
            return 200;
        } catch(Exception e) {
            return 500;
        }
    }

    public int updateClient(String clientId, Client client) {
        try {
            clients.updateOne(Filters.eq("id", Integer.parseInt(clientId)),
                    Updates.combine(
                            Updates.set("user.firstName", client.getUser().getFirstName()),
                            Updates.set("user.lastName", client.getUser().getLastName()),
                            Updates.set("user.username", client.getUser().getUsername()),
                            Updates.set("accountNumber", client.getAccountNumber()),
                            Updates.set("investableAmount", client.getInvestableAmount()),
                            Updates.set("emailAddress", client.getEmailAddress()),
                            Updates.set("recommendation", client.getRecommendation()),
                            Updates.set("donations", client.getDonations()),
                            Updates.set("pastDonations", client.getPastDonations()),
                            Updates.set("scores.id", -1),
                            Updates.set("scores.socialOverEnv", client.getScores().getSocialOverEnv()),
                            Updates.set("scores.economyOverHealthcare", client.getScores().getEconomyOverHealthcare()),
                            Updates.set("scores.povertyOverEducation", client.getScores().getPovertyOverEducation()),
                            Updates.set("scores.targetedOverDiverse", client.getScores().getTargetedOverDiverse()),
                            Updates.set("scores.managementFees", client.getScores().getManagementFees()),
                            Updates.set("scores.esgOverAll", client.getScores().getEsgOverAll()),
                            Updates.set("scores.shortOverLongTerm", client.getScores().getShortOverLongTerm()),
                            Updates.set("scores.region", client.getScores().getRegion())
                    )
            );
            return 200;
        } catch(Exception e) {
            throw e;
        }
    }

    public int updateClientDonation(int clientId, Donation donation) {
        try {
            Client client = this.getClientByID(Integer.toString(clientId));
            List<Donation> newDonations = client.getDonations();
            if (newDonations == null) {
                newDonations = new ArrayList<>();
            }
            newDonations.add(donation);
            int investableAmount = client.getInvestableAmount() - donation.getAmount();
            if (investableAmount < 0) {
                return 500;
            }
            clients.updateOne(Filters.eq("id", clientId),
                    Updates.combine(
                            Updates.set("donations", newDonations),
                            Updates.set("investableAmount", investableAmount)
                    )
            );
            System.out.println("Successful Client Donation");
            return 200;
        } catch (Exception e) {
            throw e;
        }
    }

    public int cancelDonation(int clientId, Donation donation) {
        try {
            Client client = this.getClientByID(Integer.toString(clientId));
            List<Donation> newDonations = client.getDonations().stream().filter(pro -> pro.getProject().getId() != donation.getProject().getId()).collect(Collectors.toList());
            List<Donation> pastDonations = client.getPastDonations();
            if (pastDonations == null) {
                pastDonations = new ArrayList<>();
            }
            pastDonations.add(donation);
            int investableAmount = client.getInvestableAmount() + donation.getAmount();
            clients.updateOne(Filters.eq("id", clientId),
                    Updates.combine(
                            Updates.set("donations", newDonations),
                            Updates.set("pastDonations", pastDonations),
                            Updates.set("investableAmount", investableAmount)
                    )
            );
            System.out.println("Successful Client Cancel");
            return 200;
        } catch (Exception e) {
            throw e;
        }
    }
}
