Language syntax
===============

Comments
--------

Comments can be added into code like so::

    /* a comment */

    /* A
     * multi-line
     * comment
     */

Basic types
-----------

* Integers:``10``, ``-42``, ``+1337``
* Strings: ``"Hello, world!"``
* Booleans: ``true``, ``false``

Maths
-----

Basic maths are supported so you can do arithmetic or boolean logic::

    1 + 1
    b * b - 4 * a * c
    (1 + 2) * 3
    true || false
    true || false && myVar
    x % 2 == 0

String concatenation
--------------------

Simply «add» any value to a string to concatenate it::

    "Hello" + "world!" --> "Helloworld!"
    "2 + 2 is " + 4    --> "2 + 2 is 4"
    "This is " + false --> "This is false"

Conditional execution
---------------------

.. code-block::

    if (x == y) {
        ...
    }

    if (x < y) {
        ...
    } else {
        ...
    }

Loops
-----

.. code-block::

    for (i in 0..10) {
        ...
    }

Iterates in a range from 0 to 10 (inclusive).

You can also iterate on decreasing values:

.. code-block::

    for (i in 10..0) {
        ...
    }

Iterates in a range from 10 to 0 (inclusive).

You can use «complex» expressions for the range bounds:

.. code-block::

    for (i in start..(a + b)) {
        ...
    }

Printing data
-------------

.. code-block::

   display "hello";
   display (1 + 2) * 3;
   display true || false && true;

Prints three lines::

    hello
    9
    true

To print values without new lines, you can use:

.. code-block::

   put "hello"
   put 42


Prints::

    hello42

Defining functions
------------------

Functions can be defined following this pattern::

    fun <function name> (<arg 1>, ..., <arg N>) = <expression> | <statements>

Example:

.. code-block::

   fun mul(x, y) = x * y;

   fun print(s) = {
       display s
   };

   fun spawnActor(x) = {
       a = create Actor(x);
       return a
   }

Functions can be called as part of expressions or with the ``call`` statement::

    fun print(value, printer) = send [value] to printer;

    Printer () [value] = display value;
    p = create Printer ();

    v = F(x, y) * H(y) + x;
    call print(v, p)

Actor behavior definition
-------------------------

An actor behavior definition follows this pattern::

    <actor type> (<state var1>, <state varN>) [<message item1>, <message itemN>] = <statements>

A behavior is executed when a message matching a pattern is received by an actor.

Example:

.. code-block::

    MyActor () [item1] = display item1;

    MyActor (State) [item1, item2] = {
        display item1;
        display item2;
    };

Tagged messages
---------------

To enable calling the right behavior of an actor with multiple behaviors of the same arity, one can tag the messages with literal values in the patterns.

Example:

.. code-block::

    MyActor () ["display-one"] = display 1;
    MyActor () ["display-two"] = display 2;

These behaviors will be executed on receiving a message containing either ``"display-one"`` or ``"display-two"``.

Changing behavior
-----------------

An actor can change its type (and so its behavior) based on a received message:

.. code-block::

    Empty ()  ["set", x] = become Full (x);

    Full (X) ["get", sender] = {
        send [X] to sender;
        become Empty ()
    };

Sending messages
----------------

.. code-block::

    send [42] to anActor;

    send ["hello", 1337] to anotherActor;

Actor self reference
--------------------

In a behavior, the ``self`` variable is a reference to the actor executing the code.

Creating actors instances
-------------------------

Instantiating an actor from a given type with a given state (e.g. ``MyActor (42)``) is done like so:

.. code-block::

    myInstantiatedActor = create MyActor (42);

