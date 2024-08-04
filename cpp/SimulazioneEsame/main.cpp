#include <iostream>
using namespace std;

template <class T>
class Inventory{
    private:
        T* A;
        int dim, top;

        void upgradeDim(int amount){
            dim += amount;
            T* B = A;
            A = new T[dim];
            for(int i = 0; i < dim; i++){
                A[i] = B[i];
            }
            delete[] B;
        }

    public:
        Inventory(){
            this->A = new T[5];
            this->dim = 5;
            this->top = 0;
        }

        // Inserisce un nuovo elemento
        void add(const T& other){
            if(top == dim)
                upgradeDim(5);

            A[top] = other;
            top++;
        }

        // Output
        void output(){
            for(int i = 0; i < this->top; i++)
                cout << this->A[i] << " ";
            cout << endl;
        }

        int count(const T& other){
            int c = 0;
            for(int i = 0; i < this->top; i++)
                if(A[i] == other)
                    c++;
            return c;
        }

        T getMostCommon(){
            T comm;
            int max;

            if(top > 0){
                max = count(A[0]);
                comm = A[0];
                for(int i = 1; i < this->top; i++)
                    if(count(A[i]) > max)
                        comm = A[i];
            } else
                throw string("Inventario vuoto!!");

            return comm;
        }

        int getDim(){
            return dim;
        }
};

int main() {
    Inventory<int> inv0;
    inv0.add(1);
    inv0.add(2);
    inv0.add(1);
    inv0.add(3);
    inv0.add(3);
    cout << inv0.getDim() << endl;
    inv0.add(3);
    cout << inv0.getDim() << endl;

//    Inventory<string> inv1;
//    inv1.add("ciao");
//    inv1.add("a tutti");
//    inv1.add("ciao");

    inv0.output();
//    inv1.output();

//    cout << inv0.count(7) << endl; //output: 0
//    cout << inv0.count(1) << endl; //output: 2
//    cout << inv1.count("ciao") << endl; //output: 2
//    cout << inv0.getMostCommon() << endl; // output: 3
//    cout << inv1.getMostCommon() << endl; // output: "ciao"

//    Inventory<string> inv2;
//
//    try{
//        cout << inv2.getMostCommon() << endl;
//    } catch (string err){
//        cout << "Error: " << err << endl;
//    }

    return 0;
}
