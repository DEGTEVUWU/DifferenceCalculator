.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

plain:
	./build/install/app/bin/app -f plain ./src/main/resources/fixtures/file1.json ./src/main/resources/fixtures/file2.json

json:
	./build/install/app/bin/app -f json ./src/main/resources/fixtures/file1.json ./src/main/resources/fixtures/file2.json

stylish:
	./build/install/app/bin/app ./src/main/resources/fixtures/file1.json ./src/main/resources/fixtures/file2.json


run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

check-deps:
	./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build
