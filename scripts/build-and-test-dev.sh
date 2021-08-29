#!/usr/bin/env bash

cd "${0%/*}" #cd to scripts

./build.sh dev && ./test.sh dev
