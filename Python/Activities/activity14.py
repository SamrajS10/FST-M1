def fib(n):
    if n <= 1:
        return n
    return fib(n - 1) + fib(n - 2)

count = int(input("How many Fibonacci numbers to generate? "))

print("Fibonacci sequence:")
for i in range(count):
    print(fib(i), end=" ")
