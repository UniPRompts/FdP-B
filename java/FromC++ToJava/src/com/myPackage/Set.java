// NON FUNZIONANTE!!

package com.myPackage;

import java.util.ArrayList;
import java.util.List;

public class Set<T> {

    private ArrayList<T> elements;

    //  Costructor vuoto inizializza a 0 elementi
    public Set(){
        //elements = new T[1];
        elements = new ArrayList<>(7);
    }

    // Get Size StringSet
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
        if(!contains(other)){
            ArrayList<T> new_s = new ArrayList<>(size() + 1);

            for(int i = 0; i < size(); i++)
                new_s.set(i, elements.get(i));

            new_s.set(this.size(), other);

            this.elements = new_s;
        }
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
     * Unisce due StringSet
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
     * Interseca due StringSet
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
     * Verifica se this è subSet di un StringSet dato
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
        Set<Integer> test = new Set<Integer>();
        System.out.println(test.size());
        test.add(10);
        System.out.println(test.size());
        test.add(11);
        test.add(12);
        System.out.println(test.getString());
    }
}
