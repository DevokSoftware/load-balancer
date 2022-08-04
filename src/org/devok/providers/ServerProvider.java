package org.devok.providers;

import org.devok.utils.RandomImpl;

public class ServerProvider implements IProvider {
    private int id;
    private boolean active;
    private static final int maxRequests = 400;

    public ServerProvider() {
        id = RandomImpl.getRandom().nextInt();
        active = true;
    }

    public String get() {
        return "Using Server Id: " + getId();
    }

    @Override
    public boolean isAlive() {
        return active;
    }

    private int getId() {
        return id;
    }

    public int getMaxRequests() {
        return maxRequests;
    }
}
