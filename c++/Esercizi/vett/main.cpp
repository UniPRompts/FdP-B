#include <iostream>
using namespace std;


template <class T>
class vett{
    private:
 	    T *A;
 	    int dim;
 	 public:
        vett() {
                A = NULL;
                dim = 0;
	    }

        vett(int n) {
                A = new T[n];
                dim = n;
	    }

        vett(int n, T v) {
            A = new T[n];
            for(int i=0;i<n;++i)
               A[i]=v;
            dim = n;
        }

        vett(const vett<T>& V) {   //costruttore di copia
            A = new T[V.dim];
            dim = V.dim;
            for(int i=0;i<dim;++i)
               A[i]=V.A[i];
        };  //costruttore di copia

        ~vett() {
           delete[] A;
        }

        vett<T>& operator=(const vett<T>& V) {
          int d;
          if (this == &V)
            return *this;
          if (dim <= V.dim)
            d = dim;
           else
            d = V.dim;
           for (int i=0;i<d;++i)
               A[i]=V.A[i];
           return *this;
        }

        T& operator[](int i) {
           if (i<0 || i > dim)
            throw "Out of range";
           return A[i];
        }

        int operator==(const vett<T>& V) {
           if (dim != V.dim)
            return 0;
           for (int i=0;i<dim;++i)
              if (A[i] != V.A[i])
                return 0;
           return 1;
        }

        void stampa(ostream& dest) const {
           for(int i=0;i<dim;++i)
                dest << A[i];
           return;
        }

        void leggi(istream& sorg) {
            for(int i=0;i<dim;++i)
                sorg >> A[i];
           return;
       }
};

template <class T>
ostream& operator<<(ostream& sout, const vett<T>& r) {
    r.stampa(sout);
    return sout;
}

template <class T>
istream& operator>>(istream& sin, vett<T>& r) {
    r.leggi(sin);
    return sin;
}

int main() {
       vett<int> V1(5,1);
       cout << V1 << endl << endl;

       vett<char> V2(10,'*');
       V2[0] = 'a';
       V2[1] = 'b';
       cout << V2 << endl << endl;

       vett<int> W1(5);
       W1 = V1;
       cout << W1 << endl << endl;
       return 0;
}

