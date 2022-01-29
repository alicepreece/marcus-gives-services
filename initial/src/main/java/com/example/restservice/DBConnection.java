package com.example.restservice;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DBConnection {

    @Value("spring.data.mongodb.uri")
    private String url;
    private static MongoClient mongoClient;
    private static DBConnection dbConnection;

    private DBConnection() {
        System.out.println("url found here:" + url);
        ConnectionString connectionString = new ConnectionString("mongodb+srv://qmulssdc1:pw-qmulssdc1@qmulssdc1.ou1k2.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
    }

    public static MongoClient getDBConnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return mongoClient;
    }

    public static void closeDBConnection() {
        mongoClient.close();
    }
}
