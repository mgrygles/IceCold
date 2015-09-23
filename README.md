# IceCold
FORMAT: 1A
HOST: http://localhost/

# IceCold

IceCold is a Point-of-Sale (POS) prototype system for managing the sales and inventory of IceCold product that
everybody loves - ice cream of many flavors :).

# IceCold API Root [/]

This resource is the root of the tree and does not have any attributes. Instead it offers the initial API affordances in the form of the links in the JSON body.


## Entry point into the IceCold POS system 

This provides an entry point into the IceCold POS system.  When invoked from the Web UI level, a login page/dialog will be
presented.

+ Response 200 (application/json) [GET]
  {  
      "icecold_url": "/icecold"
  }

### Login to the IceCold POS system 

This submits the login request to the IceCold POS system.

+ Request (application/json) [POST]
  { 
       "url": "/icecold/login",
       "user_id", "vipUser",
       "password", "thePassword",
  }

+ Response 201


## Product - Ice Cream Flavors [/icecold/flavors]

Resource related to products in the API.

### Get All Flavors [/icecold/flavors]

+ Response 200 (application/json) [GET]
   {
       "url": "/icecold/flavors"
       "flavors": [
           "vanilla",
           "chocolate",
           "strawberry",
           "oreo",
           "peach",
           "mocha",
           "java",
           "rainbow"
        ]
   }

### Get info about a flavor [/icecold/flavors/{flavor}]
 
+ Response 200 (application/json) [GET]
   { 
        "url": "icecold/flavors/vanilla",
        "price_per_scoop": .5,
   }
   { 
        "url": "icecold/flavors/chocolate",
        "price_per_scoop": .5,
   }
   { 
        "url": "icecold/flavors/strawberry",
        "price_per_scoop": .75,
   }
   { 
        "url": "icecold/flavors/peach",
        "price_per_scoop": .75,,
   }
   { 
        "url": "icecold/flavors/oreo",
        "price_per_scoop": .75,
   }
   { 
        "url": "icecold/flavors/java",
        "price_per_scoop": 1.00,
   }
   { 
        "url": "icecold/flavors/mocha",
        "price_per_scoop": 1.00,
   }
   { 
        "url": "icecold/flavors/rainbow",
        "price_per_scoop": 1.25,
   }


## Order [/icecold/orders]

Order management sub-system for the IceCold operation

### Place an order [/icecold/orders]
 
+ Request (application/json) [POST]

  {
    "orders": [
        "flavors": [
           { 
              "flavor": "strawberry",
              "number_scoop": 2
           }
           { 
              "flavor": "java",
              "number_scoop": 1
           }
         ], 
         [ 
           { 
              "flavor": "mocha",
              "number_scoop": 1
           }
         ],
         [ 
           { 
              "flavor": "rainbow",
              "number_scoop": 1
           }
           { 
              "flavor": "oreo",
              "number_scoop": 1
           }
           { 
              "flavor": "chocolate",
              "number_scoop": 1
           }
         ]
     ]
  }

+ Response 201 (application/json) 

  + Headers
        Location:  /icecold/orders/1

  + Body
        { 
          "order_number": 1,
          "order_time": "2015-09-23T00:00:05", 
          "url": "/icecold/orders/1",
          "orders": [
             "flavors": [
                 { 
                   "flavor": "strawberry",
                   "number_scoop": 2
                 },
                 { 
                   "flavor": "java",
                   "number_scoop": 1
                 }
               ], 
               [ 
                 { 
                   "flavor": "mocha",
                   "number_scoop": 1
                 }
               ],
               [ 
                 { 
                   "flavor": "rainbow",
                   "number_scoop": 1
                 }
                 { 
                   "flavor": "oreo",
                   "number_scoop": 1
                 }
                 { 
                   "flavor": "chocolate",
                   "number_scoop": 1
                 }
               ]
             ]




### Get an order  [/icecold/orders/{order_number}]
 
+ Response 200 (application/json) [GET]
  {  
    "order_number": 1,
    "order_time": "2015-09-23T00:00:05"
    "items": [
        "flavors": [
           { 
              "flavor": "strawberry",
              "number_scoop": 2
           }
           { 
              "flavor": "java",
              "number_scoop": 1
           }
         ], 
         [ 
           { 
              "flavor": "mocha",
              "number_scoop": 1
           }
         ],
         [ 
           { 
              "flavor": "rainbow",
              "number_scoop": 1
           }
           { 
              "flavor": "oreo",
              "number_scoop": 1
           }
           { 
              "flavor": "chocolate",
              "number_scoop": 1
           }
        ]
     ]
  } 

## Inventory             

Manages the inventory of the IceCold operation

### Get current inventory [/icecold/inventory]

+ Response 200 (application/json) [GET]

  {
     flavors [
       {
          "flavor": "vanilla",
          "available_scoops": 10
       }
       {
          "flavor": "chocolate",
          "available_scoops": 30
       }
       {
          "flavor": "strawberry",
          "available_scoops": 18
       }
       {
          "flavor": "peach",
          "available_scoops": 20
       }
       {
          "flavor": "oreo",
          "available_scoops": 1
       }
       {
          "flavor": "java",
          "available_scoops": 17
       }
       {
          "flavor": "mocha",
          "available_scoops": 12
       }
       {
          "flavor": "rainbow",
          "available_scoops": 2
       }
    ]
  }

## Stock up the inventory [/icecold/inventory/

+ Request (application/json) [POST]

  {
     "flavors": [
        {
          "flavor": "vanilla",
          "add_scoops": 100
        }
        {
          "flavor": "chocolate",
          "add_scoops": 100
        }
        {
          "flavor": "strawberry",
          "add_scoops": 100
        }
        {
          "flavor": "java",
          "add_scoops": 100
        }
     ]
   }

+ Response 201 (application/json) 

  + Headers
        Location:  /icecold/inventory/

  + Body
        { 
           "url": "/icecold/inventory",
           "current_time: "2015-09-23T13:07:00",
           "flavors": [
           {
              "flavor": "vanilla",
              "available_scoops": 110
           },
           {
              "flavor": "chocolate",
              "available_scoops": 130
           },
           {
              "flavor": "strawberry",
              "available_scoops": 118
           },
           {
              "flavor": "peach",
              "available_scoops": 100
           },
           {
              "flavor": "oreo",
              "available_scoops": 100
           },
           {
              "flavor": "java",
              "available_scoops": 117
           },
           {
              "flavor": "mocha",
              "available_scoops": 80
           },
           {
              "flavor": "rainbow",
              "available_scoops": 100
           },
        ]
    }
         
### Get current inventory for a flavor [/icecold/inventory/{flavor}]

+ Response 200 (application/json) [GET]

  {
     "url": "/icecold/inventory/vanilla",
     "current_time:" "2015-09-23T13:07:48",
     "flavor": "vanilla",
     "available_scoops": 110
  }
