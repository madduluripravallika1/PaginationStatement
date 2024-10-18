Here are the cURL commands for each of the endpoints in your ProductController class:

1. Get All Products
Endpoint: GET /products/get
cURL Command:

bash
Copy code
curl -X GET "http://localhost:8080/products/get" -H "accept: application/json"
2. Get Products with Sorting
Endpoint: GET /products/{field}
Example: Sort by name
cURL Command:

bash
Copy code
curl -X GET "http://localhost:8080/products/name" -H "accept: application/json"
3. Get Products with Pagination
Endpoint: GET /products/pagination/{offset}/{pageSize}
Example: Paginate with offset 0 and page size 10
cURL Command:

bash
Copy code
curl -X GET "http://localhost:8080/products/pagination/0/10" -H "accept: application/json"
4. Get Products with Pagination and Sorting
Endpoint: GET /products/paginationAndSort?offset={offset}&pagesize={pagesize}
Example: Paginate with offset 0, page size 10, and default sorting by id
cURL Command:

bash
Copy code
curl -X GET "http://localhost:8080/products/paginationAndSort?offset=0&pagesize=10" -H "accept: application/json"
These cURLs assume your application is running locally on port 8080. You can adjust the field, offset, and pageSize as needed for your queries.
