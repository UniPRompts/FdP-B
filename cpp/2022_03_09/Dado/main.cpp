#include <iostream>
using namespace std;

class Dado{
    private:
        int valore;
        int n_facce;
    public:
        Dado(){
            Dado(0);
        }

        Dado(int facce){
            this->n_facce = facce <= 0 ? 6 : facce;
            reset();
        }

        void reset(){
            this->valore = 0;
        }

        int getLancio() const{
            return this->valore;
        }

        int getFacce() const{
            return this->n_facce;
        }

        void setValore(int valore){
            this->valore = valore;
        }

        int lancia(){
            reset();
            if(this->getFacce() == 0)
                return 0;
            srand(time(0));
            setValore((rand() % getFacce()) + 1);
            return getLancio();
        }

};

ostream& operator<<(ostream& dest, const Dado& d){
    dest << d.getLancio();
    return dest;
}

int main() {
    Dado d1(6);
    Dado d2(4);

    cout << d1.lancia() << endl;
    cout << d2.lancia() << endl << endl;

    cout << d1.lancia() << endl;
    cout << d2.lancia() << endl << endl;

    cout << d1.lancia() << endl;
    cout << d2.lancia() << endl << endl;

    cout << d1.lancia() << endl;
    cout << d2.lancia() << endl << endl;

    return 0;
}
