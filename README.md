Spring Web Content Serving

This is a simple web application developed using Spring Boot to serve content related to consumer orders and sellers. It includes features such as creating orders, viewing all orders, and deleting orders. Additionally, it provides a custom login and logout functionality.
The application will start at http://localhost:8080.

Endpoints:

Greeting

    URL: /greeting
    Method: GET
    Description: Displays a greeting message.

View All Orders

    URL: /all_orders
    Method: GET
    Description: Displays all orders.

Create Orders

    URL: /create_orders
    Method: GET
    Description: Displays a form to create new orders.

Save Orders

    URL: /save
    Method: POST
    Description: Saves the newly created orders.

Delete Orders

    URL: /delete_orders
    Method: GET
    Description: Displays a form to delete orders.

Post Delete Order

    URL: /post_delete_order
    Method: POST
    Description: Deletes the selected order.

Custom Login

    URL: /custom-login
    Method: GET
    Description: Displays a custom login page.

Custom Logout

    URL: /custom-logout
    Method: GET
    Description: Logs out the user and redirects to the login page.

Configuration

    This application uses Spring Security for authentication and authorization.
    The base URL for the application is http://localhost:8080.

Controllers

The application contains the following controller:

    GreetingController: Handles requests related to greeting, creating, viewing, and deleting orders, as well as custom login and logout functionalities.

Services

The application uses the following services:

    ConsumerService: Manages operations related to consumers.
    OrderService: Manages operations related to orders.
    SellerService: Manages operations related to sellers.