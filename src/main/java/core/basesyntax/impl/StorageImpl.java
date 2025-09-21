package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENTS_IN_STORAGE = 10;
    private static final int INITIAL_SIZE_OF_STORAGE = 0;

    private K[] keys = (K[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private V[] values = (V[]) new Object[MAX_ELEMENTS_IN_STORAGE];
    private int storageSize = INITIAL_SIZE_OF_STORAGE;
    @Override
    public void put(K key, V value) throws RuntimeException {
        for (int i = 0; i < storageSize; i++) {
            if (Objects.equals(key, keys[i])) {
                values[i] = value;
                return;
            }
        }

        if(storageSize == MAX_ELEMENTS_IN_STORAGE) {
            throw new RuntimeException("Storage is full");
        } else {
            keys[storageSize] = key;
            values[storageSize] = value;
            storageSize++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < storageSize; i++) {
            if (Objects.equals(key, keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storageSize;
    }
}
