package com.payment.database;

import com.payment.exception.ClientAlreadyExistsException;
import com.payment.exception.ClientNotExistsException;
import com.payment.model.Client;

import java.util.HashMap;
import java.util.HashSet;

public class ClientManager {

    private HashMap<String, Client> clientsMap;

    public ClientManager() {
        this.clientsMap = new HashMap<>();
    }

    public Client getClient(String name){
        if(!this.clientsMap.containsKey(name)){
            throw new ClientNotExistsException();
        }

        return this.clientsMap.get(name);
    }

    public boolean addClient(String name){
        if(this.clientsMap.containsKey(name)){
            throw new ClientAlreadyExistsException();
        }

        clientsMap.put(name, new Client(name));
        return true;
    }

    public boolean removeClient(String name){
        if(!this.clientsMap.containsKey(name)){
            throw new ClientNotExistsException();
        }

        clientsMap.remove(name);
        return true;
    }

    public boolean hasClient(String name){
        return this.clientsMap.containsKey(name);
    }
}
