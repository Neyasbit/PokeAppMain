# PokeApp for Sibers

This is a client server application for testing for the Android operating system.

  
> The application works 
> with the API server
>  which is located at the link:
> https://pokeapi.co/ 

### Demonstration
- The start screen contains a list of 30 Pokemon with a name and their image. 
 ![](30poke.gif)
- When you click on a single item in the list, detailed information about a specific Pokemon will be displayed, containing the fields: height (height), weight (weight), gender of the Pokemon, information (stats; include fields of attack, defense, hp). 
 ![](detail_poke.gif)
- Page-by-page loading of Pokemon list items while scrolling the list when it reaches the end loads the next 30 items and displays them in the list.
![](load_more.gif)
- In case of pressing the button on the main screen, the list of Pokémon will be reinitialized with the start on an arbitrary item from the Pokémon database on the server.
- ![](random.gif)
