# Personal Log

The idea for this app, is an app that lets you make voice logs like on star trek. After the log is recorded, message is converted to text and can be read or listened to.
The logs are also sorted by date. All logs can be downloaded as a zip file. 

The recordings should be secure, they are personal. I believe however that they will need to be associated with an account for practicality. 
Perhaps some form of encryption will be required. I could encrypt the personal logs of everyone that uses the app before storage using a hash of the password as
the encryption key. It would be very difficult to access without a proper password. 


## Example Logs

Example Log: Kitchen log, I've identified the problem with my keychup recipe. It seems there was too much sweetener and less sugar was required. Over. 

Example Log: Personal log, I went to get some spaghetti today. It was mom's spaghetti, the best spaghetti. Over.

Example Log: Potato log, I don't like french fries enymore it's very bizarre. Over. 

## Setup

- System
  - Client
    - Web Frontend
    - Mobile Frontend
  - Data Access
    - Storage
    - Database
    - Access Layer or microservice
  - Speech Analysis
    - Speech to text
    - Text analysis 
  - Authentication

## Architecture

I don't think I need to worry too much about this. A monolith makes the most sense and if there are significant issues I can break it up. The app as it is shouldn't need microservices or event driven stuff. 

## Frameworks

- Backend Spring
- Frontend React Native
- The build should produce 4 builds eventually. 1 for the Web, 1 for backend, 1 for android. IOS will need to wait until I have an ios device.




