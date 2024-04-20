# README - Product Management System

## Project Description
This is a simple product management system developed in Java. It allows the user to register products from different categories such as beverages, food products, electronics, and apparel. Additionally, the system enables displaying a list of products for each category and all registered products, as well as exiting the program. The system utilizes various object-oriented programming concepts and design patterns to ensure an organized and extensible structure.

## Features
The system offers the following features:
- Product Registration: Allows the user to register products from different categories such as beverages, food products, electronics, and apparel.
- Listing Products by Category: Enables the user to view a list of registered products in each category.
- Listing All Products: Displays a list of all products registered in the system, regardless of category.
- Program Exit: Allows the user to exit the program in a controlled manner.

## Project Structure
The project is structured into several Java classes, each with a specific responsibility:

1. **[Main](./src/main/java/andre/chamis/Main.java)**: Main class that starts the program by initializing the menu.
2. **[Menu](./src/main/java/andre/chamis/application/menu/Menu.java)**: Class responsible for displaying a menu of options to the user and directing them to the selected option.
3. **[MenuOption](./src/main/java/andre/chamis/application/menu/MenuOption.java)**: Enumeration representing the menu options, each associated with a `Command` object defining the corresponding action.
4. **[Command](src/main/java/andre/chamis/application/command)**: Interface defining an `execute()` method, implemented by command classes.
5. **[ProductCommand](src/main/java/andre/chamis/application/command/product/ProductCommand.java)**: Abstract class implementing the Command interface and providing a field for the product service.
6. **[ProductService](./src/main/java/andre/chamis/services/ProductService.java)**: Singleton providing methods to interact with products, such as registering, getting all products, etc.
7. **[ProductRepository](./src/main/java/andre/chamis/repo/ProductRepository.java)**: Class responsible for storing products in a map and providing methods to access them.
8. **[Product](./src/main/java/andre/chamis/domain/product/Product.java)**: Abstract class representing a product with its basic attributes and methods to print details and get user input.
9. **[InputUtils](./src/main/java/andre/chamis/utils/InputUtils.java)**: Utility class providing methods for obtaining user input.
10. **[StringUtils](./src/main/java/andre/chamis/utils/StringUtils.java)**: Utility class providing string manipulation methods.

## Design Patterns Used
The project makes use of the following design patterns:

1. **Singleton**: Used in the [ProductService](./src/main/java/andre/chamis/services/ProductService.java) and [Menu](src/main/java/andre/chamis/application/menu/Menu.java) classes to ensure that only one instance of the product service is created during program execution and thus the same instance can be used across the entire application.

2. **Command**: The Command pattern is employed in classes related to menu commands. The [Command](src/main/java/andre/chamis/application/command) interface defines an `execute()` method, which is implemented by various command classes, allowing encapsulation of user actions into independent objects.

3. **Factory Method**: Although not explicitly implemented in the provided classes, the `fromInput()` method in some classes can be considered a simplified implementation of the Factory Method pattern, allowing the creation of product instances based on user input.

4. **Strategy**: The [MenuOption](./src/main/java/andre/chamis/application/menu/MenuOption.java) enumeration can be seen as a simplified implementation of the Strategy pattern. Each constant in the enumeration represents a menu option, and each option has a associated strategy in the form of a [Command](src/main/java/andre/chamis/application/command) object. This allows dynamic selection of behaviors at runtime, without the need for specific implementation details in the code calling the menu options.

This README provides an overview of the product management system and highlights the design patterns used. For more details on specific implementations and other design considerations, refer to the provided source code.
