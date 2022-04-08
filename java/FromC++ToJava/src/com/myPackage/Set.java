package com.myPackage;

import java.util.ArrayList;

public class Set<T> {

    private ArrayList<T> elements;

    //  Costructor vuoto inizializza a 0 elementi
    public Set(){
        elements = new ArrayList<T>();
    }

    // Get Size Set
    public int size(){
        return elements.size();
    }

    // Get String
    public String getString(){
        String result = "{";

        for(int i = 0; i < size(); i++){
            result += elements.get(i);
            if(i != size() - 1)
                result += ", ";
        }

        result += "}";

        return result;
    }

    /**
     * Inserisce un nuovo elemento (se non già presente) al set
     * @param other elemento da aggiungere al set
     */
    public void add(T other){
        if(!contains(other))
            elements.add(other);
    }

    /**
     * Controlla se un elemento è presente nel set
     * @param other elemento da cercare
     * @return true se è contenuto, false altrimenti
     */
    public boolean contains(T other){
        for(int i = 0; i < size(); i++)
            if(elements.get(i).equals(other))
                return true;
        return false;
    }

    /**
     * Unisce due Set
     * @param other
     * @return risultato unione
     */
    public Set<T> union(Set<T> other){
        Set<T> result = new Set<T>();

        for(int i = 0; i < this.size(); i++)
            result.add(this.elements.get(i));
        for(int i = 0; i < other.size(); i++)
            result.add(other.elements.get(i));

        return result;
    }

    /**
     * Interseca due Set
     * @param other
     * @return risultato intersezione
     */
    public Set<T> intersetion(Set<T> other){
        Set<T> result = new Set<T>();

        for(int i = 0; i < this.size(); i++)
            if(other.contains(elements.get(i)))
                result.add(elements.get(i));

        return result;
    }

    /**
     * Verifica se this è subSet di un Set dato
     * @param other
     * @return true se è subset, false altrimenti
     */
    public boolean isSubsetOf(Set<T> other){
        if(this.size() >= other.size())
            return false;

        for(int i = 0; i < this.size(); i++)
            if(!other.contains(elements.get(i)))
                return false;

        return true;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new Set<Integer>();
        s1.add(10);
        s1.add(11);
        s1.add(12);
        s1.add(12);
        System.out.println(s1.getString());

        Set<String> s2 = new Set<String>();
        s2.add("10");
        s2.add("uva");
        s2.add("uva");
        s2.add("gg");
        System.out.println(s2.getString());

        Set<String> s3 = new Set<String>();
        s3.add("x");
        s3.add("uva");
        s3.add("uva");
        System.out.println(s3.getString());
        System.out.println(s3.isSubsetOf(s2));
        System.out.println(s3.intersetion(s2).getString());
        System.out.println(s3.union(s2).getString());
    }
}
