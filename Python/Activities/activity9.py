list1 = [10, 21, 4, 45, 66, 93]
list2 = [12, 3, 5, 8, 14, 7]

new_list = []

for num in list1:
    if num % 2 != 0:
        new_list.append(num)

for num in list2:
    if num % 2 == 0:
        new_list.append(num)

print("New list:", new_list)
