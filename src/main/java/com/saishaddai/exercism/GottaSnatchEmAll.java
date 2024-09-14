package com.saishaddai.exercism;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return cards.stream().collect(Collectors.toUnmodifiableSet());
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if(myCollection.isEmpty() || theirCollection.isEmpty()) return false;
        if(myCollection.containsAll(theirCollection) || theirCollection.containsAll(myCollection)) return false;
        return !theirCollection.equals(myCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        if (collections.isEmpty()) return Set.of();
        if(collections.size() == 1) return collections.get(0);
        Set<String> commons = new HashSet<>(collections.get(0));
        for(int i = 1; i < collections.size(); i++) {
            commons.retainAll(collections.get(i));
        }
        return commons;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> result = new HashSet<>();
        for(Set<String> collection: collections) {
            result.addAll(collection);
        }
        return result;
    }
}

