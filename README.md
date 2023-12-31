# F1 API

The Formula 1 API is a Java-based application that retrieves and presents data from the Ergast Developer API (http://ergast.com/mrd/). It provides various endpoints to access information about Formula 1 seasons, tracks, qualifying results, and race results.

## Features
- Retrieve a list of all Formula 1 seasons.
- Get the current list of tracks for the ongoing season.
- Fetch the track list for past seasons.
- Access the current qualifying results.
- Obtain the current race results.

## Getting Started

These instructions will give you a copy of the project up and running on
your local machine for development and testing purposes.

### Prerequisites

Requirements for the software and other tools to build, test and push 
- Java JDK (https://www.oracle.com/ca-en/java/technologies/downloads/)

### Installing

Clone the repository:

```Git clone https://github.com/RyanHaniff/F1_API```

In main.java, create a F1ResultsFactory object:

```F1ResultsFactory factory = new F1ResultsFactory();```
  
Call the createConnection function with the result you want as a string:

```factory.createConnection("latest race results");```
  
  Output:
```  
  ---Latest Race Results---
1       Verstappen
2       Alonso
3       Hamilton
4       Leclerc
5       Sainz
6       Pérez
7       Albon
8       Ocon
9       Stroll
10      Bottas
11      Piastri
12      Gasly
13      Norris
14      Tsunoda
15      Hülkenberg
16      Zhou
17      Magnussen
18      de Vries
19      Russell
20      Sargeant 
```

## Contributing
Contributions to the Formula 1 API are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch.
3. Make your changes and commit them.
4. Push the changes to your fork.
5. Submit a pull request.

## Authors

  - [RyanHaniff](https://github.com/RyanHaniff)

## Acknowledgments

  - [Ergast Developer API](http://ergast.com/mrd/)
