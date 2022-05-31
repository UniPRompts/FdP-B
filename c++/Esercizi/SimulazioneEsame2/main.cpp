#include <iostream>
using namespace std;

template <class T>
class Inventory{
    private:
        T* A;
        int dim;
        int top;

        /**
         * Aumenta la dimensione dell'array se viene sforata
         */
        void aumentaDim(){
            T* tmp = A;
            A = new T[dim + 5];

            for(int i = 0; i < top; i++)
                A[i] = tmp[i];

            this->dim += 5;

            delete [] tmp;
        }
    public:
        /**
         * Costruttore
         */
        Inventory(){
            A = new T[5];
            dim = 5;
            top = 0;
        }

        // getter
        int getSize(){
            return this->top;
        }
        T getValue(int i){
            return A[i];
        }
        bool isEmpty(){
            return getSize() == 0;
        }

        /**
         * Aggiunge un elemento di tipo T all’inventario.
         * @param value
         */
        void add(T value){
            if(top == dim)
                aumentaDim();
            A[top] = value;
            top++;
        }
        /**
         * Prende come argomento un elemento di tipo T e restituisce il numero di occorrenza dell’elemento passato come argomento.
         * @param value
         * @return
         */
        int count(T value){
            int c = 0;

            for(int i = 0; i < top; i++)
                if(A[i] == value)
                    c++;

            return c;
        }
        /**
         * Restituisce l’elemento che occorre piu` spesso nell’inventario.
         */
         T getMostCommon(){
            if(!isEmpty()){
                T max = A[0];
                int cmax = count(A[0]);

                for(int i = 1; i < getSize(); i++)
                    if(count(A[i]) > cmax)
                        max = A[i];
                return max;
            }
            else
                throw string("Inventario vuoto! - Impossibile ottenere l'elemento che occorre più spesso.");
         }

};

template <class T>
ostream& operator<<(ostream& dest, Inventory<T> obj){
    for(int i = 0; i < obj.getSize(); i++)
        dest << obj.getValue(i) << " ";
    dest << endl;
    return dest;
}

int main() {
    Inventory<int> inv0;
    inv0.add(1);
    inv0.add(2);
    inv0.add(3);
    inv0.add(4);
    inv0.add(4);
    cout << inv0;

    Inventory<string> inv1;
    inv1.add("ciao");
    inv1.add("brutto");
    inv1.add("topo");
    inv1.add("no");
    cout << inv1;

    Inventory<double> inv2;

    try{
        cout << inv2.getMostCommon() << endl;
    } catch(string e){
        cout << e;
    }
    return 0;
}
