import turtle

def meta():
    print("Dibujar la curva Koch")

def datos():
    global levels, length
    levels = turtle.numinput("Deep", "Levels (0 <= x <= 6): ", 0, 0, 6)
    length = turtle.numinput("Lines", "Length (1 <= x <= 400: ", 1, 1, 400)

def calculos(length, n):
    turtle.ht()
    turtle.speed(0)
    turtle.penup()
    turtle.backward(length/2)
    turtle.left(90)
    turtle.forward(length / 3)
    turtle.right(90)
    turtle.pendown()
    koch_snowflake(length, n)
    turtle.mainloop()

def koch_snowflake(length, n):
    koch(length, n)
    turtle.right(120)
    koch(length, n)
    turtle.right(120)
    koch(length, n)

def koch(length, n):
    if(n == 0):
        resultados(length)
        return
    length = length / 3
    koch(length, n - 1)
    turtle.left(60)
    koch(length, n - 1)
    turtle.right(120)
    koch(length, n - 1)
    turtle.left(60)
    koch(length, n - 1)

def resultados(length):
    turtle.forward(length)

if __name__ == "__main__":
    meta()
    datos()
    calculos(length, levels)
