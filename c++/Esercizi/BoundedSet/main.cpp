#include <iostream>
using namespace std;

/*
 * Si realizzi un template di classe BoundedSet, che rappresenta un insieme con capacità limitata.
 * Il costruttore prende come parametro la capacità massima dell'insieme.
 * Si realizzino i seguenti metodi:
- add: aggiunge un elemento all'insieme. Se l'elemento è già presente, l'insieme rimane inalterato.
        Se l'insieme ha raggiunto la sua capacità massima, prima dell'inserimento del nuovo elemento sarà cancellato
        dall'insieme l'elemento che è stato inserito per primo
- size: ritorna la dimensione dell'insieme
- contains: controlla se un elemento è presente nell'insieme
 */
template <class T>
struct node{
    T val;
    node* next;
};

template <class T>
class BoundedSet{
    private:
        T* A;
        int dim, top;

    public:
        BoundedSet(int dim){
            A = new T[dim];
            this->dim = dim;
            this->top = 0;
        }
        ~BoundedSet(){
            delete [] A;
        }
        BoundedSet(BoundedSet<T>& other){
            this->A = new T[other.getDim()];
            for(int i = 0; i < other.size(); i++)
                this->A[i] = other.getValue(i);
            this->dim = other.getDim();
            this->top = other.size();
        }

        T getValue(int i){
            return this->A[i];
        }
        int getDim(){
            return this->dim;
        }
        int size(){
            return top;
        }

        bool contains(const T& valore){
            for(int i = 0; i < top; i++)
                if(A[i] == valore)
                    return true;
            return false;
        }
        void add(const T& valore){
            if(!contains(valore)){
                if(top < dim){
                    A[top] = valore;
                    top++;
                } else {
                    for(int i = 0; i < top; i++)
                        A[i] = A[i + 1];
                    A[top - 1] = valore;
                }
            }
        }
        BoundedSet<T>& operator=(BoundedSet<T>& other){
            if(this == &other)
                return *this;
            else{
                delete [] A;
                this->A = new T[other.getDim()];
                for(int i = 0; i < other.size(); i++)
                    this->A[i] = other.getValue(i);
                this->dim = other.getDim();
                this->top = other.size();
                return *this;
            }
        }

};

template <class T>
ostream& operator<<(ostream& dest, BoundedSet<T> gg){
    for(int i = 0; i < gg.size(); i++)
        dest << gg.getValue(i) << " ";
    dest << endl;
    return dest;
}

int main() {
     BoundedSet<int> test(5);
     test.add(1);
     test.add(2);
     test.add(3);
     test.add(3);
     test.add(4);
     test.add(5);
     test.add(6);

     cout << "size: " << test.size() << endl;
     cout << "dim: " << test.getDim() << endl;
     cout << test << endl;

    BoundedSet<char> test2(5);
    test2.add('x');
    test2.add('a');
    test2.add('a');
    test2.add('a');
    test2.add('a');
    test2.add('a');
    test2.add('a');

    cout << "size: " << test2.size() << endl;
    cout << "dim: " << test2.getDim() << endl;
    cout << test2 << endl;

    BoundedSet<char> test3(test2);
    cout << "size: " << test3.size() << endl;
    cout << "dim: " << test3.getDim() << endl;
    cout << test3;


    BoundedSet<char> test4 = test2;
    test4.add('f');
    cout << test4;

     return 0;
}
