package org.devok.providers;


import java.util.HashSet;
import java.util.Set;

public class ServerMap {
    private static final int LIMIT = 10;
    Set<IProvider> serverList = new HashSet<>();

    public void addServer(IProvider provider) {
        //TODO - implement an exception for when limit is reached
        if (serverList.size() != LIMIT) {
            serverList.add(provider);
        }
    }

    public void removeServer(IProvider provider) {
        serverList.remove(provider);
    }

    public Set<IProvider> getServers() {
        return serverList;
    }
}
