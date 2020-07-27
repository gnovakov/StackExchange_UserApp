# Android Coding Task

## App Description

The app allows a user to search for StackExchange users by name displaying up to 20 results per search organised alphabetically and show their reputation and username. Upon tap the app display more information about the user.

## The Challenge

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

## Libraries

- Networking; Moshi, okHttp, Retrofit, RxJava (Coroutines in a seperate Branch)
- Dependency Injection: Dagger 2
- Architecture: MVVM, LiveData

