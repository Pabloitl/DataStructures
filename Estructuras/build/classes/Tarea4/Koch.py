import turtle

def meta():
    print("Dibujar la curva Koch")

def datos():
    levels = turtle.numinput("Deep", "Levels: ")
    length = turtle.numinput("Lines", "Length: ")

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

def koch_snowflake(length, n):
    koch(length, n)
    turtle.right(120)
    koch(length, n)
    turtle.right(120)
    koch(length, n)

def resultados(length):
    turtle.forward(length)

if __name__ == "__main__":
    turtle.ht()
    turtle.speed(0)
    turtle.penup()
    turtle.backward(length/2.0)
    turtle.pendown()
    koch_snowflake(length, levels)
    turtle.mainloop()
