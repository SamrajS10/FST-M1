fruits = {
    "apple": 120,
    "banana": 40,
    "mango": 150,
    "orange": 80,
    "grapes": 90,
    "pineapple": 60
}
fruit_name = input("Enter the name of the fruit: ").lower()
if fruit_name in fruits:
    print(f"Yes! {fruit_name.capitalize()} is available at ₹{fruits[fruit_name]}.")
else:
    print(f"Sorry, {fruit_name.capitalize()} is not available.")
