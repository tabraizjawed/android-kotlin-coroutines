
# Learn Kotlin Coroutines by real examples for Android

## About this project:

* This project is for someone who wants to get started with Kotlin Coroutines.
* I have tried to add the examples we implement in our Android project frequently.

##  Kotlin Coroutines project:

* Step by step guide on how to implement the Kotlin Coroutines in Android.
* Doing simple task in background using Kotlin Coroutines.
* Doing tasks in series using Kotlin Coroutines.
* Doing tasks in parallel using Kotlin Coroutines.
* Making two network calls in parallel using Kotlin Coroutines.
* What are scopes in Kotlin Coroutines?
* Canceling background task using Kotlin Coroutines.
* Exception handling in Kotlin Coroutines.
* Using Kotlin Coroutines with Retrofit.
* Using Kotlin Coroutines with Room Database.
* Using Kotlin Coroutines with various 3rd party libraries.
* Adding timeout to a task using Kotlin Coroutines.
* Writing Unit-Test for ViewModel which uses Kotlin Coroutines.

## Kotlin Coroutines Examples for Android Development: Activity and ViewModel

* **Single Network Call:** Learn how to make a network call using Kotlin Coroutines. This is a very
  simple use-case in Android App Development.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/single/SingleNetworkCallActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/single/SingleNetworkCallViewModel.kt)

* **Series Network Calls:** Learn how to make network calls in series using Kotlin Coroutines. This
  is useful when you want to make a network call which is dependent on an another network call.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/series/SeriesNetworkCallsActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/series/SeriesNetworkCallsViewModel.kt)

* **Parallel Network Calls:** Learn how to make network calls in parallel using Kotlin Coroutines.
  This is useful when you want to make network calls in parallel which are independent of each
  other.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/parallel/ParallelNetworkCallsActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/parallel/ParallelNetworkCallsViewModel.kt)

* **Room Database Operation:** Learn how to fetch or insert entity in database using Kotlin
  Coroutines. This is useful when you are using Room Database in your Android Application.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/room/RoomDBActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/room/RoomDBViewModel.kt)

* **Long Running Task:** Learn how to run a long running task using Kotlin Coroutines. If you want
  to do any of your task in background thread using the Kotlin Coroutines, then this is useful.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/task/onetask/LongRunningTaskActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/task/onetask/LongRunningTaskViewModel.kt)

* **Two Long Running Tasks:** Learn how to run two long running tasks in parallel using Kotlin
  Coroutines.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/task/twotasks/TwoLongRunningTasksActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/task/twotasks/TwoLongRunningTasksViewModel.kt)

* **Timeout:** Learn how to add timeout to a task using Kotlin Coroutines. If you want to add a
  timeout to any of your background task in Android, this is going to super useful.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/timeout/TimeoutActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/timeout/TimeoutViewModel.kt)

* **Try-Catch Error Handling:** Learn how to handle error in Kotlin Coroutines using Try-Catch.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/errorhandling/trycatch/TryCatchActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/errorhandling/trycatch/TryCatchViewModel.kt)

* **CoroutineExceptionHandler:** Learn how to handle error in Kotlin Coroutines using
  CoroutineExceptionHandler.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/errorhandling/exceptionhandler/ExceptionHandlerActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/errorhandling/exceptionhandler/ExceptionHandlerViewModel.kt)

* **Ignore Error And Continue:** Learn how to
  use [`supervisorScope`] to ignore
  error of a task and continue with other task. In other words, if more than two child jobs are
  running in parallel under a supervisor, one child job gets failed, we can continue with other.
    * [Activity Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/errorhandling/supervisor/IgnoreErrorAndContinueActivity.kt)
    * [ViewModel Code](app/src/main/java/me/tabraiz/learn/kotlin/coroutines/ui/errorhandling/supervisor/IgnoreErrorAndContinueViewModel.kt)

* **Unit Test:** Learn how write unit-test for ViewModel which uses Kotlin Coroutines.
    * [ViewModelTest Code](app/src/test/java/me/tabraiz/learn/kotlin/coroutines/ui/retrofit/single/SingleNetworkCallViewModelTest.kt)

## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v:

### License
```
   Copyright (C) 2023 Tabraiz Jawed

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
``` 

