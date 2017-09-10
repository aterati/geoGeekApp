# geoGeekApp - Search anything explore anyplace.

## Application Goal:
This application's main aim is to provide a single medium to explore any city, check the weather, search for places of interest 
or even find a good place to dine in. With a single search the user will get results displayed from three major websites. 


## Technical Description:
This application demonstrates the implementation of Spring REST and Spring BOOT modules. 

* The Application accepts REST web service calls and has URL mappings defined to accept city name as parameter.

* User can search for any city name.

* The application will make web service call to external interfaces to gather information about the current weather, places of interest and
  restaurants around this place.
  
* The gather information is parsed using the custom JSON parsing logic and display the combined results to the user.

## ** Still a work in progress

* Currently with this initial commit, the application backend project struture is ready and REST controllers are defined and are capable
  to accept a city name and display weather information in a JSON format.
  
