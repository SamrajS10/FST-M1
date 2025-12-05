user = input("Enter the number separated by spaces: ")
numbers = user.split()
numbers = [int(x) for x in numbers]

total = 0
for num in numbers:
    total +=num
print("The sum of the list is:", total)