user_input = input("Enter numbers separated by commas: ")
numbers = tuple(int(num) for num in user_input.split(','))

print("Numbers divisible by 5:")
for n in numbers:
    if n % 5 == 0:
        print(n)
