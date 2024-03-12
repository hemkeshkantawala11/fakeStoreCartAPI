# Fake Store Cart API

I have created this project which is a Spring Boot application that provides a RESTful API for managing shopping carts in a fake online store.
Here I have used fakeStoreAPI to get the data and made an API of minine just using it.

## Technologies Used

- Java
- Spring Boot

## API Endpoints

The API provides the following endpoints:
These are the various things that are supported by my API.

To use this all you have to: 
- clone my repository and run the FakeStoreCartApplication file.
- Then you need to go to the browser and write the url to get the data from my API.
- The various urls supported are as given below:

  - `GET` `/carts`: Fetch all carts from all the users.
  - `GET` `/carts/{id}`: Fetch a specific cart by its ID(cart ID).
  - `GET` `/carts?startdate={sDate}&enddate={eDate}`: Fetch carts within a specific date range. That is it helps us to get all the carts that were made from the given start date to the given end date. 
  - `GET` `/carts/user/{userID}`: It Fetches all the carts ofr a specific user.
  - `POST` `/carts`: Add a new cart. This doesn't actually change the date of the used API but if you run it in the postMan then you would the output as the new cart that you wanted to add.
  - `DELETE` `/carts/{id}`: Delete a specific cart by its ID. This also doesn't change the actual database from which we are getting the carts.
  - `PUT` `/carts/{id}`: Update a specific cart by its ID. This doesn't change the actual database of the API used. But if you run the code in the postMan then you will get the output of the updated cart.

## Setup and Installation

1. Just Clone the repository.
2. Or fork the repo.
3. Or just download the zip file.
4. After doing the one of the above steps just run the `FakeStoreCartApplication` file and you are good to go.

## References

- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
- Scaler Class of Naman Bhalla sir 😂 (Scaler Dashboard Kholunga toh lagega copy kiya hai toh sorry link nai de sakta 😂)