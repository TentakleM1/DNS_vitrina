package ru.dns.vitrina.server.storage;

import java.util.Optional;

public interface Repository {
    Optional<?> findById(long id);
}
