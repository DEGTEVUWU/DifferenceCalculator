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

> Having [Git installed](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

### Installing ###

```
git clone git@github.com:DEGTEVUWU/java-project-61.git
cd java-project-61
make install
```

### To run, use: ###

```
./build/install/app/bin/app [-f required format(not necessary option)] filepeth1 filepeth2
```
### Examples of using ###
![Example of comparing two .json files](https://asciinema.org/a/2mRgNUFUOps5D7ZBa5hmHSP16)  

[Example of comparing two .yml files](https://asciinema.org/a/qVm7XJNQpBSpW0GluDZ8KTI7r)

[Example of comparing two files .yaml and .json in formats with nested structures](https://asciinema.org/a/ZMDinocMXrZkvlVX8IGBpKZnd)  

[An example of working with two different types of data output - stylish and plain](https://asciinema.org/a/UGL1OLKIVzOAfMPY94zqxbyF8)  

[An example of the JSON formatter working with two files in .yaml and .json formats](https://asciinema.org/a/id3Wm3Ludzt9PngZID2rSOP6R)  
