print("Welcome to Rock-Paper-Scissors!")

options = ["rock", "paper", "scissors"]
index = 0   

while True:
    user_choice = input("Enter Rock, Paper, or Scissors: ").lower()

    if user_choice not in options:
        print("Invalid choice, try again.")
        continue

    computer_choice = options[index]
    index = (index + 1) % 3  

    print("Computer chose:", computer_choice)

    if user_choice == computer_choice:
        print("It's a tie!")
    elif (user_choice == "rock" and computer_choice == "scissors") or \
         (user_choice == "paper" and computer_choice == "rock") or \
         (user_choice == "scissors" and computer_choice == "paper"):
        print("You win!")
    else:
        print("You lose!")

    play_again = input("Do you want to play another round? (Yes/No): ").lower()
    if play_again != "yes":
        print("Thanks for playing!")
        break
