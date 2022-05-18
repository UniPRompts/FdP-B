package socialNetwork;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Person implements Iterable<Person>{
    private final HashSet<Person> amici;
    private final HashSet<Person> nemici;
    private final String nome;
    private final String cognome;

    public Person(String nome, String cognome){
        this.amici = new HashSet<>();
        this.nemici = new HashSet<>();
        this.nome = nome;
        this.cognome = cognome;
    }


    public void addNemico(Person nemico){
        if(equals(nemico) || amici.contains(nemico))
            throw new RuntimeException();
        nemici.add(nemico);
    }

    public void addAmico(Person amico){
        if(equals(amico) || nemici.contains(amico))
            throw new RuntimeException();
        amici.add(amico);
    }

    @Override
    public String toString(){
        return nome + " " + cognome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return nome.equals(person.nome) &&
                cognome.equals(person.cognome) &&
                nemici.equals(person.nemici) &&
                amici.equals(person.amici);

    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, nemici, amici);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(nemici.iterator(), amici.iterator());
    }

    public static void main(String[] args) {
        Person a = new Person("Mario", "Rossi");
        Person b = new Person("Giuseppe", "Verdi");
        Person c = new Person("Giacomo", "Gialli");
        Person d = new Person("Luca", "Neri");

        a.addAmico(b);
        a.addNemico(c);
        a.addNemico(d);

        for(Person p : a)
            System.out.println(p);

        System.out.println("Fine");
    }
}
