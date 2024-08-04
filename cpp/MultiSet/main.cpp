#include <iostream>
using namespace std;

/*
 * Si realizzi una classe MultiSet<T> che realizza il tipo di dato astratto multi-insieme di elementi di tipo T
 * (informalmente, potete vedere un multi-insieme come un insieme che ammette elementi ripetuti).
    La classe deve fornire i seguenti metodi public:
        - add(x): aggiunge un elemento x al multi-insieme
        - contains(x): verifica se x appartiene al multi-insieme
        - S1 + S2, con S1 e S2 di tipo MultiSet<T>: restituisce come suo risultato il nuovo multi-insieme ottenuto dall'unione di S1 e S2
        - remove(x): rimuove dal multi-insieme tutti gli elementi uguali a x. Se x non è presente, il metodo deve sollevare un'eccezione
        - multiplicity(x): ritorna il numero di occorrenze dell'elemento x nel multi-insieme
 */

template <class T>
class MultiSet{
private:
    T *A;
    int dim, top;

public:
    MultiSet(){
        this->A = new T[5];
        this->dim = 5;
        this->top = 0;
    }

    ~MultiSet(){
        delete[] A;
    }

    MultiSet(const MultiSet<T> &other){
        this->dim = other.getDim();
        this->top = other.size();
        this->A = new T[this->dim];

        for (int i = 0; i < this->top; i++)
            this->A[i] = other.A[i];
    }

    int getDim() const{
        return this->dim;
    }

    void output(){
        for (int i = 0; i < this->top; i++)
            cout << this->A[i] << " ";
        cout << endl;
    }

    int size() const{
        return this->top;
    }

    T getValue(int index) const{
        return A[index];
    }

    void upgrade(){
        T *temp = new T[size() + 5];

        for (int i = 0; i < this->top; i++)
            temp[i] = this->A[i];

        delete[] A;
        A = temp;
        this->dim += 5;
    }

    void add(const T &value){
        if (top == dim)
            upgrade();

        this->A[this->top] = value;
        this->top++;
    }

    bool contains(const T &value){
        for (int i = 0; i < this->top; i++)
            if (this->A[i] == value)
                return true;
        return false;
    }
    int multiplicity(const T &value){
        int c = 0;
        for (int i = 0; i < size(); i++)
        {
            if (this->A[i] == value)
                c++;
        }
        return c;
    }
    void remove(const T &value){
        if (contains(value))
        {
            T *temp = new T[this->dim];
            int c = 0;

            for (int i = 0; i < this->size(); i++)
            {
                if (this->A[i] != value)
                {
                    temp[c] = this->A[i];
                    c++;
                }
            }

            delete[] A;

            this->A = temp;

            this->top = c;
        }
        else
            throw string("Elemento non rimosso perche' non presente");
    }

    MultiSet<T> &operator=(const MultiSet<T> &other){
        delete[] this->A;
        this->dim = other.getDim();
        this->top = other.size();

        this->A = new T[this->dim];

        for (int i = 0; i < other.size(); i++)
            this->A[i] = other.A[i];

        return *this;
    }
    MultiSet<T> operator+(const MultiSet<T> &other){
        MultiSet<T> new_multiset;

        for (int i = 0; i < this->top; i++)
            new_multiset.add(this->A[i]);
        for (int i = 0; i < other.size(); i++)
            new_multiset.add(other.getValue(i));

        return new_multiset;
    }
};

template <class T>
ostream &operator<<(ostream &dest, MultiSet<T> other){
    other.output();
    return dest;
}

int main(){
    MultiSet<int> m1;
    m1.add(1);
    m1.add(2);
    m1.add(3);
    m1.add(4);
    m1.add(5);
    m1.add(6);
    cout << "dim: " << m1.getDim() << endl;
    cout << "size: " << m1.size() << endl;
    cout << "m1: " << m1 << endl;

    MultiSet<int> m2;
    m2.add(1);
    m2.add(2);
    cout << "dim: " << m2.getDim() << endl;
    cout << "size: " << m2.size() << endl;
    cout << "m2: " << m2 << endl;

    MultiSet<int> m3;
    m3 = m1 + m2;
    cout << "dim: " << m3.getDim() << endl;
    cout << "size: " << m3.size() << endl;
    cout << "m3: " << m3 << endl;

    if (m3.contains(1))
        cout << "m3 contiene 1" << endl;
    if (!m3.contains(9))
        cout << "m3 non conteine 9" << endl;

    cout << "1 è contenuto " << m3.multiplicity(1) << " volte\n"
         << endl;

    try
    {
        m3.remove(2);
    }
    catch (string e)
    {
        cout << e << endl;
    }

    cout << "dim: " << m3.getDim() << endl;
    cout << "size: " << m3.size() << endl;
    cout << "m3: " << m3 << endl;

    return 0;
}
