# Difference Calculator! #

### Hexlet tests and linter status:

[![Basic Functionality Check](https://github.com/DEGTEVUWU/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/DEGTEVUWU/java-project-71/actions)
[![Actions Status](https://github.com/DEGTEVUWU/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DEGTEVUWU/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/9e47a95bafdd5f09e257/maintainability)](https://codeclimate.com/github/DEGTEVUWU/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/9e47a95bafdd5f09e257/test_coverage)](https://codeclimate.com/github/DEGTEVUWU/java-project-71/test_coverage)

## Description ##

This program will calculate the differences between two files. Acceptable formats for calculating differences are Yaml and Json.

Run the program in the console along with three parameters - 
two file names and the desired way to format the difference. The file name can be either a simple name or an absolute path to the file.

The third parameter is optional.

By default, formatting is in style, there is also a flat format and a json format. Examples of these formats and how the program works - see below in asciinema.

### Requirements ###

#### Having: ####  
> [Git installed](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)  
> [Java](https://www.oracle.com/java/technologies/downloads)  
> [Gradle](https://gradle.org/install)

### Installing ###

```
git clone git@github.com:DEGTEVUWU/DifferenceCalculator.git
cd DifferenceCalculator/app
make install
```

### Common call constructs ###

```
./build/install/app/bin/app [-f required format(not necessary option)] filepeth1 filepeth2
```

### Commands
``` 
./build/install/app/bin/app ./src/main/resources/fixtures/file1.json ./src/main/resources/fixtures/file2.json
./build/install/app/bin/app -f plain./src/main/resources/fixtures/file1.json ./src/main/resources/fixtures/file2.json
./build/install/app/bin/app -f json ./src/main/resources/fixtures/file1.json ./src/main/resources/fixtures/file2.json
```

At the end, the full path to the file from the app folder is indicated; for faster work, an example of three commands is placed in the Makefile; add new commands there with the paths to other files you need. If the -f flag is absent, the default formatter is used - stylish.
```
run-dist stylish:
run-dist plain:
run-dist json:
```

### Examples of using ###
[Example of comparing two .json files](https://asciinema.org/a/2mRgNUFUOps5D7ZBa5hmHSP16)  

[Example of comparing two .yml files](https://asciinema.org/a/qVm7XJNQpBSpW0GluDZ8KTI7r)

[Example of comparing two files .yaml and .json in formats with nested structures](https://asciinema.org/a/ZMDinocMXrZkvlVX8IGBpKZnd)  

[An example of working with two different types of data output - stylish and plain](https://asciinema.org/a/UGL1OLKIVzOAfMPY94zqxbyF8)  

[An example of the JSON formatter working with two files in .yaml and .json formats](https://asciinema.org/a/id3Wm3Ludzt9PngZID2rSOP6R)  
