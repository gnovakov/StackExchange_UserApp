# Stack Exchange user App

## App Description

The app allows a user to search for StackExchange users by name displaying up to 20 results per search organised alphabetically and show their reputation and username. Upon tap the app display more information about the user.

## The Challenge
<img src="https://media.giphy.com/media/bOsSDOGRQ2foUjzydd/giphy.gif" width="300" align="right" hspace="20">
I was asked to build an app from scratch that:

- Displays an input field and Button to search for users by name.
- Displays up to 20 users alphabetically and shows their reputation and usernames.
- When a user is tapped, open a new `Activity` to display more information about the user.



## Technical Details

#### Retrieving Data from Api upon Search

- When the user opens the app the screen is blank waiting for the user to search
- The Api does not return data until the user has pressed the search button


#### RxJava & Coroutines

- I built both a Coroutines version of the app located in the Coroutines Branch and an RxJava version located in the master branch, the reason for this was I had just recently learned coroutines, it was fresh in my mind and I wanted to add it to a new app I was working on.


#### If I Had More Time I would...

- Implement UI testing
- Improve the look of the UI
- Try Koin Dependency Injection 

## Tech-Stack
- Kotlin
- Dagger 2 (For Dependency Injection)
- RxJava (For Managing Background Tasks)
- Coroutines (For Managing Background Tasks - in a separate Branch)
- Retrofit (For Networking)
- JetPack
    - ViewModel (For managing UI related data in a lifecycle conscious way)
    - LiveData (For notifying views of data changes)
- Picasso (For displaying images)
- Architecture
    - MVVM

