# Moonraker Analytics #

This is an analytics engine experiment built in Scalatra. It mimics Google Analytics, with limited functionality. It's based on the Jumpstart Lab tutorial for [Traffic Spy](http://tutorials.jumpstartlab.com/projects/traffic_spy.html)

## Build & Run ##

```sh
$ cd Moonraker_Analytics
$ ./sbt
> container:start
> ~ ;copy-resources;aux-compile
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
