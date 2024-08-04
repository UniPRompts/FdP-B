#include <iostream>

using namespace std;

class poligono{

    protected:
        int numeroLati;
        float* lati;
    
    public:

        poligono(int numeroLati){
            this->numeroLati = numeroLati;
            lati = new float[numeroLati];
            for(int i = 0; i < numeroLati; i++)
                lati[i] = 0;
        }
        ~poligono(){
            delete[] lati;
        }

        void operator=(const poligono& other){
            this->numeroLati = other.numeroLati;
            if(this->lati != NULL)
                delete[] this->lati;
            
            this->lati = new float[numeroLati];
            for(int i = 0; i < numeroLati; i++)
                this->lati[i] = other.lati[i];
        }

        void lunghezzaLati(istream& in, ostream& out){
            for (int i = 0; i < numeroLati; i++){
                out<<"Inserisci la lunghezza del lato "<< i+1 <<": ";
                in>>lati[i];
                out<<"\n";
            }
            
        }
        
        float perimetro() const{
            float tmp = 0;
            for(int i = 0; i < numeroLati; i++)
                tmp += lati[i];

            return tmp;
        }
    
};

class triangolo : public poligono{

    private:
        float altezza;

    public:
        triangolo(float altezza):poligono(3){
            this->altezza = altezza;
        }
        ~triangolo(){
            delete[] lati;
        }
        void operator=(const triangolo& other){
            poligono::operator=(other);
            this->altezza = other.altezza;
        }

        void lunghezzaLati(istream& in, ostream& out){
            poligono::lunghezzaLati(in, out);
        }

        float area(){
            return lati[0] * altezza /2;
        }

};

class rettangolo : public poligono{

    public:
        rettangolo():poligono(4){

        }
        ~rettangolo(){
            delete[] lati;
        }
        void operator=(const rettangolo& other){
            poligono::operator=(other);
        }

        void lunghezzaLati(istream& in, ostream& out){
            poligono::lunghezzaLati(in, out);
        }

        float area(){
            return lati[0] * lati[1];
        }

};

class quadrato : public rettangolo{

    public:
        quadrato():rettangolo(){

        }
        
        ~quadrato(){
            delete[] lati;
        }
        void operator=(const quadrato& other){
            rettangolo::operator=(other);
        }

        void lunghezzaLati(istream& in, ostream& out){
            rettangolo::lunghezzaLati(in, out);
        }

//        float area(){
//            return lati[0] * lati[1];
//        }

};

int main(){

    poligono p(4);
    p.lunghezzaLati(cin, cout);
	cout<<p.perimetro();
	
	cout<<"\n...................\n";
	quadrato q;
	q.lunghezzaLati(cin, cout);
	cout<<q.area()<<" "<<q.perimetro();
	
	cout<<"\n...................\n";
	
	rettangolo r;
	r.lunghezzaLati(cin, cout);
	cout<<r.area()<<" "<<r.perimetro();

    return 0;
}
