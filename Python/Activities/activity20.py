import pandas

df = pandas.read_excel("users.xlsx")

rows, cols = df.shape
print(f"Number of rows: {rows}")
print(f"Number of columns: {cols}\n")

print("Emails column:")
print(df["Email"], "\n")

sorted_df = df.sort_values(by="FirstName", ascending=True)
print("Data sorted by FirstName (ascending):")
print(sorted_df)
