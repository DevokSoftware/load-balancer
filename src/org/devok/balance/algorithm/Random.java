package org.devok.balance.algorithm;

import org.devok.utils.RandomImpl;
import org.devok.providers.IProvider;

import java.util.Set;

public class Random extends LoadBalancerAlgorithm{
    private static final String ALGORITHM_NAME = "Random";

    public Random(Set<IProvider> providers) {
        super(providers);
    }
    @Override
    public String getName() {
        return ALGORITHM_NAME;
    }

    @Override
    public IProvider getServer() {
        int randomPos = RandomImpl.getRandom().nextInt(getProviders().size());
        return getProviders().get(randomPos);
    }
}
