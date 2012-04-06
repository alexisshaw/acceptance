#!/bin/bash
# requires java, javac.
# Copyright (C) 2012    Lasath Fernando (@lasath.fernando)

. compile

CLASSPATH="$BUILD_DIR" java -ea framework.Tester

