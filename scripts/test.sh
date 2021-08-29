#!/usr/bin/env bash

cd "${0%/*}" #cd to scripts
# shellcheck disable=SC2103
cd ..
profile=-P"$1"

mvn test "$profile"
