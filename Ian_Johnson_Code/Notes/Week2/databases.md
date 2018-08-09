# Databases

A (relational) database is a collection of data stored as related entities
(tables), each with a number of fields (columns) and rows representing each
entity. The language used to query a database is SQL (Structured Query
Language).

## Key terms

- RDBMS: a program for interacting with a database (e.g. Oracle SQL
  Developer).
- Schema: rules for structuring the database.
- ERD: diagram showing fields of tables and relationships between them.
- Candidate key: a column that can uniquely identify each row of a table (not
  null and unique).
- Primary key: a column which uniquely identifies each row of a table (a
  candidate key which is not sensitive and doesn't change).
  - Natural key: a naturally occurring entity in your table (e.g. username)
    used as the primary key.
  - Surrogate key: a key that's introduced for the purpose of being the primary
    key (e.g. a user ID number).
- Foreign key: a column in a table that refers to another column (either in
  the same table or in another one; usually refers to a primary key in another
  table). These are what enable us to build relationships in our database.
- Multiplicity: the relationships that you have between your tables.
  - 1:1: e.g. a user ID and Social Security ID in one table, and a Social
    Security ID with the actual number in another table (for security).
  - 1:n: e.g. a single user with many accounts. The foreign key should be in
    the "many" table, pointing to an entry in the "single" table.
  - n:n: e.g. joint accounts in a bank. Have a primary key in each table
    (users and accounts), and make a "junction table" (e.g. "users and
    accounts", with columns "user ID" and "account ID") that matches up the
    primary keys of each table.
- Composite key: more than one column which uniquely identify a row. For
  example, the junction table from the banking example above might also contain
  an "access level" column that specifies the access level that each user has
  to an account. The pair of user ID and account ID is the composite key for
  that table.
- Referential integrity: ensuring that the relationships between tables
  remain consistent.
  - Forbidding deletions of or changes to columns referenced by foreign keys.
  - Avoid "orphan" data: rows in DB with a foreign key that is non-existent.
- Domain integrity: ensuring that all data is of the right type and size.
- Lookup table: a table with static data that just serves to map keys to
  values (e.g. lookup state from zip code).

## Database normalization

Database normalization is the process of organizing data into related tables
to reduce redundancy and increase efficiency. There are many "normal forms"
that a database can be in; we aim for 3NF.

- 1NF: primary key, atomic data, no repeats
  - Atomic data: make your data elements as small as possible. For example,
    use first name and last name fields instead of a single "name" field.
- 2NF: 1NF, no partial dependencies
  - No partial dependencies: making sure that the columns depend on the
    entirety of the primary key. For example, we would not introduce a balance
    key into the junction table of users and accounts in our banking example,
    because it does not depend on the entire composite key (it has nothing to
    do with the user). A DB with no composite keys that is in 1NF is in 2NF
    automatically.
- 3NF: 2NF, no transitive dependencies
  - No transitive dependencies: no field should depend on a field in the
    table that isn't the primary key. For example, a user's state is dependent
    on their zip code, so including the state as a field in the users table
    would introduce a transitive dependency. Another example would be the
    total price of a purchase, when the purchase entry already includes the
    unit price and quantity sold.

A good way to remember this is: the key, the whole key and nothing but the
key (each of these, in order, is one of the three normal forms).

## Example

A simple table called `BANK_USERS` might have several columns. Each column
has a name, type and constraints.

Some constraints:

- NOT NULL
- UNIQUE
- CHECK: check if a particular expression is true for attempted data input.
- DEFAULT: give a default value.
- PRIMARY KEY: specify that the column is a primary key (NOT NULL and UNIQUE).
- FOREIGN KEY: specify that the column is a foreign key.

You should always check that these constraints are satisfied _before_
changing the database; don't rely on them to alert you of errors.

# SQL

## SQL sublanguages

- DCL (Data Control Language): control database credentials
  - GRANT, REVOKE
- DDL (Data Definition Language): create/update database schema
  - CREATE, ALTER, TRUNCATE, DROP
    - ALTER: add or remove columns in the table (changes the schema).
    - TRUNCATE: remove every row from the table, but the schema remains in
      place.
    - DROP: get rid of an entire table.
- DML (Data Manipulation Language): add/update/remove table rows ("CRUD" =
  "create, read, update, delete")
  - INSERT, SELECT, UPDATE, DELETE
    - UPDATE: change values in row(s).
    - DELETE: remove rows, but can be rolled back.
- DQL (Data Query Language):
  - SELECT
- TCL (Transaction Control Language): manage DB TX (TX = transaction)
  - COMMIT, ROLLBACK, SAVEPOINT
  - TX isolation levels, propagation, and properties of a TX (e.g. ACID) are
    important here.
  - You must COMMIT a transaction before the database will actually be updated.
  - You can use SAVEPOINT to mark a good state, to which you can ROLLBACK
    later. Only DML commands can be rolled back; e.g. you cannot roll back a
    DROP or TRUNCATE.

## Subqueries

Queries nested inside of another to further narrow the result set. They can
be correlated or non-correlated. A non-correlated subquery can execute
independently of the outer query:

```sql
SELECT S.ID, S.NAME
FROM STUDENT_DETAILS
WHERE S.NAME IN (
  SELECT S.NAME
  FROM STUDENT_DETAILS
  WHERE S.MAJOR = 'History'
);
```

A correlated query cannot execute independently:

```sql
SELECT P.NAME
FROM PRODUCT P
WHERE P.ID = (
  SELECT O.PRODUCT
  FROM ORDER O
  WHERE O.PRODUCT = P.ID
);
```

## DDL (Data Definition Language)

- `CREATE`: creates tables, sequences, triggers, procedures, functions,
  indexes, etc.
- `ALTER`: updates the table schema. Adding a column with column-level
  constraints will throw an error because all entries in the new column will be
  null, thereby violating the constraint.
- `TRUNCATE TABLE`: deletes all rows from a table; unlike `DELETE FROM`, it
  cannot be rolled back and will not fire a trigger.
- `DROP`: removes structural elements (table, constraint, sequence, etc.),
  and cannot be rolled back.
- Sequence: good for P.K. (primary key) management. It is an object in Oracle
  that is used to generate a number sequence.
- Triggers: a block of code that is automatically executed when events
  happen. Can specify DML statements to respond to.
  - We will use these to increment and grab the value of a sequence for
    automatic insertion of a PK when attempting to insert a row in a table.
- Indexes: a schema object that contains an entry for each value that appears
  in the indexed column(s) of the table or cluster and provides direct, fast
  access to rows.
  - Oracle automatically creates indexes for PKs.
  - While indexes are useful for traversal of data, they make adding and
    removing data slower and should be created sparingly.

# JDBC (Java Database Connectivity)

JDBC is the basic, low-level API used to interact with a database, contained
in the `java.sql` package.

# PL/SQL (Procedural Language/SQL)

Includes triggers, sequences, procedures and functions. The "king" of PL/SQL
is procedure.

## Procedures

A (stored) procedure is a named block of code. For example, a sequence of
INSERTs, UPDATEs and DELETEs could be made into a procedure for easy reuse.
You can also have parameters to a procedure (e.g. a make_employee procedure
that inserts a new employee into the employees table with the given name, age
and salary but also generates some extra values like an employee ID and takes
care of any other references that need to be set up), but parameters are not
required. They also do not need to have any outputs, but they can.

Procedures are compiled once in your database. They can do DML, allowing them
to create/modify/delete entries in tables.

## Functions

A function is a mathematical operation. Functions always have at least one
input and exactly one output. They _cannot_ change the tables (no DML). For
example, if your company has a policy where nobody gets less that 50% the
average salary, you might create a function that calculates the new salary
for an employee when somebody gets a raise, and then use that function in a
procedure that actually updates the salaries.

Functions are compiled each time they are called, in contrast to procedures.

## Sequences

A sequence is used to make numbers in a sequence (e.g. for making unique user
IDs).

## Triggers

A trigger is a section of code that is executed whenever certain DML
operations are performed (e.g. when inserting a new row into a table).

## Indexes

An index is a schema object that makes lookups faster, although it makes
adding and removing data slower. Oracle automatically provides an index for
every column with the UNIQUE constraint.
