package org.devok.providers;

public interface IProvider {
    String get();

    boolean isAlive();

    int getMaxRequests();
}
