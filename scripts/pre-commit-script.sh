#!/usr/bin/env bash

cd "${0%/*}" #cd to scripts
# shellcheck disable=SC2103
cd ..

circleci config validate
