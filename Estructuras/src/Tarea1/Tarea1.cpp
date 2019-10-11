#include <iostream>
#include <limits>
using namespace std;

class FueraRango{
    bool                    bmin, bmax;
    char                    cmin, cmax;
    short                   smin, smax;
    int                     imin, imax;
    long int                lmin, lmax;
    long long int           llmin, llmax;
    float                   fmin, fmax;
    double                  dmin, dmax;
    long double             ldmin, ldmax;

    public:
        void meta(){
            cout << "Escriba o modele un algoritmo que le permita\n";
            cout << "codificar un programa para evidenciar\n";
            cout << "lo que ocurre cuando una variable de cualquier\n";
            cout << "tipo primitivo de datos pretende\n";
            cout << "obtener un valor fuera del rango válido\n";
        }

        int datos(){
            int offset;
            cout << "Deme un número para incrementar y decrementar: ";
            cin >> offset;
            return offset;
        }

        void calculos(int offset){
            bmin = numeric_limits<bool>::lowest() - offset;
            bmax = numeric_limits<bool>::max() + offset;
            cmin = numeric_limits<char>::lowest() - offset;
            cmax = numeric_limits<char>::max() + offset;
            smin = numeric_limits<short>::lowest() - offset;
            smax = numeric_limits<short>::max() + offset;
            imin = numeric_limits<int>::lowest() - offset;
            imax = numeric_limits<int>::max() + offset;
            lmin = numeric_limits<long int>::lowest() - offset;
            lmax = numeric_limits<long int>::max() + offset;
            llmin = numeric_limits<long long int>::lowest() - offset;
            llmax = numeric_limits<long long int>::max() + offset;
            fmin = numeric_limits<float>::lowest() - offset;
            fmax = numeric_limits<float>::max() + offset;
            dmin = numeric_limits<double>::lowest() - offset;
            dmax = numeric_limits<double>::max() + offset;
            ldmin = numeric_limits<long double>::lowest() - offset;
            ldmax = numeric_limits<long double>::max() + offset;
        }

        void resultados(){
           cout << "El valor de bool min es: " << bmin << "\n";
           cout << "El valor de bool max es: " << bmax << "\n";
           cout << "El valor de char min es: " << cmin << "\n";
           cout << "El valor de char max es: " << cmax << "\n";
           cout << "El valor de short min es: " << smin << "\n";
           cout << "El valor de short max es: " << smax << "\n";
           cout << "El valor de int min es: " << imin << "\n";
           cout << "El valor de int max es: " << imax << "\n";
           cout << "El valor de long int min es: " << lmin << "\n";
           cout << "El valor de long int max es: " << lmax << "\n";
           cout << "El valor de long long int min es: " << llmin << "\n";
           cout << "El valor de long long int max es: " << llmax << "\n";
           cout << "El valor de float min es: " << fmin << "\n";
           cout << "El valor de float max es: " << fmax << "\n";
           cout << "El valor de double min es: " << dmin << "\n";
           cout << "El valor de double max es: " << dmax << "\n";
           cout << "El valor de long double min es: " << ldmin << "\n";
           cout << "El valor de long double max es: " << ldmax << "\n";
        }
};

int main(){
    FueraRango tarea;

    tarea.meta();
    tarea.calculos(tarea.datos());
    tarea.resultados();
    return 0;
}
