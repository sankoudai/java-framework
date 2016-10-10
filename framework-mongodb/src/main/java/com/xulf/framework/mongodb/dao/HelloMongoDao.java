package com.xulf.framework.mongodb.dao;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;


/**
 * Created by sankoudai on 2016/10/10.
 */
public class HelloMongoDao {
    @Test
    public void connect() {
        // represents a pool of connections to the database
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        // mongoClient = new MongoClient(new MongoClientURI("mongo://localhost:27017"));

        //  a connection to a MongoDB server for the specified database
        MongoDatabase database = mongoClient.getDatabase("testdb");

        // get a collection
        MongoCollection<Document> col = database.getCollection("testCol");

        // release resources
        mongoClient.close();
    }


    @Test
    public void insert() {
        // Get collection
        MongoClient pool = new MongoClient("localhost", 27017);
        MongoDatabase testdb = pool.getDatabase("testdb");
        MongoCollection<Document> testCol = testdb.getCollection("testCol");

        // insert one
        Document document = new Document("name", "jim");
        testCol.insertOne(document);

        // insert Many
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 101; i++) {
            documents.add(new Document("i", i));
        }
        testCol.insertMany(documents);

        // release resource
        pool.close();
    }


    @Test
    public void update() {
        // Get collection
        MongoClient pool = new MongoClient("localhost", 27017);
        MongoDatabase testdb = pool.getDatabase("testdb");
        MongoCollection<Document> testCol = testdb.getCollection("testCol");

        //prepare: data
        testCol.drop();
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 101; i++) {
            documents.add(new Document("i", i));
        }
        testCol.insertMany(documents);

        //updateOne: update i=110 where i=10
        UpdateResult result = testCol.updateOne(eq("i", 10), set("i", 110));
        System.out.println("modified collections : " + result.getModifiedCount());

        //updateMany: update i=i+100 where i < 10
        result = testCol.updateMany(lt("i", 10), inc("i", 100));
        System.out.println("updateMany modified collections : " + result.getModifiedCount());


        // release resource
        pool.close();
    }

    @Test
    public void delete() {
        // Get collection
        MongoClient pool = new MongoClient("localhost", 27017);
        MongoDatabase testdb = pool.getDatabase("testdb");
        MongoCollection<Document> testCol = testdb.getCollection("testCol");

        //prepare: data
        testCol.drop();
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 101; i++) {
            documents.add(new Document("i", i));
        }
        testCol.insertMany(documents);

        //deleteOne: delete where i=10
        DeleteResult result = testCol.deleteOne(eq("i", 10));
        System.out.println("deleteOne deleted collections : " + result.getDeletedCount());

        //deleteMany: delete where i < 10
        result = testCol.deleteMany(lt("i", 10));
        System.out.println("deleteMany deleted collections : " + result.getDeletedCount());

        // release resource
        pool.close();
    }

    @Test
    public void query() {

        // Get collection
        MongoClient pool = new MongoClient("localhost", 27017);
        MongoDatabase testdb = pool.getDatabase("testdb");
        MongoCollection<Document> testCol = testdb.getCollection("testCol");

        //prepare: data
        testCol.drop();
        List<Document> documents = new ArrayList<Document>();
        for (int i = 0; i < 101; i++) {
            documents.add(new Document("i", i));
        }
        testCol.insertMany(documents);


        // find first
        Document doc = testCol.find().first();
        System.out.println("Find first: " + doc.toJson());

        //find all
        MongoCursor<Document> cursor = testCol.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                System.out.println(document.toJson());
            }
        } finally {
            cursor.close();
        }

        // filter: to first
        doc = testCol.find(eq("i", 10)).first();
        System.out.println(doc.toJson());

        // filter: to multiple
        final List<Document> docList = new ArrayList<Document>();
        Block<Document> collectBlock = new Block<Document>() {
            public void apply(Document document) {
                docList.add(document);
            }
        };

        testCol.find(and(gt("i", 1), lt("i", 3))).forEach(collectBlock);
        System.out.println(docList);

        //sort: to first
        doc = testCol.find(exists("i")).sort(descending("i")).first();
        System.out.println(doc);

        //aggregates
        //count
        System.out.println(testCol.count());
        // release resource
        pool.close();
    }

}
