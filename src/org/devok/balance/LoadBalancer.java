package org.devok.balance;

import org.devok.balance.algorithm.LoadBalancerAlgorithm;
import org.devok.providers.IProvider;

import java.util.Set;
import java.util.stream.Collectors;

public class LoadBalancer {
    private int currentNumberOfRequests = 0;

    public String get(LoadBalancerAlgorithm algorithm, Set<IProvider> providers) {
        if (maxRequestReached(providers)) {
            //TODO - implement exception
            return null;
        }
        incrementRequests();
        String result = algorithm.getServer().get();
        decrementRequests();
        return result;
    }

    private boolean maxRequestReached(Set<IProvider> providers) {
        int maxRequestsCount = 0;
        for (IProvider provider : providers) {
            if (provider.isAlive()) {
                maxRequestsCount += provider.getMaxRequests();
            }
        }
        return maxRequestsCount < getRequests();
    }

    private synchronized int getRequests() {
        return currentNumberOfRequests;
    }

    private synchronized void incrementRequests() {
        ++currentNumberOfRequests;
    }

    private synchronized void decrementRequests() {
        --currentNumberOfRequests;
    }
}
