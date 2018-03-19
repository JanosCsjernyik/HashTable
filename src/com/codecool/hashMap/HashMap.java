package com.codecool.hashMap;

import java.util.LinkedList;

public class HashMap {

    private int bucketSize = 16;
    private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];



    public void add(String key, int value){
        HashMap hashMap = new HashMap();
        int bucketIndex = hashMap.getHash(key);
        LinkedList<KeyValue> list = elements[bucketIndex];

        if(list == null){
            LinkedList<KeyValue> linkedList = new LinkedList<>();
            elements[bucketIndex] = linkedList;
            KeyValue newKeyValue = new KeyValue();

            newKeyValue.setKey(key);
            newKeyValue.setValue(value);

            linkedList.add(newKeyValue);
        } else {
            for(KeyValue keyValue : list){
                if( keyValue.getKey().equals(key)){
                    throw new IllegalArgumentException("Key: " + key + " already exist");
                }
            }
        }
    }


    public int getValue(String key){
        HashMap hashMap = new HashMap();
        int bucketIndex = hashMap.getHash(key);

        LinkedList<KeyValue> list = elements[bucketIndex];

        if(list == null){
            throw new IllegalArgumentException("Key: " + key + ",was not found in the map");
        }

        for(KeyValue keyValue : list){
            if( keyValue.getKey().equals(key)){
                return keyValue.getValue();
            }
        }
        throw new IllegalArgumentException("Key: " + key + ",was not found in the map");
    }


    public void remove(String key){
        HashMap hashMap = new HashMap();
        int bucketIndex = hashMap.getHash(key);
        KeyValue valueToRemove = null;

        LinkedList<KeyValue> list = elements[bucketIndex];

        if(list == null){
            throw new IllegalArgumentException("Key was not found in the map");
        } else {
            for(KeyValue keyValue : list){
                if(keyValue.getKey().equals(key)){
                    valueToRemove = keyValue;
                }
            }
            if(valueToRemove == null){
                throw new IllegalArgumentException("Key was not found in the map");
            }
        }
        list.remove(valueToRemove);
    }

    public void clearAll(){
        for (LinkedList<KeyValue> list : elements){
            if(list != null) {
                list.clear();
            }
        }
    }


    public int getHash(String key){
        return Math.abs(key.hashCode() % bucketSize);
    }

}
