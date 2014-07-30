[![Build Status](https://travis-ci.org/andlar/balance.svg?branch=master)](https://travis-ci.org/andlar/balance)
[![Coverage Status](https://coveralls.io/repos/andlar/balance/badge.png)](https://coveralls.io/r/andlar/balance)

# Balance

Balance displays your day(s) in colors, where each block represents one hour of time spent mainly doing one particular type of action (e.g., primary work, fun & relaxation, sleep, etc.). It averages your daily entries to show what your average day looks like, optionally only averaging work days, or weekends, or other ranges of time.

Balance is an ativity tracker as well, with you marking when you start or stop a particular type of activity, and Balance will figure out what color any given block should then be marked with.

Future refinements include ways of marking a single hour with multiple activities, either because you're doing two things at once, or you did two (or more things) for equal times during that hour.

## Installation

Download from https://github.com/andlar/balance

## Usage

Simply start the application, and start tracking time using the buttons at the top of the window. You can edit past entries using the date selector at the bottom of the window. Choose a date, then select, from the dropdowns, what you did on each of the given hours.

    $ java -jar balance-0.1.0-standalone.jar [args]

## Options

No options are currently available.

## Examples

...

### Bugs

Still to do:
 * Some sort of database backend
 * Lots of GUI work
 * Web-applet / android/iphone app?
 * Better data model

## License

Copyright © 2014, Andrew Larned

Distributed under the Eclipse Public License, the same as Clojure.
