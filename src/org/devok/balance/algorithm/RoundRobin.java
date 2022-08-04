package org.devok.balance.algorithm;

import org.devok.providers.IProvider;

import java.util.Set;

public class RoundRobin extends LoadBalancerAlgorithm {
    private Integer position = 0;

    private static final String ALGORITHM_NAME = "Round Robin";

    public RoundRobin(Set<IProvider> providers) {
        super(providers);
    }

    public String getName() {
        return ALGORITHM_NAME;
    }

    public IProvider getServer() {
        IProvider server;

        int currentPosition = getPosition();
        if (currentPosition == getProviders().size()) {
            currentPosition = 0;
            resetPosition();
        }
        server = getProviders().get(currentPosition);
        incrementPosition();

        return server;
    }

    private synchronized void resetPosition() {
        position = 0;
    }

    private synchronized void incrementPosition() {
        ++position;
    }

    private synchronized int getPosition() {
        return position;
    }
}
