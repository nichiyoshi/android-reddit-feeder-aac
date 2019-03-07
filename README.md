# android-reddit-feeder-aac
Demo application of [Reddit](https://www.reddit.com/hot) news feeder with Android Architecture Components, for self-learning.

I'm trying to follow the pattern of [todo-mvvm-live-kotlin](https://github.com/googlesamples/android-architecture/tree/todo-mvvm-live-kotlin/) in [Android Architecture Blueprints](https://github.com/googlesamples/android-architecture).

Anybody can install this app from Deploygate below.
[<img src="https://dply.me/7vcood/button/large" alt="Try it on your device via DeployGate">](https://dply.me/7vcood#install)

**NOTE**

This app is still in progress!! So currently, this app just enable you to fetch "hot" reddit news.

## Techs

- **Retrofit**
- **Coroutine**
- **ViewModel(AAC)**
- **LiveData(AAC)**
- **Data Binding(Jet Pack)**

## Planning Functions

- save data to local database as cache(**Room** of AAC)
- navigate to detail page(**Navigation** of Jet Pack)
- save articles, toggle all or only saved articles
- rotation-aware(**lifecycle-aware-conponents**)
- continuous delivery system (Jenkins or Bitrise or... with Deploygate)


