#include <iostream>
#include <cmath>
using namespace std;

class Complex {
    private:
        int real, imm;

    public:
    //  --------------- Getter & Setter
        void setReal(int real){
            this->real = real;
        }

        void setImm(int imm){
            this->imm = imm;
        }

        int getReal(){
            return real;
        }

        int getImm(){
            return imm;
        }

    //  --------------- Costructor
        Complex(){
            setReal(0);
            setImm(0);
        }

        Complex(int real, int imm){
            setReal(real);
            setImm(imm);
        }

    //  --------------- Output & Input
        ostream& stampa(ostream& dest){
            if(getReal() == 0 && getImm() == 0) dest << 0 << endl;
            else if(getReal() == 0){
                if(getImm() > 0)
                    if(getImm() == 1) dest << "i" << endl;
                    else dest << "i" << getImm() << endl;
                else
                    if(getImm() == -1) dest << "- i" << endl;
                    else dest << "- i" << sqrt(getImm() * getImm()) << endl;
            }
            else if(getImm() == 0)
                dest << getReal() << endl;
            else{
                if(getImm() > 0)
                    if(getImm() == 1) dest << getReal() << " + i" << endl;
                    else dest << getReal() << " + i" << getImm() << endl;
                else
                    if(getImm() == -1) dest << getReal() << " - i" << endl;
                    else dest << getReal() << " - i" << sqrt(getImm() * getImm()) << endl;
            }
            return dest;
        }

        istream& leggi(istream& sorg) {
            int real, imm;
            cout << "Inserire parte reale: ";
            sorg >> real;
            cout << "Inserire parte immaginaria: ";
            sorg >> imm;

            setReal(real);
            setImm(imm);

            return sorg;
        }

    //  --------------- Overloading
        Complex operator+(Complex other){
            Complex risultato(getReal() + other.getReal(), getImm() + other.getImm());
            return risultato;
        }

        Complex operator-(Complex other){
            Complex risultato(getReal() - other.getReal(), getImm() - other.getImm());
            return risultato;
        }

        bool operator==(Complex other){
            if(getReal() == other.getReal() && getImm() == other.getImm())
                return true;
            else return false;
        }

        bool operator!=(Complex other){
            if(getReal() == other.getReal() && getImm() == other.getImm())
                return false;
            else return true;
        }
};

ostream& operator<<(ostream& dest, Complex other){
    return other.stampa(dest);
}

istream& operator>>(istream& sorg, Complex& other){
    return other.leggi(sorg);
}


int main() {
    Complex c1(-2, 3);
    Complex c2(3, -1);

    cout << "c1: " << c1;

    cout << "c2: " << c2;

    if(c1 == c2) cout << "I due numeri complessi sono uguali" << endl;
    if(c1 != c2) cout << "I due numeri complessi sono diversi" << endl;

    Complex c3 = c1 + c2;
    cout << "Somma: " << c3;

    Complex c4 = c1 - c2;
    cout << "Sottrazione: " << c4;

    Complex c5;
    cin >> c5;
    cout << "c5: " << c5;

    return 0;
}
