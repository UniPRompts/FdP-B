#include <iostream>
using namespace std;

class Persona{
protected:
    string nome;
    string cognome;
    string cf;
public:
    Persona() {
        nome = "xxx";
        cognome = "xxx";
        cf = "xxx";
    }

    Persona(string n, string c, string cf) {
        this->nome = n;
        this->cognome = c;
        this->cf = cf;
    }

    void stampa(ostream& dest) {
        dest << nome << ' ' << cognome << endl;
        dest << "Codice discale: " << cf << endl;
    }
};