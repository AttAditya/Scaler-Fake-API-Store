# Documentation

## Test Endpoints

### [GET] `/hello`

#### Usage
It is a test endpoint. It is used to check if server is running or not.

#### Returns
```text
Hello, World!
```

## Product

### [GET] `/products`

#### Usage
Returns list of all products.

#### Returns
```json5
[
  {
    id:1,
    title:'...',
    price:'...',
    category:'...',
    description:'...',
    image:'...'
  },
  /*...*/
  {
    id:30,
    title:'...',
    price:'...',
    category:'...',
    description:'...',
    image:'...'
  }
]
```

### [GET] `/products/{productId}`

#### Usage
Returns the details of product with id `productId`.

#### Returns
```json5
{
  id:1,
  title:'...',
  price:'...',
  category:'...',
  description:'...',
  image:'...'
}
```

### [GET] `/products/categories`

#### Usage
Returns the list of all categories.

#### Returns
```json5
[
  "electronics",
  "jewelery",
  "men's clothing",
  "women's clothing"
]
```

### [GET] `/products/category/{categoryName}`

#### Usage
Returns the list of products which have category `categoryName`.

#### Returns
```json5
[
  {
    id:5,
    title:'...',
    price:'...',
    category:'jewelery',
    description:'...',
    image:'...'
  },
  /*...*/
  {
    id:8,
    title:'...',
    price:'...',
    category:'jewelery',
    description:'...',
    image:'...'
  }
]
```

### [POST] `/products`

#### Usage
Adds a new product to list and returns it.

#### Takes
```json5
{
  title: 'test product',
  price: 13.5,
  description: 'lorem ipsum set',
  image: 'https://i.pravatar.cc',
  category: 'electronic'
}
```

#### Returns
```json5
{
  id:31,
  title:'...',
  price:'...',
  category:'...',
  description:'...',
  image:'...'
}
```

### [PUT] `/products/{productId}`

#### Usage
Updates the product with id `productId` and returns it.

#### Takes
```json5
{
  title: 'test product',
  price: 13.5,
  description: 'lorem ipsum set',
  image: 'https://i.pravatar.cc',
  category: 'electronic'
}
```

#### Returns
```json5
{
  id:7,
  title:'new title',
  price:'new price',
  category:'new category',
  description:'new description',
  image:'new image url'
}
```

### [DELETE] `/products/{productId}`

#### Usage
Deletes the product with id `productId` and returns it.

#### Returns
```json5
{
  id:7,
  title:'new title',
  price:'new price',
  category:'new category',
  description:'new description',
  image:'new image url'
}
```

## Cart

### [GET] `/carts`

#### Usage
Returns list of all carts.

#### Returns
```json5
[
  {
    id:1,
    userId:1,
    date:"2020-10-10",
    products:[{productId:2,quantity:4},{productId:1,quantity:10},{productId:5,quantity:2}]
  },
  /*...*/
  {
    id:20,
    userId:10,
    date:"2019-10-10",
    products:[{productId:1,quantity:5},{productId:5,quantity:1}]
  }
]
```

### [GET] `/carts/{cartId}`

#### Usage
Returns the details of cart with id `cartId`.

#### Returns
```json5
{
  id:5,
  userId:1,
  date:...,
  products:[...]
}
```

### [GET] `/cart?startdate={startdate}&enddate={enddate}`

#### Usage
Returns the list of all carts which have date in between `startdate` and `enddate`.

#### Returns
```json5
[
  {
    id:1,
    userId:1,
    date:2019-12-10,
    products:[...]
  },
  /*...*/
  {
    id:4,
    userId:1,
    date:2020-10-10,
    products:[...]
  }
]
```

### [GET] `/carts/user/{userId}`

#### Usage
Returns the list of carts that have user id `userId`.

#### Returns
```json5
[
  {
    id:5,
    userId:2,
    date:2019-10-03,
    products:[...]
  },
  /*...*/
  {
    id:6,
    userId:2,
    date:2020-10-10,
    products:[...]
  }
]
```

### [POST] `/carts`

#### Usage
Adds a new cart to list and returns it.

#### Takes
```json5
{
  userId:5,
  date:2020-02-03,
  products:[
    {productId:5,quantity:1},
    {productId:1,quantity:5}
  ]
}
```

#### Returns
```json5
{
  id:21
  userId:5,
  date:2020-02-03,
  products:[
    {productId:5,quantity:1},
    {productId:1,quantity:5}
  ]
}
```

### [PUT] `/carts/{cartId}`

#### Usage
Updates the cart with id `cartId` and returns it.

#### Takes
```json5
{
  userId:3,
  date:2019-12-10,
  products:[
    {productId:1,quantity:3}
  ]
}
```

#### Returns
```json5
{
  id:7,
  userId:3,
  date:2019-12-10,
  products:[{productId:1,quantity:3}]
}
```

### [DELETE] `/carts/{cartId}`

#### Usage
Deletes the cart with id `cartId` and returns it.

#### Returns
```json5
{
  id:6,
  userId:...,
  date:...,
  products:[...]
}
```

# Testing

To test, run `src/test/java/com/scaler/midterms/MidtermsApplicationTests.java` 

