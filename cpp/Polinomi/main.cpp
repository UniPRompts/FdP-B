#include <iostream>
using namespace std;
/*
Si realizzi una classe Polinomio, che rappresenta il tipo di dato astratto polinomio: a0 + a1*x + a2*x^2 + ... +an*x^n.
La classe deve essere dotata di:
- un costruttore che prende come parametro un array contenente i coefficienti a0, a1, a2, ..., an del polinomio e la sua lunghezza
- un metodo getDegree che ritorna il grado del polinomio
- un metodo times che prende come parametro un polinomio other e ritorna un polinomio che rappresenta il prodotto fra this e other
- un metodo stampa che stampa a video il polinomio
 */

class Polinomio{
    private:
        int* A;
        int dim;
    public:
        Polinomio(int vet[], int dim){
            A = new int[dim];
            for(int i = 0; i < dim; i++)
                A[i] = vet[i];
            this->dim = dim;
        }

        void output(){
            for(int i = getDegree(); i >= 0; i--){
                if(A[i] != 0){
                    if(i == 0)
                        cout << A[i];
                    else if(i == 1)
                        cout << A[i] << "x + ";
                    else
                        cout << A[i] << "x^" << i << " + ";
                }

            }
        }

        int getDegree(){
            return (this->dim - 1);
        }

        Polinomio times(const Polinomio& other){
            int new_dim = this->dim + other.dim;
            int vet[new_dim];

            for(int i = 0; i < new_dim; i++)
                vet[i] = 0;

            for(int i = 0; i < this->dim; i++)
                for(int j = 0; j < other.dim; j++)
                    vet[i + j] += this->A[i] * other.A[j];

            Polinomio prodotto(vet, new_dim);
            return prodotto;
        }

        Polinomio operator*(const Polinomio& other){
            return this->times(other);
        }



};

ostream& operator<<(ostream& dest, Polinomio p){
    p.output();
    return dest;
}


int main() {
    int v1[] = {1, 2 ,3, 5};
    Polinomio p1(v1, 4);
    cout << p1<< "\n\tGrado: " << p1.getDegree() << endl;

    int v2[] = {3, 5, 2, 7, 1};
    Polinomio p2(v2, 5);
    cout << p2 << "\n\tGrado: " << p2.getDegree() << endl;

    Polinomio p3 = p1 * p2;
    cout << "Prodotto tra p1 e p2:\n\t" << p3 << "\n\t\tGrado: " << p3.getDegree() << endl;


    return 0;
}
