#include <iostream>
using namespace std;

//Si realizzi la classe Interval, che rappresenta intervalli finiti (chiusi) di numeri interi (e.g., [0, 1], [5, 9], [0, 100]).
// La classe deve mettere a disposizione i seguenti metodi:
//- contains(x): ritorna true se l'intervallo contiene il valore x, false altrimenti
//- join(i): ritorna l'unione di due intervalli (e.g., [1,2].join([5, 9]) = [1, 9])
//- operator+(i): ritorna la somma di due intervalli (e.g., [1,2] + [3, 7] = [4, 9])
//
//Link aritmetica degli intervalli: https://en.wikipedia.org/wiki/Interval_arithmetic


class Interval{
    private:
        int mi, ma;

    public:
        int getMin(){
            return mi;
        }
        int getMax(){
            return ma;
        }

        Interval(const int &mi, const int &ma) {
            this->mi = mi;
            this->ma = ma;
        }

        bool contains(const int& val) const{
            if(val >= this->mi && val <= this->ma)
                return true;
            return false;
        }
        void join(const Interval& other){
            Interval i3(min(this->mi, other.mi), max(this->ma, other.ma));
            *this = i3;
        }

        Interval operator+(const Interval& other) const{
            Interval i3(this->mi + other.mi, this->ma + other.ma);
            return i3;
        }
};

ostream& operator<<(ostream& dest, Interval i){
    dest << "[" << i.getMin() << "," << i.getMax() << "]" << endl;
    return dest;
}

int main() {
    Interval i1(0,10);
    cout << "i1: " << i1;
    Interval i2(4,12);
    cout << "i2: " << i2;

    if(i1.contains(3))
        cout << "i1 contiene 3\n";
    if(i1.contains(19))
        cout << "i1 contiene 19\n";

    i1.join(i2);
    cout << "i1: " << i1;

    i1 = i1 + i2;
    cout << "i1: " << i1;

    return 0;
}
