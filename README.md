# FixedQueue

A Kotlin library that offers a FixedQueue for use.

## FixedQueue?

A FixedQueue is a queue that only accepts a fixed number of items. When the queue is full and an item is offered, the queue will remove the oldest item in order to add the one being offered.

### Alright, so that's...cool. But why, though?

Well...I needed this functionality and it doesn't exist in the standard Kotlin/Java libraries. I know Apache and Guava have it but I mean, those are HUGE. I don't have time for that!

### Is that even the right name for this type of collection?

Maybe. If not, I'll change it. Actually, I probably won't. But maybe.

## Getting Started

Simply check out this project and import it into Android Studio! Gradle and Android Studio should take care of the rest!

### As A Dependency

In your root `build.gradle`:

```
allprojects {
        repositories {
                ...
                maven { url 'https://jitpack.io' }
        }
}
```

In your app `build.gradle`:

```
depencencies {
        ...
        implementation 'com.github.wardellbagby:FixedQueue:0.1.0'
}
```

### Using

```kotlin
    //Creates a FixedQueue with a max size of 500.
    val queue = FixedQueue<Int>(500)
    (0..1000).forEach {
        queue.offer(it)
    }
    println(queue.size) //Prints out 500
```

### Building

You can build this lib using:

```
./gradlew build
```

## Running the tests

Unit tests can be run with:

```
./gradlew check
```

### Code Style

This app uses [ktlint](https://ktlint.github.io/) for enforcing style constraints. Most ktlint errors can be fixed by running

```
./gradlew ktlintFormat
```

but not all. ktlint will output to console any errors it encounters.

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for the process for submitting pull requests to this project.

## License

This project is licensed under the LGPL-3.0 License - see the [LICENSE](LICENSE) file for details

## Acknowledgments
* Props to the [Sona Pona](https://github.com/wardellbagby/sona-pona) for being the app I needed to make this lib for!
