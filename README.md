# Spring database operations
## A demonstration project - application of the 3 level architecture Spring database API

1. Presentation layer: This is the user interface of the application that presents the application’s features and data to the user.
2. (Controller) Business logic (or Application) layer: This layer contains the business logic that drives the application’s core functionalities. Like making decisions, calculations, evaluations, and processing the data passing between the other two layers. → UserService class
3. Data access layer (or Data) layer: This layer is responsible for interacting with databases to save and restore application data.  → UserRepository class

The program, once run allows to perform basic CRUD operations using JpaRepository in a three layer architecture.
