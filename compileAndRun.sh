#!/bin/bash
# requires java, javac. 

chmod +x compile
chmod +x clean
./compile
java -ea Tester
./clean
