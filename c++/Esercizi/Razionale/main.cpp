#include <iostream>
using namespace std;

class Razionale {
	private:
		int n;
		int d;
	public:
        ~Razionale(){
            cout << "\nSto morendo... ";
            this->stampa();
        }

		Razionale() {
			n = 1;
			d = 1;
		}

		Razionale(int n1, int d1) {
			n = n1;
			if (d1 == 0) {
				cout << "Errore: denominatore uguale a zero" << endl;
				d = 1;
			} else
				d = d1;

            semplifica();
		}

		void leggi() {
			int num, den;
			char sep;
			cin >> num >> sep >> den;
			n = num;

			if (den == 0) {
				cout << "Errore: denominatore uguale a zero" << endl;
				d = 1;
			} else
				d = den;
			return;
		}

		void stampa() {
			cout << n << "/" << d;
		}

		Razionale operator+(Razionale other) {
			return somma(other);
		}

		Razionale operator+(int x) {
			Razionale other(x, 1);
			return *this + other;
		}

        Razionale operator+(float x){
            Razionale other(x * 10000000, 10000000);
            other.semplifica();
            return *this + other;
        }

        bool operator==(Razionale other){
            if(this->d == other.d && this->n == other.n)
                return true;
            else return false;
        }

        bool operator!=(Razionale other){
            if(this->d == other.d && this->n == other.n)
                return false;
            else return true;
        }

        void semplifica(){
            int mcd = n;
            while(n % mcd != 0 || d % mcd != 0)
                mcd--;
            n /= mcd;
            d /= mcd;
        }

		Razionale somma(Razionale other) {
			Razionale risultato;
			risultato.d = d * other.d;
			risultato.n = n * other.d + d * other.n;
            risultato.semplifica();
			return risultato;
		}



};

Razionale operator+(int x, Razionale r) {
    return r.operator+(x);
}

Razionale operator+(float x, Razionale r) {
    return r.operator+(x);
}

int main() {
	Razionale r1(95,5);
    Razionale r2(3,4);

    Razionale r3 = r1.operator+(r2); // r1.operator+(r2)

    r1.stampa();
    cout << " + ";
	r2.stampa();
    cout << " = ";
    r3.stampa();

    r1.semplifica();
    r2.semplifica();
    r3.semplifica();

    cout << endl;

    r1.stampa();
    cout << " + ";
    r2.stampa();
    cout << " = ";
    r3.stampa();

    if(r1 == r2) cout << "\nr1 e r2 sono uguali\n";
    if(r1 != r2) cout << "\nr1 e r2 sono diversi\n";

    Razionale r4(2, 5);
    float num = 0.2;
    Razionale r5 = r4 + num;

    cout << endl;

    r4.stampa();
    cout << " + ";
    cout << num;
    cout << " = ";
    r5.stampa();

	return 0;
}