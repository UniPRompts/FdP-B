/*
 *  Realizza la classe Q (Quadrato) dotata degli attributi lato, posx e posy;
 *  questi ultimi due sono le coordinate cartesiane dell'angolo superiore sinistro del quadrato.
    L'oggetto di classe Q  può essere istanziata solo tramite costruttore.
    Realizza poi la classe I (insieme) che riceve in ingresso due quadrati e restituisce in uscita l'esito di
    una loro eventuale intersezione (sovrapposizione);
    in tal caso l'oggetto di classe I deve restituire l'area dell' intersezione e dell'unione dei due quadrati.
    (esempio di scambio di dati fra classi non derivate fra loro).
    http://www.edutecnica.it/informatica/opx/9.htm
 */

#include <iostream>
using namespace std;

class Punto{
    private:
        int x, y;
    public:
        Punto(int x, int y){
            this->x = x;
            this->y = y;
        }

    Punto() {}

    int getX(){
            return x;
        }

        int getY(){
            return y;
        }
};

class Quadrato{
    private:
        int lato;
        Punto topL, topR, botL, botR;
    public:
        // ------------------------------ Setter & Getter
        void setLato(const int& lato){
            this->lato = lato;
        }

        int getLato(){
            return this->lato;
        }

        void getTopL(){
            cout << "\ttopL: (" << this->topL.getX() << ", " << this->topL.getY() << ")\n";
        }

        void getTopR(){
            cout << "\ttopR: (" << this->topR.getX() << ", " << this->topR.getY() << ")\n";
        }

        void getBotL(){
            cout << "\tbotL: (" << this->botL.getX() << ", " << this->botL.getY() << ")\n";
        }

        void getBotR(){
            cout << "\tbotR: (" << this->botR.getX() << ", " << this->botR.getY() << ")\n";
        }

        void getCordinate(){
            getTopL();
            getTopR();
            getBotL();
            getBotR();
        }

        int getArea(){
            return getLato() * getLato();
        }

        // ------------------------------ Costructor
        Quadrato(const int &lato, const int &posx, const int &posy){
            this->topL = Punto(posx, posy);
            this->topR = Punto(posx + lato, posy);
            this->botL = Punto(posx, posy - lato);
            this->botR = Punto(posx + lato, posy - lato);
            setLato(lato);
        }


};

class Insieme{
    private:
        Quadrato *q1, *q2;
    public:
        bool check(){

        }

        Insieme(Quadrato* q1, Quadrato* q2){
            this->q1 = q1;
            this->q2 = q2;
        }

};

// ------------------------------ Overloading
ostream& operator<<(ostream& dest, Quadrato other){
    dest << "Lato: " << other.getLato() << " cm\n";
    dest << "Coordinate:\n";
    other.getCordinate();

    dest << "Area: " << other.getArea() << " cm^2\n";
    return dest;
}

int main() {
    Quadrato q1(3, 2, 5);
    Quadrato q2(2, 1, 4);

    cout << "q1: " << q1 << endl;
    cout << "q2: " << q2 << endl;

    Insieme i1(&q1, &q2);
    return 0;
}
