package org.devok.utils;

import org.devok.providers.IProvider;
import org.devok.providers.ServerMap;

import java.util.HashMap;
import java.util.Map;

public class HeartBeat implements Runnable {
    ServerMap serverMap;
    Map<IProvider, Integer> removedServers = new HashMap<>();
    private static final int THREAD_SLEEP = 2000;


    public HeartBeat(ServerMap serverMap) {
        this.serverMap = serverMap;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (IProvider provider : serverMap.getServers()) {
                    if (!provider.isAlive()) {
                        serverMap.removeServer(provider);
                        removedServers.put(provider, 0);
                    }
                }

                for (Map.Entry<IProvider, Integer> server : removedServers.entrySet()) {
                    if (server.getKey().isAlive()) {
                        if (server.getValue() == 1) {
                            serverMap.addServer(server.getKey());
                            removedServers.remove(server.getKey());
                        } else {
                            removedServers.put(server.getKey(), server.getValue() + 1);
                        }
                    }
                }
                Thread.sleep(THREAD_SLEEP);
            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }
}
