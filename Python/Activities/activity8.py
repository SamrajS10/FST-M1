user = input("Enter numbers separated by spaces: ")
numbers = user.split()
numbers = [int(x) for x in numbers]
if numbers[0] == numbers[-1]:
    print(True)
else:
    print(False)