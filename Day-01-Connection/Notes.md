# Day 1 - JDBC Connection

## Objective
Learn how to connect a Java application with a MySQL database using JDBC and retrieve records.

---

## JDBC (Java Database Connectivity)

JDBC is an API provided by Java that allows Java applications to communicate with databases such as MySQL, Oracle, PostgreSQL, SQL Server, etc.

---

## Prerequisites

### 1. JDK Installed
Java Development Kit should be installed and configured.

### 2. MySQL Installed
MySQL Server should be running.

### 3. MySQL Connector/J Driver

JDBC cannot communicate with MySQL directly.

We need a JDBC Driver (MySQL Connector/J) which acts as a bridge between Java and MySQL.

Driver Class:

```java
com.mysql.cj.jdbc.Driver
```

Driver JAR:

```text
mysql-connector-j-9.x.x.jar
```

Add this JAR to the project's build path.

---

## Steps of JDBC

### Step 1: Load Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

Loads the MySQL JDBC Driver.

---

### Step 2: Establish Connection

```java
Connection connection =
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/db_name",
"root",
"password");
```

Creates a connection between Java application and database.

---

### Step 3: Create Statement

```java
Statement statement =
connection.createStatement();
```

Used to send SQL queries to the database.

---

### Step 4: Write SQL Query

```java
String query = "select * from employee";
```

---

### Step 5: Execute Query

```java
ResultSet resultSet =
statement.executeQuery(query);
```

Returns data from the database.

---

### Step 6: Process Result

```java
while(resultSet.next())
```

Reads records row by row.

---

### Step 7: Close Resources

```java
statement.close();
connection.close();
```

Releases database resources.

---

## JDBC Classes Used

| Class | Purpose |
|---------|---------|
| DriverManager | Creates database connection |
| Connection | Represents database connection |
| Statement | Executes SQL queries |
| ResultSet | Stores query results |

---

## Output

Displays employee details:
- Employee Id
- Employee Name
- Salary
- Designation
- Department Id

---

## Interview Questions

### What is JDBC?

JDBC (Java Database Connectivity) is an API that enables Java applications to interact with databases.

### Why is JDBC Driver required?

It acts as a bridge between Java application and database.

### What is ResultSet?

ResultSet stores data returned by a SELECT query.

### Difference between executeQuery() and executeUpdate()?

- executeQuery() → Used for SELECT statements.
- executeUpdate() → Used for INSERT, UPDATE, DELETE statements.

---

## Files

- DataBaseConnection.java

## Status

✅ Successfully connected Java with MySQL database and fetched employee records.
