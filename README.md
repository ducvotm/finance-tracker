# 💰 Personal Finance Tracker

A friendly app built with Java and Spring Boot that helps you keep track of your money, like a digital piggy bank that's super smart!

## 🌟 What Does This App Do?

Think of this app as your money helper. It lets you:

- 📝 Write down when money comes in (like your paycheck) and goes out (like buying groceries)
- 📊 Sort your spending into groups (like "food," "fun stuff," or "bills")
- 💼 Keep track of different bank accounts or credit cards
- 📈 See pictures of where your money goes so you can make better choices

## 🏗️ How It's Built

This project uses several building blocks (like LEGO pieces that fit together):

### Main Ingredients
- **Java 17**: The main language I used to write the instructions
- **Spring Boot**: A helper that makes everything work together without writing tons of code
- **Spring Data JPA**: A magic translator that talks to the database
- **Spring Security**: A security guard that keeps user information safe
- **MySQL**: A digital filing cabinet where all the money information is stored
- **Thymeleaf**: Creates the web pages you see in your browser

### How The Code Is Organized

```
src/main/java/vn/duke/finance_tracker/
│
├── api/                      # All the money tracking features
│   ├── controller/           # Handles what happens when you click buttons
│   ├── dto/                  # Special message carriers
│   ├── entity/               # Digital versions of real things (like accounts)
│   ├── repository/           # Knows how to find information in the database
│   └── service/              # Contains all the important rules
│
├── authentication/           # Everything about logging in
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── repository/
│   └── service/
│
└── common/                   # Helpful tools used everywhere
    ├── enums/                # Lists of fixed options
    ├── exception/            # Handles when things go wrong
    └── response/             # How the app talks back to you
```

## ✨ Cool Features

### 👤 User Stuff
- Create your own account
- Log in securely with a password
- Update your profile information

### 💳 Account Management
- Add different accounts (like checking account, savings, credit card)
- See how much money is in each account
- Look at the history of each account

### 📋 Transaction Tracking
- Record when money comes in or goes out
- Add details like what it was for and when it happened
- Look back at your spending history

### 🏷️ Category Management
- Group your spending (like "groceries" or "movies")
- Create your own categories if you need them
- Separate money coming in from money going out

## 🚀 How To Start Using It

### What You Need First
- Java 17 or newer installed on your computer
- Maven (a helper tool) version 3.8 or newer
- MySQL database (like a digital filing cabinet)

### Setup Steps

1. **Get the code**
   ```
   git clone https://github.com/yourusername/finance-tracker.git
   cd finance-tracker
   ```

2. **Set up your database**

   Make sure MySQL is running and create a database called `finance_db`.

3. **Tell the app how to find your database**

   Look in the `application.yml` file and change these settings:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/finance_db
       username: your_username
       password: your_password
   ```

4. **Turn on the app**
   ```
   mvn spring-boot:run
   ```

5. **Use the app**

   Open your web browser and go to `http://localhost:8080`

## 🔄 API Endpoints (How Other Programs Can Talk To This One)

### User Login
- `POST /api/auth/register` - Make a new user account
- `POST /api/auth/login` - Sign in to your account

### Money Accounts
- `GET /account` - See all your accounts
- `GET /account/{id}` - Look at one specific account
- `POST /account` - Create a new account
- `PUT /account/{id}` - Change account information
- `DELETE /account/{id}` - Delete an account you don't want

### Money Movements (Transactions)
- `GET /transaction` - See all money movements
- `GET /transaction/{id}` - Look at one specific transaction
- `POST /transaction` - Record a new money movement
- `PUT /transaction/{id}` - Fix a transaction's details
- `DELETE /transaction/{id}` - Remove a transaction

### Spending Categories
- `GET /category` - See all your categories
- `GET /category/{id}` - Look at one specific category
- `POST /category` - Make a new category
- `PUT /category/{id}` - Change a category
- `DELETE /category/{id}` - Remove a category

## 📚 What You Can Learn From This Project

This project shows off several important skills that employers look for:

1. **Spring Boot Structure**: How to organize a real application
2. **Database Work**: How to store and find information efficiently
3. **Security**: How to keep user information safe
4. **API Design**: How to create clean, usable interfaces for programs
5. **Input Checking**: How to make sure data is correct before using it
6. **Error Handling**: How to gracefully handle problems

## 🔜 Future Upgrades

Here are some cool features I could add next:

- Budget planning - set goals and see if you're meeting them
- Pretty charts and graphs to visualize your money
- Export your financial reports to PDF or Excel
- Automatic recurring transactions (like rent that comes out every month)
- Goal setting (save for a vacation!)
- Support for different currencies

## 📄 License

This project is available under the MIT License - see the LICENSE file for details.