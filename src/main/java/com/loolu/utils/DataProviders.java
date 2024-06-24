package com.loolu.utils;

import com.loolu.models.Account;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> createNewAccountFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/account.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new Account().setFirstname(split[0]).setLastname(split[1]).setEmail(split[2]).setPassword(split[3]).setUsername(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> createNewAccount() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Karlonpo","Kanopot","a.b1@ap.com","Qwerty007!","anton"});
        list.add(new Object[]{"Karö","Kanah","a.n2@ap.com","Qwerty007!","antona"});
        list.add(new Object[]{"Karrt","Kanulao","a.pt3@ap.com","Qwerty007!","antoni"});
        list.add(new Object[]{"Kall","Kanpo","a.pz4@ap.com","Qwerty007!","antonu"});
        return list.iterator();
    }
}
