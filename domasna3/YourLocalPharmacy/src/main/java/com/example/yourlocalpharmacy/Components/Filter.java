package com.example.yourlocalpharmacy.Components;

public interface Filter<T> {
    T Execute(T input);
}
