import pandas
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}
df = pandas.DataFrame(data)
df.to_csv("users.csv", index=False)
print("CSV file created successfully!")
