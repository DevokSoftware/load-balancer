package org.devok.balance.algorithm;

import org.devok.providers.IProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class LoadBalancerAlgorithm {
    private final HashMap<Integer, IProvider> providers = new HashMap<>();

    protected LoadBalancerAlgorithm(Set<IProvider> providers) {
        int index = 0;
        for (IProvider provider : providers) {
            this.providers.put(index, provider);
            index++;
        }
    }

    public Map<Integer, IProvider> getProviders() {
        return providers;
    }

    public abstract String getName();

    public abstract IProvider getServer();
}
