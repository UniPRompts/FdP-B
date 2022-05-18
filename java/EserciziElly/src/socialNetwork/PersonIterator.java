package socialNetwork;

import java.util.Iterator;

public class PersonIterator implements Iterator<Person> {
    private Iterator<Person> nemiciIt;
    private Iterator<Person> amiciIt;

    public PersonIterator(Iterator<Person> nemiciIt, Iterator<Person> amiciIt){
        this.nemiciIt = nemiciIt;
        this.amiciIt = amiciIt;
    }

    @Override
    public boolean hasNext() {
        if(!amiciIt.hasNext())
            return nemiciIt.hasNext();
        return true;
    }

    @Override
    public Person next() {
        if(amiciIt.hasNext())
            return amiciIt.next();
        return nemiciIt.next();
    }
}
