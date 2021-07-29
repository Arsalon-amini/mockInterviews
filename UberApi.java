/*

Prompt: Design Uber API 

Entities: 

Ride : { 
    id: Integer,
    passengerId: Integer,
    driverId: Integer,
    rideStatusId: Integer
    requestTime: timeStamp,
    pickup: Location,
    dropOff: Location,
    price: Integer
}

passenger: {
    id: Integer,
    name: string,
    rating: string
}

driver: {
    id: Integer,
    name: string,
    fiveStarRatings: Integer,
    ridesCompleted: Integer,
    rating: Integer,
    status: Enum [available, busy, availableSoon]
}

rideStatus: {
    id: Integer,
    createdAt: timeStamp,
    matched: boolean,
    inProgress: boolean,
    cancelled: boolean (default=false),
    completed: boolean
}

** Passenger API ***

POST Request: post a ride 
Input: passenger entity, Ride entity 
Output: Ride entity 

Java
public static Ride requestRide(passenger_.id, Location pickUp, Location dropOff){
    //validate args, return any errors
    //create a new Ride entity w/ passenger_.id, pickup/dropoff and store Ride entity in database
    //call a helper method for matching passenger with driver (async operation)
    //return a Ride object w/ driverId
}

JS
const Ride = async (req, res) => {}

GET: receive data on ride 
Input: ride_.id
Output: RideStatus entity

public static RideStatus getRideDetails(Integer ride_.id){
    //query the database asynchronously until RideStatus entity is available
    //return the RideStatus entity
}

DELETE: cancel a ride
Input: ride_.id
Output: Ride entity 

public static Ride cancelRide (Integer ride_.id){
    //helper method async calls driverAPI to inform driver on ride cancellation
    //updates RideStatus entity in DB and ride object
    //returns Ride w/ cancelled status 
}

PUT: update Ride desitionation
Input: ride_.id
Output: Ride entity 

public static Ride updateRide(Integer ride_.id, Location newDestination){
    //call db to set Ride entity location = newDestination
    //return a Ride entity with updated location
}

*** Driver API ****

GET: get a new ride
Input:
Output: Ride entity 

public static Ride getNewRide(Integer driver_.id){
    //query DB using driver_.id to get driver including driver status 
    //query DB table of queued rides
    //calls helper method for confirming the driver will take the available ride
    //returns Ride entity
}

Helper Method: confirm driver, update Ride 

public static void confirmRide(Integer ride_.id, Integer driver_id){
    //requests the drivers confirmation for taking the ride
    //if yes, updates the Ride entity with driverId
    //if no, puts the Ride back into the SQL table for queued rides needing drivers
}

DELETE: cancel a ride by driver
public static Ride cancelRide(Integer ride_.id){
    //gets the Ride entity in DB 
    //updates the RideStatus to Cancelled, restores in DB
    //sends a notification to the user that ride is cancelled
    //puts ride_.id back into the queue for matching with an available driver
}

/*