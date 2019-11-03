"""
1.- Meta:
    Escribir("Encontrar la ruta más corta entre dos  nodos")
    Escribir("a partir del número de aristas")

2.- Datos:
    2.1.- Inicalizar:
        G = {
                1: set([2, 3]),
                2: set([4, 5]),
                3: set([6, 7]),
                4: set([8, 9]),
                5: set(),
                6: set(),
                7: set(),
                8: set(),
                9: set(),
            }
        visitados = set()
        parent = dict()

    2.2.- PedirDatos:
        Escribir("Nodo inicio: ") inicio = ?
        Escribir("Nodo final : ") final  = ?

3.- Calculos:
    // Usa G (grafo), start_v (Nodo inicial) y f (Nodo final)
    Q = list()
    visitados.add(start_v)
    Q.append(start_v)
    Mientras(Q no esté vacia) entonces
        v = Q.pop()
        Si(v == f) entonces
            retornar v
        terminar
        Para cada w en G[v] empezar
            Si(w no está en visitados) entonces
                visitados.add(w)
                parent[w] = v
                Q.append(w)
            terminar
        terminar
    terminar

4.- Resultados:
    count = 1
    p = parent[final]
    Mientras(p != inicio) entonces
        p = parent[p]
        count++
    terminar
    Escribir(count)

5.- Navegabilidad:
    No hay
"""

def meta():
    s = "Encontrar la ruta más corta entre dos nodos"
    s = s + " a partir del número de aristas"
    print(s)

def datos():
    def _inicializar():
        global G, visitados, parent
        G = {
                1: set([2, 3]),
                2: set([4, 5]),
                3: set([6, 7]),
                4: set([8, 9]),
                5: set(),
                6: set(),
                7: set(),
                8: set(),
                9: set(),
            }
        visitados = set()
        parent = dict()
    def _pedir_datos():
        global inicio, final
        inicio = int(input("Nodo inicio: "))
        final  = int(input("Nodo final : "))

    _inicializar()
    _pedir_datos()

def calculos(G, start_v, f):
    Q = list()
    visitados.add(start_v)
    Q.append(start_v)
    while Q:
        v = Q.pop()
        if v == f:
            return v
        for w in G[v]:
            if w not in visitados:
                visitados.add(w)
                parent[w] = v
                Q.append(w)

def resultados():
    count = 1
    p = parent[final]
    while p != inicio:
        p = parent[p]
        count = count + 1
    print(count)

if __name__ == "__main__":
    meta()
    datos()
    calculos(G, inicio, final)
    resultados()
