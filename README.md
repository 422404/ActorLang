# Actor Lang

[![Quality Gates](https://github.com/422404/ActorLang/actions/workflows/quality-gates.yml/badge.svg)](https://github.com/422404/ActorLang/actions/workflows/quality-gates.yml)

A small language I made to give life to the pseudocode one of my teacher used to teach us actor programming.

The language is pretty small so only basic arithmetic and comparisons can be done (and obviously standard actor programming actions). It only supports integers, booleans, strings and actor references.

Examples can be found in [./src/dist/examples](./src/dist/examples).

## Building
```bash
./gradlew build
```

## Executing
Un-tar or un-zip the outputted distributions in `build/distributions/` and execute them like so:
```bash
<unzipped dist>/bin/actorlang <unzipped dist>/examples/counter.actor
```

## Contributing
Please refer to [CONTRIBUTING.md](CONTRIBUTING.md).
