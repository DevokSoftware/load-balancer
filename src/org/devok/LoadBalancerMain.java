package org.devok;

import org.devok.balance.LoadBalancer;
import org.devok.balance.algorithm.LoadBalancerAlgorithm;
import org.devok.balance.algorithm.RoundRobin;
import org.devok.providers.IProvider;
import org.devok.providers.ServerMap;
import org.devok.providers.ServerProvider;
import org.devok.utils.HeartBeat;

import java.util.Set;

public class LoadBalancerMain {

    public static void main(String[] args) {
        ServerMap serverMap = new ServerMap();
        serverMap.addServer(new ServerProvider());
        serverMap.addServer(new ServerProvider());
        serverMap.addServer(new ServerProvider());
        Set<IProvider> providers = serverMap.getServers();
        startHeartBeatJob(serverMap);
        LoadBalancerAlgorithm algorithm = new RoundRobin(providers);
        //LoadBalancerAlgorithm algorithm = new Random(providers);
        LoadBalancer loadBalancer = new LoadBalancer();
        System.out.println(loadBalancer.get(algorithm, providers));
        System.out.println(loadBalancer.get(algorithm, providers));
        System.out.println(loadBalancer.get(algorithm, providers));
        System.out.println(loadBalancer.get(algorithm, providers));
        System.out.println(loadBalancer.get(algorithm, providers));
        System.out.println(loadBalancer.get(algorithm, providers));
    }

    public static void startHeartBeatJob(ServerMap serverMap) {
        Thread t1 = new Thread(new HeartBeat(serverMap));
        t1.start();
    }
}
