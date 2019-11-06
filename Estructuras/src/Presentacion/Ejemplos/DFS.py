"""
1.- Meta:
    Escribir("Encontrar la una ruta del nodo (root) a nodo (leave)")
    Escribir("como en un laberinto")

2.- Datos:
    2.1.- Inicializar:
        // Inicializa el grafo y set de visitados
        G = eval(leerGrafo())
        visitados = set()

        2.1.1.- LeerGrafo:
            // Lee el grafo de un archivo
            Escribir("Archivo: ") file = ?
            abrir(file)
            s = leerTodo(file)
            cerrar(file)
            retornar s

    2.2.- PreguntarNodos:
        Escibir("Nodo inicio: ") inicio = ?
        Escribir("Nodo final: ") final = ?


3.- Calculos:
    // Usa G (grafo), v (inicio) y f (final)
    visitados.add(v)
    res.append(v)
    Si(v == f) entonces
        retornar Verdadero
    terminar
    Para cada w en G[v]:
        Si(w no está en visitados) entonces
            Si(Calculos(G, w, f) entonces
                retornar Verdadero
            terminar
        terminar
    terminar
    res.pop()
    retornar Falso

4.- Resultados:
    Escribir(res)

5.- Navegabilidad:
    No hay
"""
res = list()

def meta():
    s = "Encontrar una ruta del nodo (root) a nodo (leave)"
    s = s + " como en un laberinto"
    print(s)

def datos():
    def _inicializar():
        global G, visitados
        def __leer_grafo():
            file = input("Archivo: ")
            with open(file) as f:
                return f.read()
        G = eval(__leer_grafo())
        visitados = set()

    def _preguntar_nodos():
        global inicio, final
        inicio = int(input("Nodo inicio: "))
        final  = int(input("Nodo final : "))

    _inicializar()
    _preguntar_nodos()

def calculos(G, v, f):
    visitados.add(v)
    res.append(v)
    if v == f:
        return True
    for w in G[v]:
        if w not in visitados:
            if calculos(G, w, f):
                return True
    res.pop()
    return False

def resultados():
    print(res)

if __name__ == "__main__":
    meta()
    datos()
    calculos(G, inicio, final)
    resultados()
