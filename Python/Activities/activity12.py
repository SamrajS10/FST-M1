def recursive_sum(n):
    # Base case
    if n == 0:
        return 0
    return n + recursive_sum(n - 1)

result = recursive_sum(10)
print("Sum from 0 to 10 is:", result)
