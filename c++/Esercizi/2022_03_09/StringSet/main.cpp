#include <iostream>
using namespace std;

#define MAX_SIZE 100    //statico

class StringSet{
    private:
        //string str[MAX_SIZE];     //statico
        string* str;
        int dim;

    public:
        StringSet(){
            this->dim = 0;
            this->str = new string[0];  //dinamico
        }
        StringSet(const string s[], int n){
            this->dim = 0;
            this->str = new string[0];  //dinamico
            for(int i = 0; i < n; i++)
                add(s[i]);
        }
        StringSet(const StringSet& other){
            str = new string[other.dim];

            for(int i = 0; i < other.dim; i++)
                str[i] = other.str[i];

            this->dim = other.dim;
        }
        ~StringSet(){
            delete [] str;
        }

        string getElem(int n) const{
            if(n < 0 || n >= this->size()){
                cout << "Out of bound\n";
                return "null";
            }
            return this->str[n];
        }
        int size() const{
            return dim;
        }
        bool contains(string elem){
            for(int i = 0; i < dim; i++)
                if(elem == str[i])
                    return true;
            return false;
        }
        void add(string elem){
            if(!contains(elem)){
                /*
                 *  statico
                 *
                if(dim == MAX_SIZE)
                    cout << "Spazio massimo reggiunto, elemento non inserito\n";
                else{
                    str[dim] = elem;
                    dim++;
                }
                 */

                string* new_str = new string[size() + 1];
                for(int i = 0; i < size(); i++)
                    new_str[i] = this->getElem(i);

                new_str[size()] = elem;
                this->dim++;

                delete [] str;
                str = new_str;
            }
        }

        bool operator<(StringSet& other) const{
            if(size() >= other.size())
                return false;
            for(int i = 0; i < this->dim; i++)
                if(!other.contains(str[i]))
                    return false;
            return true;
        }
        StringSet operator+(const StringSet& other) const{
            /*
             *  statico
             *
            if(this->size() + other.size() > MAX_SIZE)
                cout << "La somma supera il limite massimo\n";
            else{
             */
                StringSet result(str, size());

                for(int i = 0; i < other.size(); i++)
                    result.add(other.getElem(i));

                return result;
            //}
        }
        const StringSet& operator=(const StringSet& other){
            if(this != &other){
                delete [] str;
                str = new string[other.dim];

                for(int i = 0; i < other.dim; i++)
                    str[i] = other.str[i];

                this->dim = other.dim;
            }
            return *this;
        }
};

ostream& operator<<(ostream& dest, const StringSet& s){
    if(s.size() == 0){
        dest << "{}\n";
        return dest;
    }

    dest << "{";

    for(int i = 0; i < s.size(); i++)
        if(i + 1 < s.size())
            dest << s.getElem(i) << ", ";
        else
            dest << s.getElem(i);


    dest << "}";

    return dest;

}

int main() {

    StringSet s1;
    cout << "S1: " << s1;
    cout << "Cardinalità di s1: " << s1.size() << endl << endl;

    string frase[] = {"il", "gatto", "e", "il", "topo"};
    StringSet s2(frase, 5);
    cout << "S2: " << s2 << endl;
    cout << "Cardinalità di s2: " << s2.size() << endl << endl;

    s1.add("mare");
    s1.add("sole");
    s1.add("luna");

    cout << "Unione tra s1 e s2: " << s2 + s1 << endl << endl;

    if(s1.contains("luna"))
        cout << s1 << " s1 contiene la parola luna\n";
    else
        cout << s1 << " s1 non contiene la parola luna\n";

    return 0;
}
