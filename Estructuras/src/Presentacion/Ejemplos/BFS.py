"""
1.- Meta:
    Escribir("Encontrar la ruta más corta entre dos  nodos")
    Escribir("a partir del número de aristas")

2.- Datos:
    2.1.- Inicalizar:
        visitados = set()
        parent = dict()
        G = eval(leerGrafo())

        2.1.1.- LeerGrafo:
            // Lee el grafo de un archivo
            Escribir("Archivo: ") file = ?
            abrir(file)
            s = leerTodo(file)
            cerrar(file)
            retornar s

    2.2.- PedirDatos:
        Escribir("Nodo inicio: ") inicio = ?
        Escribir("Nodo final : ") final  = ?

3.- Calculos:
    // Usa G (grafo), inicio (Nodo inicial) y final (Nodo final)
    Q = list()
    visitados.add(inicio)
    Q.append(inicio)
    Mientras(Q no esté vacia) entonces
        v = Q.pop()
        Si(v == final) entonces
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
    res.append(final)
    res.append(p)
    Mientras(p != inicio) entonces
        p = parent[p]
        res.append(p)
        count++
    terminar
    Escribir(count)
    Escribir(reverse(res))

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
        def __leer_grafo():
            file = input("Archivo: ")
            with open(file) as f:
                return f.read()
        G = eval(__leer_grafo())
        visitados = set()
        parent = dict()
    def _pedir_datos():
        global inicio, final
        inicio = int(input("Nodo inicio: "))
        final  = int(input("Nodo final : "))

    _inicializar()
    _pedir_datos()

def calculos(G, inicio, final):
    Q = list()
    visitados.add(inicio)
    Q.append(inicio)
    while Q:
        v = Q.pop()
        if v == final:
            return v
        for w in G[v]:
            if w not in visitados:
                visitados.add(w)
                parent[w] = v
                Q.append(w)

def resultados():
    res = list()
    count = 1
    p = parent[final]
    res.append(final)
    res.append(p)
    while p != inicio:
        p = parent[p]
        res.append(p)
        count = count + 1
    print(res[::-1], count, sep = ': ')

if __name__ == "__main__":
    meta()
    datos()
    calculos(G, inicio, final)
    resultados()
